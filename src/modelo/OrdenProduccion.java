/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import repositorio.Repositorio;

/**
 *
 * @author Jose
 */
public class OrdenProduccion {
    private int numeroOrden;
    private int objetivo = 500;
    private Modelo modelo;
    private Color color;
    private EstadoOrden estadoOrden;
    private LineaProduccion lineaProduccion;
    private Usuario supervisorLinea;
    private ArrayList<PeriodoFuncionamiento> periodos;
 
    public OrdenProduccion(){
       this.periodos = new ArrayList<>();
    }

    public final void iniciarNuevoPeriodo(){
        periodos.add(new PeriodoFuncionamiento(Repositorio.getHora()));
    }
    
    public final void finalizarPeriodoActual(){
        PeriodoFuncionamiento p = periodos.get(periodos.size() - 1);
        p.sethFinal(Repositorio.getHora());
    }
    
//    private int generarHorario(){
//        Calendar c = new GregorianCalendar();
//        return (int)c.get(Calendar.HOUR_OF_DAY);
//    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public boolean setEstadoOrden(EstadoOrden estadoOrden){
        boolean resultado = true;
        if(estadoOrden == EstadoOrden.PROCESO){
            if(controlarTurno()){
               iniciarNuevoPeriodo();
               this.estadoOrden = estadoOrden;
            }else{
                resultado = false;
            }
        }else{
            finalizarPeriodoActual();
            this.estadoOrden = estadoOrden;
        }
        
        return resultado;
    }
    
    public boolean controlarTurno(){
        int horaInicioOrden = Repositorio.getHora();
        boolean resultado = false;
        
        for(Turno turno: Repositorio.getTurnos()){
        if(horaInicioOrden>=turno.getHoraInicio() && horaInicioOrden<=turno.getHoraFin()){
            resultado = true;
            }
        }
        return resultado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LineaProduccion getLineaProduccion() {
        return lineaProduccion;
    }

    public void setLineaProduccion(LineaProduccion lineaProduccion) {
        this.lineaProduccion = lineaProduccion;
        lineaProduccion.setEstadoLinea(EstadoLinea.OCUPADA);
    }

    public Usuario getSupervisorLinea() {
        return supervisorLinea;
    }

    public void setSupervisorLinea(Usuario supervisorLinea) {
        this.supervisorLinea = supervisorLinea;
    }

    public ArrayList<PeriodoFuncionamiento> getPeriodos() {
        return periodos;
    }
    
    public PeriodoFuncionamiento obtenerUltimoPeriodo(){
        return periodos.get(periodos.size()-1);
    }

    public void setPeriodos(ArrayList<PeriodoFuncionamiento> periodos) {
        this.periodos = periodos;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }
    
    
    
    @Override
    public String toString() {
        return "OrdenProduccion{" + "numeroOrden=" + numeroOrden + ", modelo=" + modelo + ", color=" + color + ", estadoOrden=" + estadoOrden + ", lineaProduccion=" + lineaProduccion + '}';
    }
    
    
}
