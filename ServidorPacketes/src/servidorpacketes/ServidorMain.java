/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpacketes;

import RMI.InterfaceConsultar;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author williambaquero
 */
public class ServidorMain {
    
    public static void main(String[] args)throws RemoteException, MalformedURLException, InterruptedException{
        InterfaceConsultar consultar = new ServerObjectRMI();
        Registry registro = LocateRegistry.createRegistry(12743);
        registro.rebind("rConsultar", consultar);
        while(true){
            System.out.println("En el servidor se encuentran Registrados "+consultar.cantArchivos()+" archivos");
            Thread.sleep(1000);
        }
    
    }
    
}
