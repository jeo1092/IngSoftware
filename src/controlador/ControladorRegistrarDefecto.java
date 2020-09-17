/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaPrincipalSupervisorCalidad;
import vista.VistaRegistrarDefectos;

/**
 *
 * @author Jose
 */
public class ControladorRegistrarDefecto implements ActionListener {
    VistaRegistrarDefectos vistaRegistrarDefectos;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorCalidad.BTN_REALIZAR_INSPECCION)){
            vistaRegistrarDefectos = new VistaRegistrarDefectos();
            
        }
    }
    
}
