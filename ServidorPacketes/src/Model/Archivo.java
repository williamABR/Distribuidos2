/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author williambaquero
 */
public class Archivo {
    public String nombre;
    public List<String> maquinas;

    public Archivo(String nombre) {
        this.nombre = nombre;
        this.maquinas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getMaquinas() {
        return this.maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas.add(maquinas);
    }
}
