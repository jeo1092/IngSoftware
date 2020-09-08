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
    public VistacrearOP vistaCrearOP;
    public VistaAdministrarOP vistaAdmOP;
    public Repositorio repo;
    public TipoUsuario tipo; // no es necesario crear una variable tipo
    public Usuario usuarioCalidad;
    public Usuario usuarioLinea;
    public OrdenProduccion orden;

    public Controlador() {
        VistaAutent= new VistaAutenticacion();
       
        VistaCalidad= new VistaPrincipalCalidad();
        vistaCrearOP= new VistacrearOP();
        vistaAdmOP = new VistaAdministrarOP();
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
                if(VistaAutent.getUsuario().equals(repo.getUsuarios().get(1).getNombre()) && repo.getUsuarios().get(1).getTipo().SUPERVISORCALIDAD==tipo.SUPERVISORCALIDAD)
                {
                    usuarioCalidad = repo.getUsuarios().get(2);
                    VistaCalidad.setControlador(this);
                    VistaCalidad.ejecutar();    
                }
            }

        }
        if(e.getActionCommand().equals(VistaPL.BTN_CREAROP)){
            System.out.print("paso");
            if(usuarioLinea.getEstado() == EstadoUsuario.LIBRE){
                orden = new OrdenProduccion();
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
            orden.setNumeroOrden(0);
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
            vistaAdmOP.setControlador(this);
            vistaAdmOP.ejecutar();        
            vistaAdmOP.setOrdenProduccion(orden.getLineaProduccion().getNumeroLinea(), orden.getModelo().getDescripcion(), orden.getColor().getDescripcion(), orden.getSupervisorLinea().getNombre(), orden.getEstadoOrden().name());
        }
    }
}
