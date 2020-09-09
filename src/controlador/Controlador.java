/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import java.util.Collections;
import modelo.*;
import vista.*;

/**
*
* @author Jose
*/
public class Controlador implements ActionListener{
    public VistaAutenticacion VistaAutent;
    public VistaPrincipalLinea VistaPL;
    public VistaPrincipalCalidad VistaCalidad;
    public VistaPrincipalIC vistaPrincipalCalidad;
    public VistacrearOP vistaCrearOP;
    public VistaAdministrarOP vistaAdmOP;
    public VistaRegistrarDefecto vistaRegistrar;
    public VistaHermanar vistaHermanar;
    public VistaPresentarDatos vistaDatos;
    public Repositorio repo;
    public TipoUsuario tipo; // no es necesario crear una variable tipo
    public Usuario usuarioCalidad;
    public Usuario usuarioLinea;
    public OrdenProduccion orden;

    public Controlador() {
        VistaAutent= new VistaAutenticacion();
        vistaDatos = new VistaPresentarDatos();
        repo= new Repositorio();
    }

    public void ejecutarAutenticacion(){
        VistaAutent.setControlador(this);
        VistaAutent.ejecutarAutenticacion();
        vistaDatos.ejecutar();
        //buscarDefectosEnUltimaHora(4);
    }

    public void actionPerformed (ActionEvent e){
        if(e.getActionCommand().equals(VistaAutent.BTN_ACEPTAR)){

            if(VistaAutent.getUsuario().equals("jose")||VistaAutent.getUsuario().equals("pedro")){
                if(VistaAutent.getUsuario().equals("jose")){
                    usuarioLinea = repo.getUsuarios().get(0);
                }else{
                    usuarioLinea = repo.getUsuarios().get(1);
                }
                VistaPL= new VistaPrincipalLinea();
                VistaPL.setControlador(this);
                VistaPL.ejecutar();
            }else
            {
                if(VistaAutent.getUsuario().equals("daniel"))
                {
                    usuarioCalidad = repo.getUsuarios().get(2);
                    vistaPrincipalCalidad = new VistaPrincipalIC();
                    vistaPrincipalCalidad.setControlador(this);
                    vistaPrincipalCalidad.ejecutar();    
                }
            }

        }
        if(e.getActionCommand().equals(VistaPL.BTN_CREAROP)){
            if(usuarioLinea.getEstado() == EstadoUsuario.LIBRE){
                orden = new OrdenProduccion();
                vistaCrearOP= new VistacrearOP();
                vistaCrearOP.setControlador(this);
                vistaCrearOP.ejecutar();
                ArrayList<Integer> linea = new ArrayList<>();
                ArrayList<String> colores = new ArrayList<>();
                ArrayList<String> modelos = new ArrayList<>();
                for(LineaProduccion p : repo.getLineas()){
                    if(p.getEstadoLinea() == EstadoLinea.LIBRE){
                        linea.add(p.getNumeroLinea());
                    }
                }
                for(Color color: repo.getColores()){
                    colores.add(color.toString());
                }

                for(Modelo modelo: repo.getModelos()){
                    modelos.add(modelo.toString());
                }

                vistaCrearOP.cargarDatosLinea(linea,colores,modelos);
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe una orden en curso para este usuario");
            }  
        }
        if(e.getActionCommand().equals(vistaCrearOP.BTN_CARGAR_ORDENP)){
            orden.setNumeroOrden(vistaCrearOP.getNumeroOP());
            orden.setColor(repo.obtenerColor(vistaCrearOP.getColor()));
            orden.setModelo(repo.obtenerModelo(vistaCrearOP.getModelo()));
            orden.setLineaProduccion(repo.obtenerLinea(vistaCrearOP.getNumLinea()));
            orden.setSupervisorLinea(usuarioLinea);
            orden.setEstadoOrden(EstadoOrden.PROCESO);
        }
        if(e.getActionCommand().equals(vistaCrearOP.BTN_CONFIRMAROP)){
            usuarioLinea.setEstado(EstadoUsuario.ASIGNADO);
            repo.agregarOrden(orden);
        }
        if(e.getActionCommand().equals(VistaPL.BTN_ADMINISTRAROP)){
            vistaAdmOP = new VistaAdministrarOP();
            vistaAdmOP.setControlador(this);
            vistaAdmOP.ejecutar();        
            vistaAdmOP.setOrdenProduccion(orden.getLineaProduccion().getNumeroLinea(), orden.getModelo().getDescripcion(), orden.getColor().getDescripcion(), orden.getSupervisorLinea().getNombre(), orden.getEstadoOrden().name());
        }
        
        if(e.getActionCommand().equals(vistaAdmOP.BTN_MODIFICAR_ESTADO)){
            //System.out.print(vistaAdmOP.getNuevoEstado());
            if(vistaAdmOP.getNuevoEstado() == 1){              
                orden.setEstadoOrden(EstadoOrden.PAUSA);
            }
            else if(vistaAdmOP.getNuevoEstado() == 2){
                orden.setEstadoOrden(EstadoOrden.PROCESO);
            }else{
                orden.setEstadoOrden(EstadoOrden.FINALIZADA);
                orden.getLineaProduccion().setEstadoLinea(EstadoLinea.LIBRE);
            }
            vistaAdmOP.setOrdenProduccion(orden.getLineaProduccion().getNumeroLinea(), orden.getModelo().getDescripcion(), orden.getColor().getDescripcion(), orden.getSupervisorLinea().getNombre(), orden.getEstadoOrden().name());
        }
        
        if(e.getActionCommand().equals(vistaPrincipalCalidad.BTN_ASIGNAR_ORDEN)){
            VistaCalidad= new VistaPrincipalCalidad();
            VistaCalidad.setControlador(this);
            VistaCalidad.ejecutar();
            ArrayList<String []> filas = new ArrayList<>();
            for(OrdenProduccion orden : repo.obtenerOrdenesDisponibles()){
                String [] valores = {orden.getLineaProduccion().getNumeroLinea()+"", orden.getNumeroOrden()+"",orden.getModelo().getDescripcion(),orden.getColor().getDescripcion(),orden.getEstadoOrden().name()};               
                filas.add(valores); 
            }         
            VistaCalidad.cargarLista(filas);
        }
        
        if(e.getActionCommand().equals(VistaCalidad.BTN_CONFIRMAR)){
            repo.obtenerOPporNumero(VistaCalidad.getOrden()).obtenerUltimoPeriodo().setUsuario(usuarioCalidad);
            usuarioCalidad.setEstado(EstadoUsuario.ASIGNADO);                   
        }
        
        if(e.getActionCommand().equals(vistaPrincipalCalidad.BTN_REALIZAR_INSPECCION)){
            vistaRegistrar = new VistaRegistrarDefecto();
            vistaRegistrar.setControlador(this);
            vistaRegistrar.ejecutar();
            vistaRegistrar.setEstadoOrden(repo.obtenerOPporSupCalidad(usuarioCalidad).getEstadoOrden().name());
        }
        
        if(e.getActionCommand().equals(vistaRegistrar.BTN_APROBAR)){
            Inspeccion inspeccion = new Inspeccion();
            inspeccion.setCalidad(Calidad.PRIMERA);
            repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspeccion);
            buscarDefectosEnUltimaHora(4);
        }
        
