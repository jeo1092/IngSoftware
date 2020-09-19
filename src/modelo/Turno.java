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
public class Turno {
    
    private int horaInicio;
    private int horaFin;
    private TipoTurno tipoTurno;

    public Turno(int horaInicio, int horaFin, TipoTurno tipoTurno) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoTurno = tipoTurno;
    }
    
    

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public TipoTurno getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(TipoTurno tipoTurno) {
        this.tipoTurno = tipoTurno;
    }
    
    
}
