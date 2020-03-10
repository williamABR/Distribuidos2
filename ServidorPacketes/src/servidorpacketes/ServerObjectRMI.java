/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpacketes;

import Model.Archivo;
import RMI.InterfaceConsultar;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author williambaquero
 */
public class ServerObjectRMI extends UnicastRemoteObject implements InterfaceConsultar{
    public List<Archivo> servidor;

    public ServerObjectRMI() throws RemoteException{
        this.servidor = new ArrayList();
    }

    @Override
    public List<String> obtenerDireccion(String nombreArchivo){
        for(Archivo aux: this.getServidor()){
            if(aux.getNombre().equals(nombreArchivo)){
                System.out.println("Se esta descargando en que maquina se encuentra el archivo "+nombreArchivo);
                return aux.getMaquinas();
            }
        }
        return null;
    }

    @Override
    public void guardarArchivo(String nombre, String ip){
        boolean bandera = true;
        Archivo aux = new Archivo(nombre);
        for(Archivo i:servidor){
            boolean bandera2 = false;
            if(i.getNombre().equals(nombre)){
                bandera = false;
                for(String b:i.getMaquinas()){
                    if(b.equals(ip)){
                        bandera2 = true;
                        break;
                    }
                }
                if(!bandera2){i.maquinas.add(ip);System.out.println("Se agrego a la maquina con la ip: "+ip+" el archivo "+nombre);}
                break;
            }
        }
        if(bandera){
        aux.maquinas.add(ip);
        this.setServidor(aux);
        System.out.println("Se agrego el archivo "+nombre+" desde la ip: "+ip);
        }
    }

    public List<Archivo> getServidor() {
        return servidor;
    }

    public void setServidor(Archivo e) {
        this.servidor.add(e);
    }

    @Override
    public int cantArchivos(){
        return this.getServidor().size();
    }

    @Override
    public List<String> ArchivosRepositorio() throws RemoteException {
       List<String> aux = new ArrayList();
       for(Archivo i:this.servidor){
           if(i.maquinas.size()>0){
              aux.add(i.getNombre());
           }
       }
       return aux;
    }

    @Override
    public void eliminarArchivos(String ip, List<String> archivos) throws RemoteException {
        for(String aux:archivos){
            for(int i=0;i<this.servidor.size();i++){
                if(this.servidor.get(i).nombre.equals(aux)){
                    this.servidor.get(i).maquinas.remove(ip);
                }
                if(this.servidor.get(i).maquinas.size()==0){
                    this.servidor.remove(i);
                    System.out.println("Se Borro la referencia del archivo "+aux+" desde la ip: "+ ip);
                }
            }
        }
    }

   
    
    
}
