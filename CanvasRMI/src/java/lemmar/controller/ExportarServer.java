/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemmar.controller;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import lemmar.controller.ImagenControllador;
import lemmar.controller.IEExportar;

/**
 *
 * @author Lemmar Dell
 */
public class ExportarServer implements IEExportar {

    public ExportarServer() {
    }

    public static void main(String args[]) {
        try {
            ImagenControllador controllador = new ImagenControllador();
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Remote stub = UnicastRemoteObject.exportObject(controllador, 9000);
            Registry registry = LocateRegistry.createRegistry(9000);
            registry.bind("rmi://localhost:2000/canvasserver", stub);
            System.out.println("inicio del servidor");
        } catch (AlreadyBoundException | RemoteException e) {
        }
    }

    @Override
    public String enviarExportar(String nombre, String formato, String datos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
