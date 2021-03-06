/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonel
 */
public class VistaPrincipalCalidad extends javax.swing.JFrame {
    public static final String BTN_CONFIRMAR ="opcion para confirmar op";
    public static final String BTN_DETALLES ="opcion para ver detalles op";
    /**
     * Creates new form VistaPrincipalCalidad
     */
    public VistaPrincipalCalidad() {
        initComponents();
    }
    public void ejecutar(){
         this.setVisible(true);
         this.setLocationRelativeTo(null);
    }
    
    public void setControlador(Controlador control){
    jConfirmar.setActionCommand(BTN_CONFIRMAR);
    jConfirmar.addActionListener(control);
    jDetalles.setActionCommand(BTN_DETALLES);
    jDetalles.addActionListener(control);
            }
    public void cargarLista(ArrayList orden){
        DefaultTableModel tabla= new DefaultTableModel();
        tabla.addColumn("Numero de Linea");
        tabla.addColumn("Orden Produccion");
        tabla.addColumn("Modelo");
        tabla.addColumn("Color");
        tabla.addColumn("Estado");
        for(int i=0; orden.size()>i;i++){
        tabla.addRow((String[]) orden.get(i));
        }
        jTablaOP.setModel(tabla);
        
               }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaOP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDetalles = new javax.swing.JButton();
        jConfirmar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jdetalleLinea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTablaOP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaOP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Detalles");

        jDetalles.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jDetalles.setText("Ver Detalles");
        jDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDetallesActionPerformed(evt);
            }
        });

        jConfirmar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jConfirmar.setText("Confirmar");
        jConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmarActionPerformed(evt);
            }
        });

        jdetalleLinea.setColumns(20);
        jdetalleLinea.setRows(5);
        jScrollPane2.setViewportView(jdetalleLinea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Asignacion de Orden de Produccion");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Lineas de produccion");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDetallesActionPerformed
        // TODO add your handling code here:
        int FilaSeleccionada = jTablaOP.getSelectedRow();
        if(FilaSeleccionada>=0){
        String Linea=jTablaOP.getValueAt(FilaSeleccionada, 0).toString();
        String Orden=jTablaOP.getValueAt(FilaSeleccionada, 1).toString();
        String Modelo=jTablaOP.getValueAt(FilaSeleccionada, 2).toString();
        String Color=jTablaOP.getValueAt(FilaSeleccionada, 3).toString();
        String Estado= jTablaOP.getValueAt(FilaSeleccionada, 4).toString();
        jdetalleLinea.setText("Numero de Linea: "+Linea+"\n"+"Orden de produccion: "+Orden+" \n"+"Modelo: "+Modelo+" \n"+"Color: "+Color+" \n"+ "Estado: "+Estado);
        }
        
    }//GEN-LAST:event_jDetallesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jConfirmarActionPerformed
        public int getOrden(){
        int FilaSeleccionada = jTablaOP.getSelectedRow();
        String Orden=jTablaOP.getValueAt(FilaSeleccionada, 1).toString();
        int orden=Integer.parseInt(Orden);
        return orden;
        }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jConfirmar;
    private javax.swing.JButton jDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTablaOP;
    private javax.swing.JTextArea jdetalleLinea;
    // End of variables declaration//GEN-END:variables
}
