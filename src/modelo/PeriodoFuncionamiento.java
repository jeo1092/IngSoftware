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
public class PeriodoFuncionamiento {
    private int hInicio;
    private int hFinal;
    private Usuario usuario;

    public PeriodoFuncionamiento(int hInicio) {
        this.hInicio = hInicio;
    }

    public int gethInicio() {
        return hInicio;
    }

    public void sethInicio(int hInicio) {
        this.hInicio = hInicio;
    }

    public int gethFinal() {
        return hFinal;
    }

    public void sethFinal(int hFinal) {
        this.hFinal = hFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
