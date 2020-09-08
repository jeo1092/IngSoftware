/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.ArrayList;
import modelo.*;
/**
 *
 * @author Leonel
 */
public class VistacrearOP extends javax.swing.JFrame {
    
    public static final String BTN_CARGAR_ORDENP= "crear una orden de produccion";
    public static final String BTN_CONFIRMAROP= "confirmar una orden de produccion"; 
    /**
     * Creates new form crearOP
     */
    public VistacrearOP() {
        initComponents();
    }
    
    public void ejecutar(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        jComboLinea.removeAllItems();
        jComboColor.removeAllItems();
        jComboModelo.removeAllItems();
        jDatosOP.removeAll();
    }
    
    public void setControlador(Controlador control){
        jOrdenProd.setActionCommand(BTN_CARGAR_ORDENP);
        jOrdenProd.addActionListener(control);
        jButton2.setActionCommand(BTN_CONFIRMAROP);
        jButton2.addActionListener(control);
    }
    
    public void cargarDatosLinea(ArrayList<Integer> linea, ArrayList <String>color,ArrayList <String>modelo){
    
        for(int i=0;linea.size()>i;i++){
        jComboLinea.addItem(""+linea.get(i));
        }
        
        jComboLinea.addItem("");
        for(int i=0;color.size()>i;i++){
            jComboColor.addItem(color.get(i));
        }
        
        for(int i=0; modelo.size()>i;i++){
        jComboModelo.addItem(modelo.get(i));
        }
    }
    
    public int getNumeroOP(){
        int numero=Integer.parseInt(jTextField1.getText());
        return numero;
    }
    
    public int getNumLinea(){
        int numLinea=Integer.parseInt(jComboLinea.getSelectedItem().toString());
        return numLinea;
    }
    
    public String getModelo(){
        String numModelo= ((String)jComboModelo.getSelectedItem());
        return numModelo;
    }
    
    public String getColor(){
        String DescripcionColor= ((String)jComboColor.getSelectedItem());
        return DescripcionColor;
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboLinea = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboModelo = new javax.swing.JComboBox<>();
        jComboColor = new javax.swing.JComboBox<>();
        jOrdenProd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDatosOP = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboLineaActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero Linea de Produccion");

        jLabel2.setText("Modelo");

        jLabel3.setText("Color");

        jOrdenProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jOrdenProd.setText("Crear Orden Produccion");
        jOrdenProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOrdenProdActionPerformed(evt);
            }
        });

        jDatosOP.setColumns(20);
        jDatosOP.setRows(5);
        jScrollPane1.setViewportView(jDatosOP);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Confirmar");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Crear Orden de Produccion");

        jLabel5.setText("Numero OP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrdenProd)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOrdenProd)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboLineaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboLineaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jOrdenProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOrdenProdActionPerformed
        // TODO add your handling code here:
    String numLinea=(String)jComboLinea.getSelectedItem();
    int numOP=Integer.parseInt(jTextField1.getText());
    String Color = (String)jComboColor.getSelectedItem();
    String Modelo= (String)jComboModelo.getSelectedItem();

    
 jDatosOP.setText("Numero de Linea: "+numLinea+" \n"+"Numero de Orden de Produccion: "+numOP +" \n"+"Color: "+Color+" \n"+"Modelo: "+Modelo);
    }//GEN-LAST:event_jOrdenProdActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboColor;
    public javax.swing.JComboBox<String> jComboLinea;
    private javax.swing.JComboBox<String> jComboModelo;
    public javax.swing.JTextArea jDatosOP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jOrdenProd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
