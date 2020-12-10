/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import modelo.Color;
import modelo.Defecto;
import modelo.LineaProduccion;
import modelo.Modelo;
import modelo.OrdenProduccion;
import modelo.Turno;
import modelo.Usuario;
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
public class RepositorioTest {
    Repositorio repositorio = new Repositorio();
    public RepositorioTest() {
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
    public void testObtenerUnColorPorUnaDescripcionCargadaEnElRepositorio() {
        System.out.println("obtenerColor");
        String a = "Rojo";
        Color expResult = new Color(1,"Rojo");
        Color result = repositorio.obtenerColor(a);
        assertEquals("Los colores no son iguales",expResult.getCodigo(), result.getCodigo());
    }
    
    @Test
    public void testObtenerUnResultadoNuloSiLaDescripcionDeUnColorNoSeEncuentraCargadaEnElRepositorio(){
        String a = "violeta";
        Color result = repositorio.obtenerColor(a);
        assertEquals("EL color si se encuentra en el repositorio", result, null);
    }

    @Test
    public void testObtenerLineaPorSuIdLaMismaDebeEstarPreviamenteCargadaEnterosPositivos() {
        System.out.println("obtenerLinea");
        int a = 1;
        LineaProduccion expResult = new LineaProduccion(1);
        LineaProduccion result = repositorio.obtenerLinea(a);
        assertEquals("La linea no existe",expResult.getNumeroLinea(), result.getNumeroLinea());
    }
    
    @Test
    public void testObtenerUnaLineaDeProduccionNulaSiLaMismaNoEstaCargadaEnElRepositorioEnterosPositivos(){
        System.out.println("obtenerLinea");
        int a = 0;
        LineaProduccion expResult = null;
        LineaProduccion result = repositorio.obtenerLinea(a);
        assertEquals("La linea existe",expResult, result);
    }
    
    @Test
    public void testObtenerUnaLineaDeProduccionNulaSiLaMismaNoEstaCargadaEnElRepositorioEnterosNegativos(){
        System.out.println("obtenerLinea");
        int a = -1;
        LineaProduccion expResult = null;
        LineaProduccion result = repositorio.obtenerLinea(a);
        assertEquals("La linea existe",expResult, result);
    }
//
//    /**
//     * Test of obtenerOPporSupLinea method, of class Repositorio.
//     */
//    @Test
//    public void testObtenerOPporSupLinea() {
//        System.out.println("obtenerOPporSupLinea");
//        Usuario supervisorLinea = null;
//        OrdenProduccion expResult = null;
//        OrdenProduccion result = Repositorio.obtenerOPporSupLinea(supervisorLinea);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerOPporSupCalidad method, of class Repositorio.
//     */
//    @Test
//    public void testObtenerOPporSupCalidad() {
//        System.out.println("obtenerOPporSupCalidad");
//        Usuario supervisorCalidad = null;
//        OrdenProduccion expResult = null;
//        OrdenProduccion result = Repositorio.obtenerOPporSupCalidad(supervisorCalidad);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerOrdenesDisponibles method, of class Repositorio.
//     */
//    @Test
//    public void testObtenerOrdenesDisponibles() {
//        System.out.println("obtenerOrdenesDisponibles");
//        EstadoOrden estado = null;
//        Repositorio instance = new Repositorio();
//        ArrayList<OrdenProduccion> expResult = null;
//        ArrayList<OrdenProduccion> result = instance.obtenerOrdenesDisponibles(estado);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerLineasDisponibles method, of class Repositorio.
//     */
//    @Test
//    public void testObtenerLineasDisponibles() {
//        System.out.println("obtenerLineasDisponibles");
//        ArrayList<LineaProduccion> expResult = null;
//        ArrayList<LineaProduccion> result = Repositorio.obtenerLineasDisponibles();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerOPporNumero method, of class Repositorio.
//     */
//    @Test
//    public void testObtenerOPporNumero() {
//        System.out.println("obtenerOPporNumero");
//        int n = 0;
//        OrdenProduccion expResult = null;
//        OrdenProduccion result = Repositorio.obtenerOPporNumero(n);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscarDefectosPorCodigo method, of class Repositorio.
//     */
//    @Test
//    public void testBuscarDefectosPorCodigo() {
//        System.out.println("buscarDefectosPorCodigo");
//        int codigo = 0;
//        Defecto expResult = null;
//        Defecto result = Repositorio.buscarDefectosPorCodigo(codigo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarOrdenProduccion method, of class Repositorio.
//     */
//    @Test
//    public void testGuardarOrdenProduccion() {
//        System.out.println("guardarOrdenProduccion");
//        OrdenProduccion nuevaOrden = null;
//        Repositorio.guardarOrdenProduccion(nuevaOrden);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDefectos method, of class Repositorio.
//     */
//    @Test
//    public void testGetDefectos() {
//        System.out.println("getDefectos");
//        ArrayList<Defecto> expResult = null;
//        ArrayList<Defecto> result = Repositorio.getDefectos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTurnos method, of class Repositorio.
//     */
//    @Test
//    public void testGetTurnos() {
//        System.out.println("getTurnos");
//        ArrayList<Turno> expResult = null;
//        ArrayList<Turno> result = Repositorio.getTurnos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHora method, of class Repositorio.
//     */
//    @Test
//    public void testGetHora() {
//        System.out.println("getHora");
//        int expResult = 0;
//        int result = Repositorio.getHora();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
