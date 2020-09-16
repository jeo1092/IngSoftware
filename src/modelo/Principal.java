/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorAutenticacion;
import repositorio.Repositorio;


/**
 *
 * @author Jose
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Repositorio();
        ControladorAutenticacion control = new ControladorAutenticacion();
        control.ejecutar();
    }
    
}
