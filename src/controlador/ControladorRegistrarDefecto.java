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
    VistaHermanar vistaHermanar;
    OrdenProduccion ordenInspeccionada;
    TablaReproceso tablaReproceso = new TablaReproceso();
    TablaSeparar tablaSeparar = new TablaSeparar();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(VistaPrincipalSupervisorCalidad.BTN_REALIZAR_INSPECCION)){
            ordenInspeccionada = Repositorio.obtenerOPporSupCalidad(ControladorAutenticacion.getSupervisorCalidad());
            if(ordenInspeccionada != null){
                cargarTablas();
                vistaRegistrarDefectos = new VistaRegistrarDefectos(tablaReproceso, tablaSeparar);
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
            
            vistaRegistrarDefectos.mostrarDefectos(tablaReproceso, tablaSeparar);
        }
        
        if(e.getActionCommand().equals(vistaRegistrarDefectos.BTN_SEPARAR)){
            Inspeccion insIzquierdo = new Inspeccion();
            insIzquierdo.setPie(Pie.IZQUIERDO);
            vistaRegistrarDefectos.registrarDefectosDeSeparar();
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
            
            vistaRegistrarDefectos.mostrarDefectos(tablaReproceso, tablaSeparar);
        }
        
        if(e.getActionCommand().equals(vistaRegistrarDefectos.BTN_HERMANAR)){
            vistaHermanar = new VistaHermanar();
            vistaHermanar.setControlador(new ControladorHermanar(ordenInspeccionada));
            vistaHermanar.ejecutar();
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
        
        codigosDefecto = new ArrayList<>();
        for(Defecto defecto: Repositorio.getDefectos()){
            if(defecto.getTipoDefecto().equals(TipoDefecto.SEPARACION)){
                codigosDefecto.add(defecto.getCodigo()+"");
            }           
        }
        tablaSeparar.setFilas(codigosDefecto);
    }
}
