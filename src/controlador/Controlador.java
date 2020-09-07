/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    public TipoUsuario tipo;
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
      VistaPL.setControlador(this);
      VistaPL.ejecutar();
        }else
        {
        if(VistaAutent.getUsuario().equals(repo.getUsuarios().get(1).getNombre()) && repo.getUsuarios().get(1).getTipo().SUPERVISORCALIDAD==tipo.SUPERVISORCALIDAD)
        {
        VistaCalidad.setControlador(this);
        VistaCalidad.ejecutar();    
        }
             }
   
                                                               }
       if(e.getActionCommand().equals(VistaPL.BTN_CREAROP)){         
           vistaCrearOP.setControlador(this);
           vistaCrearOP.ejecutar();
           vistaCrearOP.cargarDatosLinea(repo);

       }
       if(e.getActionCommand().equals(vistaCrearOP.BTN_CREAR_ORDENP)){
       vistaCrearOP.agregarDatos();
 //orden= new OrdenProduccion(vistaCrearOP.getNumeroOP(),vistaCrearOP.getModelo(),vistaCrearOP.getColor(),vistaCrearOP.getNumLinea());                               
                                            
       }
                                                            }
       
       
                                                    }
