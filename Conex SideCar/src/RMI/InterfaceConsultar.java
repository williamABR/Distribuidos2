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
public interface InterfaceConsultar extends Remote{
    
    public List<String> obtenerDireccion(String nombreArchivo)  throws RemoteException;
    
    public void guardarArchivo(String nombre, String ip)  throws RemoteException;
    
    public int cantArchivos()  throws RemoteException;
    
    public List<String> ArchivosRepositorio() throws RemoteException;
    
    public void eliminarArchivos(String ip, List<String> archivos) throws RemoteException;
    
}
