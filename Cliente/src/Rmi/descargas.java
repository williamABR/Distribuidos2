/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rmi;

import Model.Archivo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author williambaquero
 */
public class descargas extends UnicastRemoteObject implements RMI.InterfaceDescargar {
    
    public List<Archivo> servidor;
    public int contador = 0;

    public descargas() throws RemoteException{
        this.servidor = new ArrayList();
    }
    
    @Override
    public void recibirArchivo(List<String> contenido, String nombre) throws RemoteException {
        Archivo aux = new Archivo(nombre);
        aux.contenido = contenido;
        this.servidor.add(aux);
        System.out.println("Se recibio el archivo "+nombre);
    }

    @Override
    public List<String> descargarLineas(int min, int max, String nombre) throws RemoteException {
        contador++;
        System.out.println(contador);
        List<String> linea = new ArrayList();
        for(Archivo aux:this.servidor){
            System.out.println(aux.getNombre()+"---"+nombre);
            if(aux.nombre.equals(nombre)){
                for(int i=min ; i<=max ; i++){
                    if(contador==7){
                        System.out.println("entro");
                        linea.add("132135154f8s44fghs486gh4");
                    }else{
                        System.out.println("no ha entrado");
                        linea.add(aux.contenido.get(i));
                    }
                }
                break;
            }
        }
        System.out.println("fueron descargadas algunas lineas del archivo "+nombre);
        return linea;
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
