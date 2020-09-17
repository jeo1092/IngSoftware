/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import repositorio.Repositorio;
import vista.VistaPrincipalSupervisorCalidad;
import vista.VistaRegistrarDefectos;
import modelo.*;

/**
 *
 * @author Jose
 */
public class ControladorRegistrarDefecto implements ActionListener {
    VistaRegistrarDefectos vistaRegistrarDefectos;
    OrdenProduccion ordenInspeccionada;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorCalidad.BTN_REALIZAR_INSPECCION)){
            if(Repositorio.obtenerOPporSupCalidad(ControladorAutenticacion.getSupervisorCalidad()) != null){
                vistaRegistrarDefectos = new VistaRegistrarDefectos();
                vistaRegistrarDefectos.setControlador(this);
                vistaRegistrarDefectos.ejecutar();
            }else{
                JOptionPane.showMessageDialog(null, "no tiene asignada una orden de produccion");
            }
            
        }
        
        if(e.getActionCommand().equals(VistaRegistrarDefectos.BTN_REGISTRO_PRIMERA)){
            Inspeccion nuevaInspeccion = new Inspeccion();
            
        }
    }
    
}
