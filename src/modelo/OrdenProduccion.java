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
public class OrdenProduccion {
    private final int numeroOrden;
    private final Modelo modelo;
    private final Color color;
    private EstadoOrden estadoOrden;
    private final LineaProduccion lineaProduccion;
    private final ArrayList<PeriodoFuncionamiento> periodos;
    
    public OrdenProduccion(int numeroOrden, Modelo modelo, Color color, LineaProduccion lineaProduccion) {
        this.numeroOrden = numeroOrden;
        this.modelo = modelo;
        this.color = color;
        this.estadoOrden = EstadoOrden.PROCESO;
        this.lineaProduccion = lineaProduccion;
        this.periodos = new ArrayList<>();
        iniciarPeriodo();
    }
    
    public final void iniciarPeriodo(){
        periodos.add(new PeriodoFuncionamiento(generarHorario()));
    }
    
    public final void finalizarPeriodoActual(){
        PeriodoFuncionamiento p = periodos.get(periodos.size() - 1);
        p.sethFinal(generarHorario());
    }
    
    private int generarHorario(){
        return 1;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
    
    
}
