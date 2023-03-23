package Vista;

import Modelo.Controlador;
import Modelo.Vehiculo;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registros extends javax.swing.JDialog {
    Vehiculo vehiculo = new Vehiculo();
    Controlador controlador = new Controlador();
    DefaultTableModel modeloTabla = controlador.obtenerRegistros();

    public Registros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
}
    
    public void ActualizarModeloTabla(){
        tabla.setModel(controlador.obtenerRegistros());
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonVolver = new javax.swing.JButton();
        botonEliminarVH = new javax.swing.JButton();
        botonActualizarTabla2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla.setBackground(new java.awt.Color(0, 51, 51));
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(modeloTabla);
        jScrollPane1.setViewportView(tabla);

        botonVolver.setBackground(new java.awt.Color(0, 153, 153));
        botonVolver.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonEliminarVH.setBackground(new java.awt.Color(0, 153, 153));
        botonEliminarVH.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonEliminarVH.setText("Eliminar Vehiculo");
        botonEliminarVH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarVHActionPerformed(evt);
            }
        });

        botonActualizarTabla2.setBackground(new java.awt.Color(0, 153, 153));
        botonActualizarTabla2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonActualizarTabla2.setText("Modificar nombre/tipo");
        botonActualizarTabla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarTabla2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(botonActualizarTabla2)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarVH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonActualizarTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonEliminarVH, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonEliminarVHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarVHActionPerformed
        int filaSeleccionada = tabla.getSelectedRow();
        int columnaPlaca = 0;
        
        Object placa = tabla.getValueAt(filaSeleccionada, columnaPlaca);
        vehiculo.setPlaca((String)placa);
        
        if(controlador.eliminarVehiculo(vehiculo)){
            JOptionPane.showMessageDialog(null, "Vehiculo eliminado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar el Vehiculo.");
        }
        
        ActualizarModeloTabla();
    }//GEN-LAST:event_botonEliminarVHActionPerformed

    private void botonActualizarTabla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarTabla2ActionPerformed
        int filaSeleccionada = tabla.getSelectedRow();
        int columnaSeleccionada = tabla.getSelectedColumn();
        String placa = (String)tabla.getValueAt(filaSeleccionada, 0);
        
        vehiculo.setNombrePropietario((String)tabla.getValueAt(filaSeleccionada, 1));
        vehiculo.setTipoDeVehiculo((String)tabla.getValueAt(filaSeleccionada, 2));
    
        if(controlador.ActualizarRegistros(vehiculo, placa)){
            JOptionPane.showMessageDialog(null, "Registro Modificado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al modificar el registro");
        }
        
        ActualizarModeloTabla();
    }//GEN-LAST:event_botonActualizarTabla2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registros.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registros.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registros.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registros.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registros dialog = new Registros(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarTabla2;
    private javax.swing.JButton botonEliminarVH;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
