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
    public Repositorio repo;
    public TipoUsuario tipo; // no es necesario crear una variable tipo
    public Usuario usuarioCalidad;
    public Usuario usuarioLinea;
    public OrdenProduccion orden;

    public Controlador() {
        VistaAutent= new VistaAutenticacion();      
        repo= new Repositorio();
    }

    public void ejecutarAutenticacion(){
        VistaAutent.setControlador(this);
        VistaAutent.ejecutarAutenticacion();
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
            System.out.println("1");
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
        }
        
        if(e.getActionCommand().equals(vistaRegistrar.BTN_REGISTRAR_REPROCESADOS)){
            Inspeccion inspeccion = new Inspeccion();
            Pie pie;
                            System.out.print(vistaRegistrar.getDefectosRep().size());
            for(String [] defecto: vistaRegistrar.getDefectosRep()){
                int codigo = Integer.parseInt(defecto[0]);
                if(defecto[1].equals(Pie.DERECHO.name())){
                    pie = Pie.DERECHO;
                }else{
                    pie = Pie.IZQUIERDO;
                }
                inspeccion.agregarDefecto(repo.buscarDefectosPorCodigo(codigo));
                inspeccion.setPie(pie);
                System.out.print(inspeccion.getPie().name());
            }
            
            repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().agregarInspeccion(inspeccion);         
//            System.out.print(repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().getInspecciones().size());
//           for(Inspeccion i: repo.obtenerOPporSupCalidad(usuarioCalidad).obtenerUltimoPeriodo().getInspecciones()){
//                  System.out.print(i.getPie().name());
//                for(Defecto d: i.getDefectos()){
//                    System.out.print(d.getCodigo());
//                }
//            }
            
        }
    }
}
