/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author williambaquero
 */
public interface InterfaceDescargar extends Remote{
    
    public void recibirArchivo(List<String> contenido, String nombre) throws RemoteException;
    
    public List<String> descargarLineas(int min, int max, String nombre) throws RemoteException;
}
