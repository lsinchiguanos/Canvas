/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvasserver;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Lemmar Dell
 */
public class CanvasServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    
}