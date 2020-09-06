/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jose
 */
public class LineaProduccion {
    private final int numeroLinea;
    private EstadoLinea estadoLinea;
    
    public LineaProduccion(int numeroLinea){
        this.numeroLinea = numeroLinea;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public EstadoLinea getEstadoLinea() {
        return estadoLinea;
    }

    public void setEstadoLinea(EstadoLinea estadoLinea) {
        this.estadoLinea = estadoLinea;
    }
}
