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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lemmar Dell
 */
public class ConexionRMI {

    IEExportar exportar;

    public ConexionRMI() {
        try {
            Registry r = LocateRegistry.getRegistry("127.0.0.1", 9090);
            exportar = (IEExportar) r.lookup("rmi://localhost:3000/canvasserver");
        } catch (NotBoundException | RemoteException e) {
            Logger.getLogger(ConexionRMI.class.getName()).log(Level.SEVERE, null,e);
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
