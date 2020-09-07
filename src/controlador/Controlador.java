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
    public Repositorio repo;
    public TipoUsuario tipo; // no es necesario crear una variable tipo
    public Usuario usuarioCalidad;
    public Usuario usuarioLinea;
    public OrdenProduccion orden;

    public Controlador() {

        VistaAutent= new VistaAutenticacion();
        VistaPL= new VistaPrincipalLinea();
        VistaCalidad= new VistaPrincipalCalidad();
        vistaCrearOP= new VistacrearOP();
        repo= new Repositorio();
    }

    public void ejecutarAutenticacion(){
        VistaAutent.setControlador(this);
        VistaAutent.ejecutarAutenticacion();

    }

    public void actionPerformed (ActionEvent e){
        if(e.getActionCommand().equals(VistaAutent.BTN_ACEPTAR)){

            if(VistaAutent.getUsuario().equals(repo.getUsuarios().get(0).getNombre()) && repo.getUsuarios().get(0).getTipo().SUPERVISORLINEA==tipo.SUPERVISORLINEA){
                usuarioLinea = repo.getUsuarios().get(0);
                VistaPL.setControlador(this);
                VistaPL.ejecutar();
            }else
            {
                if(VistaAutent.getUsuario().equals(repo.getUsuarios().get(1).getNombre()) && repo.getUsuarios().get(1).getTipo().SUPERVISORCALIDAD==tipo.SUPERVISORCALIDAD)
                {
                    usuarioCalidad = repo.getUsuarios().get(1);
                    VistaCalidad.setControlador(this);
                    VistaCalidad.ejecutar();    
                }
            }

        }
        if(e.getActionCommand().equals(VistaPL.BTN_CREAROP)){
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
                JOptionPane.showMessageDialog(null, "Ya existe una orden en curso");
            }  
        }
        if(e.getActionCommand().equals(vistaCrearOP.BTN_CREAR_ORDENP)){
            orden.setNumeroOrden(0);
            orden.setColor(repo.obtenerColor(""));
            orden.setModelo(repo.obtenerModelo(""));
            orden.setLineaProduccion(repo.obtenerLinea(1));
            orden.setSupervisorLinea(usuarioLinea);
            orden.setEstadoOrden(EstadoOrden.PROCESO);
            
            System.out.print(orden.toString());
            repo.setOrden(orden);
            
        }       
    }
}
