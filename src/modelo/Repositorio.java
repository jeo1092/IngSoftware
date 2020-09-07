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
    private ArrayList<OrdenProduccion> ordenes;
    private ArrayList<Color> colores;
    private ArrayList<Modelo> modelos;

    public Repositorio(){
        this.usuarios = new ArrayList<>();
        this.lineas = new ArrayList<>();
        this.ordenes = new ArrayList<>();
        this.colores = new ArrayList<>();
        this.modelos = new ArrayList<>();
        generarUsuarios();
        generarLineas();
        generarColores();
        generarModelos();
    }
    
    private void generarUsuarios(){
        usuarios.add(new Usuario(1,"jose","jose@gmail.com", TipoUsuario.SUPERVISORLINEA));
        usuarios.add(new Usuario(2,"daniel","daniel@gmail.com", TipoUsuario.SUPERVISORCALIDAD));
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

    public ArrayList<OrdenProduccion> getOrdenes() {
        return ordenes;
    }
    
    private void generarColores(){
        colores.add(new Color(1,"Rojo"));
        colores.add(new Color(2,"Verde"));
    }

    public ArrayList<Color> getColores() {
        return colores;
    }
    
    private void generarModelos(){
        modelos.add(new Modelo(1, "A"));
        modelos.add(new Modelo(2, "B"));
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }
    

    public void setOrden(OrdenProduccion orden) {
        ordenes.add(orden);
    }
    
    public Color obtenerColor(String a){
        Color valor = null;
        for(Color c: colores){
            if(c.getDescripcion()==a){
                valor = c;
            }
        }
        return valor;
    }
    
    public Modelo obtenerModelo(String a){
        Modelo valor = null;
        for(Modelo m: modelos){
            if(m.getDescripcion()==a){
                valor = m;
            }
        }
        return valor;
    }
    
    public LineaProduccion obtenerLinea(int a){
        LineaProduccion valor = null;
        for(LineaProduccion l: lineas){
            if(l.getNumeroLinea()==a){
                valor = l;
            }
        }
        return valor;
    }
}
