/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jose
 */
public class Defecto {
    private int codigo;
    private TipoDefecto tipoDefecto;
    private String descripcion;
    
    public Defecto(int codigo, TipoDefecto tipoDefecto, String descripcion){
        this.codigo = codigo;
        this.tipoDefecto = tipoDefecto;
        this.descripcion = descripcion;
    }

//    public Defecto(Pie pie, TipoDefecto tipoDefecto) {
//        this.pie = pie;
//        this.tipoDefecto = tipoDefecto;
//    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoDefecto getTipoDefecto() {
        return tipoDefecto;
    }

    public void setTipoDefecto(TipoDefecto tipoDefecto) {
        this.tipoDefecto = tipoDefecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 
}
