/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositorio.Repositorio;
import vista.*;
import modelo.*;

/**
 *
 * @author Jose
 */
public class ControladorRegistrarDefecto implements ActionListener {
    VistaRegistrarDefectos vistaRegistrarDefectos;
    OrdenProduccion ordenInspeccionada;
    CargaTablaReproceso tablaReproceso = new CargaTablaReproceso();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorCalidad.BTN_REALIZAR_INSPECCION)){
            ordenInspeccionada = Repositorio.obtenerOPporSupCalidad(ControladorAutenticacion.getSupervisorCalidad());
            if(ordenInspeccionada != null){
                cargarTablas();
                vistaRegistrarDefectos = new VistaRegistrarDefectos(tablaReproceso);
                vistaRegistrarDefectos.setControlador(this);
                vistaRegistrarDefectos.ejecutar();
            }else{
                JOptionPane.showMessageDialog(null, "no tiene asignada una orden de produccion");
            }
            
        }
        
        if(e.getActionCommand().equals(vistaRegistrarDefectos.BTN_REGISTRO_PRIMERA)){
            Inspeccion nuevaInspeccion = new Inspeccion();
            nuevaInspeccion.setCalidad(Calidad.PRIMERA);
            ordenInspeccionada.obtenerUltimoPeriodo().agregarInspeccion(nuevaInspeccion);
        }
        
        if(e.getActionCommand().equals(vistaRegistrarDefectos.BTN_REPROCESO)){
            Inspeccion insIzquierdo = new Inspeccion();
            insIzquierdo.setPie(Pie.IZQUIERDO);
            vistaRegistrarDefectos.registrarDefectosDeReproceso();
            for(Integer a: vistaRegistrarDefectos.getDefectosIzquierdo()){
                insIzquierdo.agregarDefecto(Repositorio.buscarDefectosPorCodigo(a));
            }
            ordenInspeccionada.obtenerUltimoPeriodo().agregarInspeccion(insIzquierdo);
            
            Inspeccion insDerecho = new Inspeccion();
            insDerecho.setPie(Pie.DERECHO);
            for(Integer a: vistaRegistrarDefectos.getDefectosDerecho()){
                insDerecho.agregarDefecto(Repositorio.buscarDefectosPorCodigo(a));
            }
            ordenInspeccionada.obtenerUltimoPeriodo().agregarInspeccion(insDerecho);
            
//            for(Inspeccion i: ordenInspeccionada.obtenerUltimoPeriodo().getInspecciones()){
//                for(Defecto d: i.getDefectos()){
//                    System.out.print(d.getCodigo()+" "+d.getDescripcion()+" "+d.getTipoDefecto().name()+"\n\n");
//                }
//            }
            vistaRegistrarDefectos.mostrarDefectos(tablaReproceso);
        }
    }
    
    public void cargarTablas(){
        ArrayList<String> codigosDefecto = new ArrayList<>();
        for(Defecto defecto: Repositorio.getDefectos()){
            if(defecto.getTipoDefecto().equals(TipoDefecto.REPROCESO)){
                codigosDefecto.add(defecto.getCodigo()+"");
            }           
        }
        tablaReproceso.setFilas(codigosDefecto);
    }
}
