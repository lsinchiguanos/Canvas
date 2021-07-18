/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemmar.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Lemmar Dell
 */
public class ConexionRMI {

    IEExportaCliente exportar;

    public ConexionRMI() {
        try {
            Registry r = LocateRegistry.getRegistry("127.0.0.1", 9000);
            exportar = (IEExportaCliente) r.lookup("rmi://localhost:2000/canvasserver");
        } catch (NotBoundException | RemoteException e) {
        }
    }

    public String expor(String nombre, String formato, String datos) {
        String resultado = "";
        try {
            resultado = exportar.enviarExportar(nombre, formato, datos);
        } catch (RemoteException e) {
        }
        return resultado;
    }
}
