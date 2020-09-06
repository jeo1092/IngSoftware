/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class Inspeccion {
    private ArrayList<Defecto> defectos;
    private Calidad calidad;
    private int horario;

    public Inspeccion() {
        this.defectos = new ArrayList<>();
        this.horario = generarHorario();
    }
    
    public void agregarDefecto(Defecto defecto){
        defectos.add(defecto);
    }
    
    private int generarHorario(){
        return 1;
    }

    public ArrayList<Defecto> getDefectos() {
        return defectos;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }

    public int getHorario() {
        return horario;
    }
  
}
