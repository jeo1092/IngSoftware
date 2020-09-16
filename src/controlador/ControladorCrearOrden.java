/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VistaCrearOP;
import vista.VistaPrincipalSupervisorLinea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;
import repositorio.Repositorio;

/**
 *
 * @author Jose
 */
public class ControladorCrearOrden implements ActionListener {
    VistaCrearOP vistaCrearOP;
    OrdenProduccion nuevaOrden;
    
    public ControladorCrearOrden(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorLinea.BTN_CREAROP)){
            if(Repositorio.obtenerOPporSupLinea(ControladorAutenticacion.getSupervisorLinea())== null){
                vistaCrearOP = new VistaCrearOP();
                vistaCrearOP.setControlador(this);
                vistaCrearOP.ejecutar();
                nuevaOrden = new OrdenProduccion();
                setDatosVista();
            }else{
                JOptionPane.showMessageDialog(null, "Orden De Produccion en Curso");
            }
        }
        
        if(e.getActionCommand().equals(vistaCrearOP.BTN_CONFIRMAROP)){
            nuevaOrden.setNumeroOrden(vistaCrearOP.getNumeroOP());
            nuevaOrden.setColor(Repositorio.obtenerColor(vistaCrearOP.getColor()));
            nuevaOrden.setModelo(Repositorio.obtenerModelo(vistaCrearOP.getModelo()));
            nuevaOrden.setLineaProduccion(Repositorio.obtenerLinea(vistaCrearOP.getNumLinea()));
            nuevaOrden.setSupervisorLinea(ControladorAutenticacion.getSupervisorLinea());
            nuevaOrden.setEstadoOrden(EstadoOrden.PROCESO);
            Repositorio.guardarOrdenProduccion(nuevaOrden);
            System.out.print(Repositorio.getOrdenes().size());
        }
    }
    
    public void setDatosVista(){
        ArrayList<Integer> numerosLinea = new ArrayList<>();
        ArrayList<String> descColores = new ArrayList<>();
        ArrayList<String> descModelos = new ArrayList<>();
        int numeroOP = 0;
        
        for(LineaProduccion linea: Repositorio.obtenerLineasDisponibles()){
            numerosLinea.add(linea.getNumeroLinea());
        }
        
        for(Color color: Repositorio.getColores()){
            descColores.add(color.getDescripcion());
        }
        
        for(Modelo modelo: Repositorio.getModelos()){
            descModelos.add(modelo.getDescripcion());
        }
        
        if(numeroOP == 0){
            numeroOP = 1;
        }
        else{
            OrdenProduccion ultimaOrden = Repositorio.getOrdenes().get(Repositorio.getOrdenes().size()-1);
            numeroOP = ultimaOrden.getNumeroOrden()+1;
        }
        
        vistaCrearOP.cargarDatosLinea(numerosLinea, descColores, descModelos, numeroOP);
    }
    
}
