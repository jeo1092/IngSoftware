/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public final class Repositorio {
    private final ArrayList<Usuario> usuarios;
    private final ArrayList<LineaProduccion> lineas;

    public Repositorio(){
        this.usuarios = new ArrayList<>();
        this.lineas = new ArrayList<>();
        generarUsuarios();
        generarLineas();
    }
    
    private void generarUsuarios(){
        usuarios.add(new Usuario(1,"jose","jose@gmail.com", TipoUsuario.SUPERVISORLINEA));
        usuarios.add(new Usuario(2,"Daniel","daniel@gmail.com", TipoUsuario.SUPERVISORCALIDAD));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    private void generarLineas(){
        lineas.add(new LineaProduccion(1));
        lineas.add(new LineaProduccion(2));
    }

    public ArrayList<LineaProduccion> getLineas() {
        return lineas;
    }
    
}
