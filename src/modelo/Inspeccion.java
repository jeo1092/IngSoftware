/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jose
 */
public class Inspeccion {
    private ArrayList<Defecto> defectos;
    private Calidad calidad;
    private int horario;
    private Pie pie;

    public Inspeccion() {
        this.defectos = new ArrayList<>();
        this.horario = generarHorario();
    }
    
    public void agregarDefecto(Defecto defecto){
        defectos.add(defecto);
    }
    
    private int generarHorario(){
        Calendar c = new GregorianCalendar();
        return c.get(Calendar.HOUR_OF_DAY);
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

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }
}
