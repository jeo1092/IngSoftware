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
    private static VistaPresentarDatos vistaPresentarDatos;
    
    public ControladorMostrarDatos(){
         vistaPresentarDatos = new VistaPresentarDatos();
         vistaPresentarDatos.ejecutar();
    }
    
    public static void buscarDefectosEnUltimasHoras(int hora){
        ArrayList<ArrayList<Defecto>> listaOrdenada = new ArrayList<>();
        for(Defecto d: Repositorio.getDefectos()){
            ArrayList<Defecto> lista = new ArrayList<>();
            for(OrdenProduccion op: Repositorio.getOrdenes()){
                for(PeriodoFuncionamiento pf: op.getPeriodos()){
                    for(Inspeccion in: pf.getInspecciones()){
                        if(in.getHorario() >= (Repositorio.getHora() - 4)){
                            for(Defecto defIn: in.getDefectos()){
                                if(defIn.getCodigo() == d.getCodigo()){
                                    lista.add(defIn);
                                }
                            }
                        }
                    }
                }
            }
            listaOrdenada.add(lista);
            
            int pos = 0;
            int cant = listaOrdenada.size();
            for(int i = 0; i < cant; i++){
                ArrayList<Defecto> l = listaOrdenada.get(pos);
                if(lista.size() > l.size()){
                    listaOrdenada.add(pos, lista);
                    listaOrdenada.remove(listaOrdenada.size()-1);
                    break;
                }
                pos++;
            }
        }
        ArrayList<String[]> filas = new ArrayList<>();
        for(ArrayList<Defecto> l: listaOrdenada){
            if(l.size()!=0){
                String[] fila = {l.get(0).getCodigo()+"",l.get(0).getDescripcion(), l.size()+""};
                filas.add(fila);
            }         
        }
        vistaPresentarDatos.cargarListaDefectos(filas);
    }
    
    public static void buscarproduccionPrimera(OrdenProduccion orden){
        ArrayList<Inspeccion> p = new ArrayList<>();
        ArrayList<String []> listaVista = new ArrayList<>();
        
        for(Inspeccion insp: orden.obtenerUltimoPeriodo().getInspecciones()){
            try{
                if(insp.getCalidad().equals(Calidad.PRIMERA)){
                    p.add(insp);
                }
            }catch(NullPointerException e){System.out.print("NullPointerException caught");}
            
        }
        String [] fila = {orden.getNumeroOrden()+"",orden.obtenerUltimoPeriodo().gethInicio()+"",p.size()+"",orden.getObjetivo()+""};
        listaVista.add(fila);
        
        vistaPresentarDatos.cargarListaProduccion(listaVista);
    }
}
