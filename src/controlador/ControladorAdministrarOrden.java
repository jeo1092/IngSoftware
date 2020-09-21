/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.EstadoOrden;
import modelo.OrdenProduccion;
import repositorio.Repositorio;
import vista.VistaAdministrarOP;
import vista.VistaPrincipalSupervisorLinea;

/**
 *
 * @author Jose
 */
public class ControladorAdministrarOrden implements ActionListener{
    VistaAdministrarOP vistaAdministrarOP;
    private OrdenProduccion ordenActiva;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorLinea.BTN_ADMINISTRAROP)){
            ordenActiva = Repositorio.obtenerOPporSupLinea(ControladorAutenticacion.getSupervisorLinea());
            if(ordenActiva != null ){
                vistaAdministrarOP = new VistaAdministrarOP();
                vistaAdministrarOP.setControlador(this);
                vistaAdministrarOP.ejecutar();
                setDatosVista();
            }else{
                JOptionPane.showMessageDialog(null, "no existe una orden en curso");
            }           
        }
        
        if(e.getActionCommand().equals(vistaAdministrarOP.BTN_MODIFICAR_ESTADO)){ 
            if(vistaAdministrarOP.getNuevoEstado() == 1){
                boolean p = ordenActiva.setEstadoOrden(EstadoOrden.PAUSA);
            }
            if(vistaAdministrarOP.getNuevoEstado() == 2){
                boolean p = ordenActiva.setEstadoOrden(EstadoOrden.PROCESO);
            }
            if(vistaAdministrarOP.getNuevoEstado() == 3){
                boolean p = ordenActiva.setEstadoOrden(EstadoOrden.FINALIZADA);
            }
        }
    }
    
    private void setDatosVista(){
        int linea = ordenActiva.getNumeroOrden();
        String modelo = ordenActiva.getModelo().getDescripcion();
        String color = ordenActiva.getColor().getDescripcion();
        String supervisor = ordenActiva.getSupervisorLinea().getNombre();
        String estado = ordenActiva.getEstadoOrden().name();
        
        vistaAdministrarOP.setOrdenProduccion(linea, modelo, color, supervisor, estado);
    }
    
    
}
