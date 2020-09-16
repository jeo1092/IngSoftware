/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import vista.VistaPrincipalSupervisorCalidad;
import vista.VistaAutenticacionUsuario;
import vista.VistaPrincipalSupervisorLinea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.TipoUsuario;
import modelo.Usuario;
import repositorio.Repositorio;

/**
 *
 * @author Jose
 */
public class ControladorAutenticacion implements ActionListener{
    private static Usuario supervisorLinea;
    private Usuario supervisorCalidad;
    ControladorCrearOrden controladorCrearOrden;
    VistaAutenticacionUsuario vistaAutenticacionUsuario;
    VistaPrincipalSupervisorLinea vistaPrincipalSupervisorLinea;
    VistaPrincipalSupervisorCalidad vistaPrincipalSupervisorCalidad;
    
    
    public ControladorAutenticacion(){
        this.vistaAutenticacionUsuario = new VistaAutenticacionUsuario();
        iniciarControladores();
    }
    
    public void ejecutar(){
        vistaAutenticacionUsuario.setControlador(this);
        vistaAutenticacionUsuario.ejecutar();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaAutenticacionUsuario.BTN_ACEPTAR)){
            
            for(Usuario u: Repositorio.getUsuarios()){
                if(vistaAutenticacionUsuario.getUsuario().equals(u.getNombre())){
                    if(u.getTipo().equals(TipoUsuario.SUPERVISORLINEA)){
                        supervisorLinea = u;
                        vistaPrincipalSupervisorLinea = new VistaPrincipalSupervisorLinea();
                        vistaPrincipalSupervisorLinea.setControlador(controladorCrearOrden, this);
                        vistaPrincipalSupervisorLinea.ejecutar();
                    }
                    else{
                        supervisorCalidad = u;
                        vistaPrincipalSupervisorCalidad = new VistaPrincipalSupervisorCalidad();
                        vistaPrincipalSupervisorCalidad.setControlador(this);
                        vistaPrincipalSupervisorCalidad.ejecutar();
                    }
                }
            }
        }
    }
    
    private void iniciarControladores(){
        controladorCrearOrden = new ControladorCrearOrden();
    }

    public static Usuario getSupervisorLinea() {
        return supervisorLinea;
    }

    public Usuario getSupervisorCalidad() {
        return supervisorCalidad;
    }
    
    
    
}
