/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodistri2;

import GUI.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author williambaquero
 */
public class ProyectoDistri2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
      String cadena;
      ArrayList<String> informacion = new ArrayList<String>();
      String archivos[]={"prueba1.txt","prueba2.txt","prueba3.txt"};
      for(int i = 0 ; i<archivos.length ; i++){
        FileReader f = new FileReader(archivos[i]);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            informacion.add(cadena);
        }
        b.close();
      } 
      Principal vista = new Principal();
      vista.show();
    }
    
}
