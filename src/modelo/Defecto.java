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
    private Pie pie;
    private TipoDefecto tipoDefecto;
    
    public Defecto(int codigo, TipoDefecto tipoDefecto){
        this.codigo = codigo;
        this.tipoDefecto = tipoDefecto;
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

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }

    public TipoDefecto getTipoDefecto() {
        return tipoDefecto;
    }

    public void setTipoDefecto(TipoDefecto tipoDefecto) {
        this.tipoDefecto = tipoDefecto;
    }
    
    
}
