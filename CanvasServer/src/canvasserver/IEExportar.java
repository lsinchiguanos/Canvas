/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvasserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lemmar Dell
 */
public interface IEExportar extends Remote {

    String enviarExportar(String nombre, String formato, String datos) throws RemoteException;
}
