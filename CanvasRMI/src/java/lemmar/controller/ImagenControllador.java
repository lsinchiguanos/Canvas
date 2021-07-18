/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lemmar.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Lemmar Dell
 */
public class ImagenControllador implements IEExportar {

    public ImagenControllador() {
    }

    @Override
    public String enviarExportar(String nombre, String formato, String datos) throws RemoteException {
        String[] strings = datos.split(",");
        String ruta = new File("src").getAbsolutePath() + "\\img";
        byte[] dataImg = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = ruta + "\\" + nombre + "." + formato;
        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(dataImg);
        } catch (Exception e) {
        }
        return "éxitoso";
    }
}
