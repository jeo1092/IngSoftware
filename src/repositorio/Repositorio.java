/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.Color;
import modelo.Defecto;
import modelo.EstadoOrden;
import modelo.LineaProduccion;
import modelo.Modelo;
import modelo.OrdenProduccion;
import modelo.TipoDefecto;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 *
 * @author Jose
 */
public final class Repositorio {
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<LineaProduccion> lineas;
    private static ArrayList<OrdenProduccion> ordenes;
    private static ArrayList<Color> colores;
    private static ArrayList<Modelo> modelos;
    private static ArrayList<Defecto> defectos;

    public Repositorio(){
        this.usuarios = new ArrayList<>();
        this.lineas = new ArrayList<>();
        this.ordenes = new ArrayList<>();
        this.colores = new ArrayList<>();
        this.modelos = new ArrayList<>();
        this.defectos = new ArrayList<>();
        generarUsuarios();
        generarLineas();
        generarColores();
        generarModelos();
        generarDefectosReproceso();
    }
    
    private void generarUsuarios(){
        usuarios.add(new Usuario(1,"jose","jose@gmail.com", TipoUsuario.SUPERVISORLINEA));
        usuarios.add(new Usuario(1,"pedro","pedor@gmail.com", TipoUsuario.SUPERVISORLINEA));
        usuarios.add(new Usuario(2,"daniel","daniel@gmail.com", TipoUsuario.SUPERVISORCALIDAD));
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    private void generarLineas(){
        lineas.add(new LineaProduccion(1));
        lineas.add(new LineaProduccion(2));
    }

    public ArrayList<LineaProduccion> getLineas() {
        return lineas;
    }

    public static ArrayList<OrdenProduccion> getOrdenes() {
        return ordenes;
    }
    
    private void generarColores(){
        colores.add(new Color(1,"Rojo"));
        colores.add(new Color(2,"Verde"));
    }

    public static ArrayList<Color> getColores() {
        return colores;
    }
    
    private void generarModelos(){
        modelos.add(new Modelo(1, "A"));
        modelos.add(new Modelo(2, "B"));
    }

    public static ArrayList<Modelo> getModelos() {
        return modelos;
    }
    
    private void generarDefectosReproceso(){
        defectos.add(new Defecto(1, TipoDefecto.REPROCESO, "DefectoA"));
        defectos.add(new Defecto(2, TipoDefecto.REPROCESO, "DefectoB"));
        defectos.add(new Defecto(3, TipoDefecto.REPROCESO, "DefectoC"));
        defectos.add(new Defecto(4, TipoDefecto.REPROCESO, "DefectoD"));
        defectos.add(new Defecto(11, TipoDefecto.SEPARACION, "DefectoE"));
        defectos.add(new Defecto(22, TipoDefecto.SEPARACION, "DefectoF"));
        defectos.add(new Defecto(33, TipoDefecto.SEPARACION, "DefectoG"));
        defectos.add(new Defecto(44, TipoDefecto.SEPARACION, "DefectoH"));
    }

    public void agregarOrden(OrdenProduccion orden) {
        ordenes.add(orden);
    }
    
    public static Color obtenerColor(String a){
        Color valor = null;
        for(Color c: colores){
            if(c.getDescripcion().equals(a)){
                valor = c;
            }
        }
        return valor;
    }
    
    public static Modelo obtenerModelo(String a){
        Modelo valor = null;
        for(Modelo m: modelos){
            if(m.getDescripcion().equals(a)){
                valor = m;
            }
        }
        return valor;
    }
    
    public static LineaProduccion obtenerLinea(int a){
        LineaProduccion valor = null;
        for(LineaProduccion l: lineas){
            if(l.getNumeroLinea()==a){
                valor = l;
            }
        }
        return valor;
    }
    
    public static OrdenProduccion obtenerOPporSupLinea(Usuario supervisorLinea){
        OrdenProduccion resultado = null;
        for(OrdenProduccion op: ordenes){
            if(op.getSupervisorLinea().equals(supervisorLinea) && (op.getEstadoOrden().equals(EstadoOrden.PROCESO) || op.getEstadoOrden().equals(EstadoOrden.PAUSA))){
                resultado = op;
                break;
            }
        }
        return resultado;
    }
    
    public static OrdenProduccion obtenerOPporSupCalidad(Usuario supervisorCalidad){
        OrdenProduccion resultado = null;
        for(OrdenProduccion op: ordenes){
            if(op.obtenerUltimoPeriodo().getUsuario().equals(supervisorCalidad) && op.getEstadoOrden().equals(EstadoOrden.PROCESO)){
                resultado = op;
                break;
            }
        }
        return resultado;
    }
    
    public ArrayList<OrdenProduccion> obtenerOrdenesDisponibles(EstadoOrden estado){
        ArrayList<OrdenProduccion> resultado = new ArrayList<>();
        for(OrdenProduccion op : ordenes){
            if(op.getEstadoOrden() == estado && op.obtenerUltimoPeriodo().getUsuario() == null){
                resultado.add(op);
            }
        }
        return resultado;
    }
    
    public static ArrayList<LineaProduccion> obtenerLineasDisponibles(){
        ArrayList<LineaProduccion> lineasDisponibles = new ArrayList<>();
        for(LineaProduccion l: lineas){
            int b = 0;
            for(OrdenProduccion op: ordenes){
                if(l.equals(op.getLineaProduccion()) && (op.getEstadoOrden().equals(EstadoOrden.PAUSA) || op.getEstadoOrden().equals(EstadoOrden.PROCESO))){
                    b = 1;
                }
            }
            if(b == 0){
                lineasDisponibles.add(l);
            }          
        }
        
        return lineasDisponibles;
    }
    
    public static OrdenProduccion obtenerOPporNumero(int n){
        OrdenProduccion resultado = null;
        for(OrdenProduccion op: ordenes){
            if(op.getNumeroOrden() == n){
                resultado = op;
                break;
            }
        }
        return resultado;
    }
    
    public static Defecto buscarDefectosPorCodigo(int codigo){
        Defecto resultado= null;
        for(Defecto defecto: defectos){
            if(defecto.getCodigo()==codigo){
                resultado = defecto;
            }
        }
        return resultado;
    }
    
    public static void guardarOrdenProduccion(OrdenProduccion nuevaOrden){
        ordenes.add(nuevaOrden);
    }

    public static ArrayList<Defecto> getDefectos() {
        return defectos;
    }
    
    public static int getHora(){
        Calendar c = new GregorianCalendar();
        return c.get(Calendar.HOUR_OF_DAY);
    }
    
}
