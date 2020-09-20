/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import modelo.OrdenProduccion;
import vista.VistaHermanar;

/**
 *
 * @author Jose
 */
public class ControladorHermanar implements ActionListener{
    VistaHermanar vistaHermanar;
    OrdenProduccion ordenEnCurso;
    
    public ControladorHermanar(OrdenProduccion ordenEnCurso){
        this.ordenEnCurso = ordenEnCurso;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaHermanar.BTN_REGISTRO_PRIMERA)){
            Inspeccion nuevaInspeccion = new Inspeccion();
            nuevaInspeccion.setCalidad(Calidad.PRIMERA);
            ordenEnCurso.obtenerUltimoPeriodo().agregarInspeccion(nuevaInspeccion);
            ControladorMostrarDatos.buscarproduccionPrimera(ordenEnCurso);
        }
        
        if(e.getActionCommand().equals(vistaHermanar.BTN_REGISTRO_SEGUNDA)){
            Inspeccion nuevaInspeccion = new Inspeccion();
            nuevaInspeccion.setCalidad(Calidad.SEGUNDA);
            ordenEnCurso.obtenerUltimoPeriodo().agregarInspeccion(nuevaInspeccion);
        }
    }
    
}
