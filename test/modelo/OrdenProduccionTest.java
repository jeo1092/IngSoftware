/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repositorio.Repositorio;

/**
 *
 * @author Jose
 */
public class OrdenProduccionTest {
    Repositorio repositorio;
    public OrdenProduccionTest() {
        this.repositorio = new Repositorio();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
 
    
    @Test
    public void testControlarSiLaHoraInicioDeOrdenDeProduccionPerteneceAunTurnoPredefinido() {
        //Los turnos disponibles que se consideran son de 8 a 15 y de 16 a 23
        System.out.println("controlarTurno");
        OrdenProduccion instance = new OrdenProduccion();
        boolean result = instance.controlarTurno();
        assertTrue("No pertenece a un turno definido", result);
    }    

}