        if(e.getActionCommand().equals(vistaRegistrar.BTN_REGISTRAR_REPROCESADOS)){
            
                Inspeccion inspI = new Inspeccion();
                inspI.setPie(Pie.IZQUIERDO);
                for(String d: vistaRegistrar.getDefectosIzquierdo()){
                    Defecto defecto = repo.buscarDefectosPorCodigo(Integer.parseInt(d));
                    inspI.agregarDefecto(defecto); 
                }
                if(inspI.getDefectos().size()!=0){
                    repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspI);
                }

                Inspeccion inspD = new Inspeccion();
                inspD.setPie(Pie.DERECHO);
                for(String d: vistaRegistrar.getDefectosDerecho()){
                    Defecto defecto = repo.buscarDefectosPorCodigo(Integer.parseInt(d));
                    inspD.agregarDefecto(defecto);
                }
                if(inspD.getDefectos().size()!=0){
                    repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspD);
                }
               
            vistaRegistrar.limpiar();
            buscarDefectosEnUltimaHora(4);
        }
        
        
        if(e.getActionCommand().equals(vistaRegistrar.BTN_REGISTRAR_SEPARADOS)){

                Inspeccion inspI = new Inspeccion();
                inspI.setPie(Pie.IZQUIERDO);
                for(String d: vistaRegistrar.getDefectosIzquierdo()){
                    Defecto defecto = repo.buscarDefectosPorCodigo(Integer.parseInt(d));
                    inspI.agregarDefecto(defecto);            
                }
                if(inspI.getDefectos().size()!=0){
                    repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspI);
                }
                
                Inspeccion inspD = new Inspeccion();
                inspD.setPie(Pie.DERECHO);
                for(String d: vistaRegistrar.getDefectosDerecho()){
                    Defecto defecto = repo.buscarDefectosPorCodigo(Integer.parseInt(d));
                    inspD.agregarDefecto(defecto);
                }
                if(inspD.getDefectos().size()!=0){
                    repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspD);
                }
                vistaRegistrar.limpiar();
                buscarDefectosEnUltimaHora(4);                                 
        }
        if(e.getActionCommand().equals(vistaRegistrar.BTN_HERMANAR)){               
                vistaHermanar = new VistaHermanar();
                vistaHermanar.setControlador(this);
                vistaHermanar.ejecutar();
                vistaHermanar.setEstadoOrden(repo.obtenerOPporSupCalidad(usuarioCalidad).getEstadoOrden().name());
        }
        
        if(e.getActionCommand().equals(vistaHermanar.BTN_REGISTRAR_PRIMERA)){
            Inspeccion inspeccion = new Inspeccion();
            inspeccion.setCalidad(Calidad.PRIMERA);
            repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspeccion);
        }
        
        if(e.getActionCommand().equals(vistaHermanar.BTN_REGISTRAR_SEGUNDA)){
            Inspeccion inspeccion = new Inspeccion();
            inspeccion.setCalidad(Calidad.SEGUNDA);
            repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspeccion);
        }
    }
    
    public void buscarDefectosEnUltimaHora(int horas){
        ArrayList<Defecto> d1 = new ArrayList<>();
        ArrayList<Defecto> d2 = new ArrayList<>();
        ArrayList<Defecto> d3 = new ArrayList<>();
        ArrayList<Defecto> d4 = new ArrayList<>();
        ArrayList<Defecto> d5 = new ArrayList<>();
        ArrayList<Defecto> d6 = new ArrayList<>();
        ArrayList<Defecto> d7 = new ArrayList<>();
        ArrayList<Defecto> d8 = new ArrayList<>();
        Calendar c = new GregorianCalendar();
        for(OrdenProduccion o: repo.getOrdenes()){         
            for(PeriodoFuncionamiento p: o.getPeriodos()){
                for(Inspeccion i: p.getInspecciones()){
                    if(i.getHorario()>= (c.get(Calendar.HOUR_OF_DAY) - horas) ){
                        
                        for(Defecto d: i.getDefectos()){
                            if(d.getCodigo() == 1){d1.add(d);}
                            if(d.getCodigo() == 2){d2.add(d);}
                            if(d.getCodigo() == 3){d3.add(d);}
                            if(d.getCodigo() == 4){d4.add(d);}
                            if(d.getCodigo() == 11){d5.add(d);}
                            if(d.getCodigo() == 22){d6.add(d);}
                            if(d.getCodigo() == 33){d7.add(d);}
                            if(d.getCodigo() == 44){d8.add(d);}
                        }
                    
                    }
                }
            }
        }
        Integer [] listaOrdenada = {d1.size(),d2.size(),d3.size(),d4.size(),d5.size(),d6.size(),d7.size(),d8.size()};
        Arrays.sort(listaOrdenada, Collections.reverseOrder());
        for(int num : listaOrdenada){
            System.out.print(num);
        }
        System.out.print("\n");
        ArrayList<ArrayList<Defecto>> arrayDefectos = new ArrayList<>();arrayDefectos.add(d1);arrayDefectos.add(d2);arrayDefectos.add(d3);arrayDefectos.add(d4);arrayDefectos.add(d5);arrayDefectos.add(d6);arrayDefectos.add(d7);arrayDefectos.add(d8);
        ArrayList<String []> defectosVista = new ArrayList<>();
        int band1 = 0;
        int band2 = 0;
        int band3 = 0;
        
        for(ArrayList<Defecto> l : arrayDefectos){
            if(l.size() > 0){
                if(l.size() == listaOrdenada[0] && band1 ==0){
                    String[] def1 = {l.get(0).getDescripcion(),l.get(0).getCodigo()+"",l.size()+""};                                    
                    defectosVista.add(def1);
                    band1 = 1;
                
                }
            }
        }
        
        for(ArrayList<Defecto> l : arrayDefectos){
            if(l.size() > 0){
             if(l.size() == listaOrdenada[1] && band2 ==0){
                    String[] def2 = {l.get(0).getDescripcion(),l.get(0).getCodigo()+"",l.size()+""};                                    
                    defectosVista.add(def2);
                    band2 = 1;
                
                }
            }
        }
        
        for(ArrayList<Defecto> l : arrayDefectos){
            if(l.size() > 0){
             if(l.size() == listaOrdenada[2] && band3 ==0){
                    String[] def3 = {l.get(0).getDescripcion(),l.get(0).getCodigo()+"",l.size()+""};                                    
                    defectosVista.add(def3);
                    band3 = 1;
                
                }
            }
        }
        vistaDatos.cargarListaDefectos(defectosVista);
    }
}
