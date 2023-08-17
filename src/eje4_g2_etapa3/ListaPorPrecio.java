
package eje4_g2_etapa3;

import eje4_g2_etapa3.Producto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author familia maida
 */
public class ListaPorPrecio extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();

   
    public ListaPorPrecio() {
        initComponents();
        armarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jmenorp = new javax.swing.JTextField();
        jmayorp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Listado por Precio");

        jLabel2.setText("Entre $:");

        jLabel3.setText("y");

        jmenorp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmenorpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jmenorpKeyTyped(evt);
            }
        });

        jmayorp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmayorpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jmayorpKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jmenorp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jmayorp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jmenorp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jmayorp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenorpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmenorpKeyReleased
        cargarDatos();
    }//GEN-LAST:event_jmenorpKeyReleased

    private void jmayorpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmayorpKeyReleased
        cargarDatos();
    }//GEN-LAST:event_jmayorpKeyReleased

    private void jmenorpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmenorpKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
    }//GEN-LAST:event_jmenorpKeyTyped
    }
    private void jmayorpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmayorpKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
    }//GEN-LAST:event_jmayorpKeyTyped
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jmayorp;
    private javax.swing.JTextField jmenorp;
    // End of variables declaration//GEN-END:variables

    private void armarTabla() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jTable1.setModel(modelo);
    }

    private void borrarFilas() {
        int f = jTable1.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarDatos() {
        borrarFilas();
        try {
            for (Producto prod : Menu.listaProductos) {
                if (Double.parseDouble(jmenorp.getText()) < prod.getPrecio() && Double.parseDouble(jmayorp.getText()) > prod.getPrecio()) {
                    modelo.addRow(new Object[]{
                        prod.getCodigo(),
                        prod.getDescripcion(),
                        prod.getPrecio(),
                        prod.getStock()});
                }
            }
        } catch (NumberFormatException e) {

        }
    }
}
