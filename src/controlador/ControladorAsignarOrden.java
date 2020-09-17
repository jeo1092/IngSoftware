/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import repositorio.Repositorio;
import vista.*;
import modelo.*;
import controlador.*;

/**
 *
 * @author Jose
 */
public class ControladorAsignarOrden implements ActionListener{
    VistaAsignarOP vistaAsignarOP;
    private static OrdenProduccion ordenElegida;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorCalidad.BTN_ASIGNAR_ORDEN)){
            vistaAsignarOP = new VistaAsignarOP();
            vistaAsignarOP.setControlador(this);
            vistaAsignarOP.ejecutar();
            setDatosVista();
        }
        
        if(e.getActionCommand().equals(vistaAsignarOP.BTN_CONFIRMAR)){
            int numOrdenElegida = vistaAsignarOP.getOrden();
            ordenElegida = Repositorio.obtenerOPporNumero(numOrdenElegida);
            ordenElegida.obtenerUltimoPeriodo().setUsuario(ControladorAutenticacion.getSupervisorLinea());
        }
    }

    public static OrdenProduccion getOrdenElegida() {
        return ordenElegida;
    }
    
    
    private void setDatosVista(){
        ArrayList<String[]> filas = new ArrayList<>();
        for(OrdenProduccion op : Repositorio.getOrdenes()){
            if((op.getEstadoOrden().equals(EstadoOrden.PROCESO) || op.getEstadoOrden().equals(EstadoOrden.PAUSA)) && op.obtenerUltimoPeriodo().getUsuario() == null){
                String[] datos = {op.getLineaProduccion().getNumeroLinea()+"",op.getNumeroOrden()+"",op.getModelo().getDescripcion(),op.getColor().getDescripcion(),op.getEstadoOrden().name()};
                filas.add(datos);
            }
            vistaAsignarOP.cargarLista(filas);
        }
    }
    
}