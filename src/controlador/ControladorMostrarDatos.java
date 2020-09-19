/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.*;
import repositorio.Repositorio;
import vista.VistaPresentarDatos;

/**
 *
 * @author Jose
 */
public class ControladorMostrarDatos {
    VistaPresentarDatos vistaPresentarDatos;
    
    public ControladorMostrarDatos(){
        vistaPresentarDatos = new VistaPresentarDatos();
        vistaPresentarDatos.ejecutar();
    }
    
    public void buscarDefectosEnUltimasHoras(int hora){
        for(Defecto d: Repositorio.getDefectos()){
            ArrayList<Defecto> lista = new ArrayList<>();
            for(OrdenProduccion op: Repositorio.getOrdenes()){
                for(PeriodoFuncionamiento pf: op.getPeriodos()){
                    for(Inspeccion in: pf.getInspecciones()){
                        if(in.getHorario() >= (Repositorio.getHora() - 4)){
                            for(Defecto defIn: in.getDefectos()){
                                
                            }
                        }
                    }
                }
            }
        }
    }
}
