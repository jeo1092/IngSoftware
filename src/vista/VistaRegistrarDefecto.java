/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author Leonel
 */
public class VistaRegistrarDefecto extends javax.swing.JFrame {
    
    public static final String BTN_APROBAR = "aprobar par de calzados";
    public static final String BTN_CONTINUAR = "continuar en la OP";
    public static final String BTN_ABANDONAR = "abandonar en la OP";
    public static final String BTN_REGISTRAR_REPROCESADOS = "registrar par de calzado para reprocesar";
    public static final String BTN_REGISTRAR_SEPARADOS = "registrar par de calzado para separar";
    public static final String BTN_HERMANAR = "comenzar a hermanar los calzados separados";
    
    private ArrayList<String> defectosIzq = new ArrayList<>();
    private ArrayList<String> defectosDer = new ArrayList<>();

    /**
     * Creates new form VistaRegistrarDefecto
     */
    public VistaRegistrarDefecto() {
        initComponents();
    }
    
    public void ejecutar(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public void setControlador (Controlador control){
        jAprobar.setActionCommand(BTN_APROBAR);
        jAprobar.addActionListener(control);
        jContinuar.setActionCommand(BTN_CONTINUAR);
        jContinuar.addActionListener(control);
        jAbandonar.setActionCommand(BTN_ABANDONAR);
        jAbandonar.addActionListener(control);
        
        jRegistrarRep.setActionCommand(BTN_REGISTRAR_REPROCESADOS);
        jRegistrarRep.addActionListener(control);
        jRegistrarSep.setActionCommand(BTN_REGISTRAR_SEPARADOS);
        jRegistrarSep.addActionListener(control);
        
        jHermanar.setActionCommand(BTN_HERMANAR);
        jHermanar.addActionListener(control);
    }
    
    public void setEstadoOrden(String estado){
        jTextField1.setText(estado);
    }
    
    public void seleccionDefectosIzquierdo(){
        if(jDRI1.isSelected()){
            String defecto = "1";
            defectosIzq.add(defecto);
        }
        
        if(jDRI2.isSelected()){
            String defecto = "2";
            defectosIzq.add(defecto);
        }
        
        if(jDRI3.isSelected()){
            String defecto = "3";
            defectosIzq.add(defecto);
        }
        
        if(jDRI4.isSelected()){
            String defecto = "4";
            defectosIzq.add(defecto);
        }
        
        if(jDSI1.isSelected()){
            String defecto = "11";
            defectosIzq.add(defecto);
        }
        
        if(jDSI2.isSelected()){
            String defecto = "22";
            defectosIzq.add(defecto);
        }
        
        if(jDSI3.isSelected()){
           String defecto = "33";
            defectosIzq.add(defecto);
        }
        
        if(jDSI4.isSelected()){
            String defecto = "44";
            defectosIzq.add(defecto);
        }
        
        
    }
    
    public void seleccionDefectosDerecho(){
        if(jDRD1.isSelected()){
            String defecto = "1";
            defectosDer.add(defecto);
        }
        
        if(jDRD2.isSelected()){
            String defecto = "2";
            defectosDer.add(defecto);
        }
        
        if(jDRD3.isSelected()){
            String defecto = "3";
            defectosDer.add(defecto);
        }
        
        if(jDRD4.isSelected()){
            String defecto = "4";
            defectosDer.add(defecto);
        }
        
        if(jDSD1.isSelected()){
            String defecto = "11";
            defectosDer.add(defecto);
        }
        
        if(jDSD2.isSelected()){
            String defecto = "22";
            defectosDer.add(defecto);
        }
        
        if(jDSD3.isSelected()){
            String defecto = "33";
            defectosDer.add(defecto);
        }
        
        if(jDSD4.isSelected()){
            String defecto = "44";
            defectosDer.add(defecto);
        }
    }
    
    public void limpiarCasillas(){
        if(jDRI1.isSelected()){
            jDRI1.setSelected(false);
        }
        
        if(jDRI2.isSelected()){
            jDRI2.setSelected(false);
        }
        
        if(jDRI3.isSelected()){
            jDRI3.setSelected(false);
        }
        
        if(jDRI4.isSelected()){
            jDRI4.setSelected(false);
        }
        
        if(jDRD1.isSelected()){
            jDRD1.setSelected(false);
        }
        
        if(jDRD2.isSelected()){
            jDRD2.setSelected(false);
        }
        
        if(jDRD3.isSelected()){
            jDRD3.setSelected(false);
        }
        
        if(jDRD4.isSelected()){
            jDRD4.setSelected(false);
        }
        
        if(jDSI1.isSelected()){
            jDSI1.setSelected(false);
        }
        
        if(jDSI2.isSelected()){
            jDSI2.setSelected(false);
        }
        
        if(jDSI3.isSelected()){
            jDSI3.setSelected(false);
        }
        
        if(jDSI4.isSelected()){
            jDSI4.setSelected(false);
        }
        
        if(jDSD1.isSelected()){
            jDSD1.setSelected(false);
        }
        
        if(jDSD2.isSelected()){
            jDSD2.setSelected(false);
        }
        
        if(jDSD3.isSelected()){
            jDSD3.setSelected(false);
        }
        
        if(jDSD4.isSelected()){
            jDSD4.setSelected(false);
        }
    }

    public ArrayList<String> getDefectosIzquierdo() {
        seleccionDefectosIzquierdo();
        limpiarCasillas();
        return defectosIzq;
    }

    public ArrayList<String> getDefectosDerecho() {
        seleccionDefectosDerecho();
        limpiarCasillas();
        return defectosDer;
    }
    
    public void limpiar(){
        defectosIzq.clear();
        defectosDer.clear();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAprobar = new javax.swing.JButton();
        jDRI1 = new javax.swing.JCheckBox();
        jDRD1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jDRI2 = new javax.swing.JCheckBox();
        jDRD2 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jDRD3 = new javax.swing.JCheckBox();
        jDRI3 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jDRD4 = new javax.swing.JCheckBox();
        jDRI4 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDSD3 = new javax.swing.JCheckBox();
        jDSI3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jDSD4 = new javax.swing.JCheckBox();
        jDSI4 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jDSI1 = new javax.swing.JCheckBox();
        jDSD1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jDSI2 = new javax.swing.JCheckBox();
        jDSD2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jRegistrarRep = new javax.swing.JButton();
        jRegistrarSep = new javax.swing.JButton();
        jHermanar = new javax.swing.JButton();
        jContinuar = new javax.swing.JButton();
        jAbandonar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jAprobar.setText("Aprobar");

        jLabel1.setText("Defecto 1");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("Defecto 2");

        jLabel3.setText("Defecto 3");

        jLabel4.setText("Defecto 4");

        jLabel5.setText("Aprobar Calzado");

        jLabel6.setText("Defectos de Reproceso");

        jLabel7.setText("Defecto 3");

        jLabel8.setText("Defecto 4");

        jLabel9.setText("Defecto 1");

        jLabel10.setText("Defecto 2");

        jLabel11.setText("Defectos de Separación");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRegistrarRep.setText("Registrar Defectos");

        jRegistrarSep.setText("Registrar Defectos");

        jHermanar.setText("Hermanar");

        jContinuar.setText("Continuar");

        jAbandonar.setText("Abandonar");

        jLabel12.setText("Estado OP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAprobar)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jContinuar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jAbandonar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDRI2)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDRI1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDRI3)
                                .addComponent(jDRI4))
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDRD4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDRD1)
                                        .addComponent(jDRD3)
                                        .addComponent(jDRD2))))))
                    .addComponent(jRegistrarRep, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDSI2)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDSI1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel9)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDSI3)
                                        .addComponent(jDSI4))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDSD4))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(36, 36, 36)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDSD1)
                                                .addComponent(jDSD3)
                                                .addComponent(jDSD2))))))
                            .addComponent(jRegistrarSep, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jHermanar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDRD1)
                            .addComponent(jDRI1)
                            .addComponent(jLabel1))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDRI2)
                            .addComponent(jDRD2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDRI3)
                            .addComponent(jLabel3)
                            .addComponent(jDRD3))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDRI4)
                            .addComponent(jDRD4))
                        .addGap(18, 18, 18)
                        .addComponent(jRegistrarRep)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(69, 69, 69)
                                .addComponent(jAprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDSD1)
                                    .addComponent(jDSI1)
                                    .addComponent(jLabel9))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jDSI2)
                                    .addComponent(jDSD2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDSI3)
                                    .addComponent(jLabel7)
                                    .addComponent(jDSD3))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jDSI4)
                                    .addComponent(jDSD4))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jContinuar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jAbandonar)
                                .addGap(13, 13, 13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRegistrarSep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jHermanar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAbandonar;
    private javax.swing.JButton jAprobar;
    private javax.swing.JButton jContinuar;
    private javax.swing.JCheckBox jDRD1;
    private javax.swing.JCheckBox jDRD2;
    private javax.swing.JCheckBox jDRD3;
    private javax.swing.JCheckBox jDRD4;
    private javax.swing.JCheckBox jDRI1;
    private javax.swing.JCheckBox jDRI2;
    private javax.swing.JCheckBox jDRI3;
    private javax.swing.JCheckBox jDRI4;
    private javax.swing.JCheckBox jDSD1;
    private javax.swing.JCheckBox jDSD2;
    private javax.swing.JCheckBox jDSD3;
    private javax.swing.JCheckBox jDSD4;
    private javax.swing.JCheckBox jDSI1;
    private javax.swing.JCheckBox jDSI2;
    private javax.swing.JCheckBox jDSI3;
    private javax.swing.JCheckBox jDSI4;
    private javax.swing.JButton jHermanar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jRegistrarRep;
    private javax.swing.JButton jRegistrarSep;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
