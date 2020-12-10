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

/**
 *
 * @author Jose
 */
public class PeriodoFuncionamientoTest {
    
    public PeriodoFuncionamientoTest() {
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

    /**
     * Test of agregarInspeccion method, of class PeriodoFuncionamiento.
     */
    @Test
    public void testControlAgregarUnaInstanciaInspeccionAlArrayDeInspecciones() {
        System.out.println("agregarInspeccion");
        Inspeccion inspeccion = new Inspeccion();
        //PeriodoFuncionamiento tiene en su contructor un parametro que indica la hora de incio del mismo
        PeriodoFuncionamiento instance = new PeriodoFuncionamiento(6);
        instance.agregarInspeccion(inspeccion);
        assertEquals("No se agrego la instancia de Inspeccion",instance.getInspecciones().size(),1);       
    }
    
    @Test
    public void testControlNoAgregarUnaInstanciaNullDeInspeccionAlArrayDeInspecciones(){
        System.out.println("agregar una inspeccion null al array de inspecciones");
        Inspeccion inspeccion = null;
        //PeriodoFuncionamiento tiene en su contructor un parametro que indica la hora de incio del mismo
        PeriodoFuncionamiento instance = new PeriodoFuncionamiento(6);
        instance.agregarInspeccion(inspeccion);        
        assertEquals("Se agrego una instancia nula de Inspeccion al arrayList de inspecciones",instance.getInspecciones().size(),0);
    }
   
}
