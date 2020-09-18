/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class TablaSeparar {
    private ArrayList<String> filas;
    
    public TablaSeparar(){
        this.filas = new ArrayList<>();
    }
    
    public DefaultTableModel mostrarDefectos()
    {
        
       
        String []  nombresColumnas = {"Codigo","Izq","Der"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);

        for(String defecto: filas){
            
            registros[0] = defecto;
             
            modelo.addRow(registros);
        }
              
         return modelo;
    }

    public void setFilas(ArrayList<String> filas) {
        this.filas = filas;
    }
}
