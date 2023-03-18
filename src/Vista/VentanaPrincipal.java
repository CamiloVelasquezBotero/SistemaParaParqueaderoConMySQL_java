package Vista;

import Modelo.Conexion;
import Modelo.Controlador;
import Modelo.Vehiculo;
import com.mysql.jdbc.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends javax.swing.JFrame {

    Controlador controlador = new Controlador();
    Vehiculo vehiculo = new Vehiculo();

    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        grupoBotones.add(rbAutomovil);
        grupoBotones.add(rbMotocicleta);
        botonEstado.setEnabled(false);
        rbMotocicleta.setEnabled(false);
        rbAutomovil.setEnabled(false);
        cajaPlaca.setEnabled(false);
        cajaNombrePropietario.setEnabled(false);
    }

    private void limpiar() {
        cajaPlaca.setText("");
        cajaNombrePropietario.setText("");
        grupoBotones.clearSelection();
    }

    private boolean comprobarCampos() {
        boolean indicador = false;

        if (cajaPlaca.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor digite la placa del vehiculo");
            indicador = false;
        } else {
            if (cajaNombrePropietario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor digite el nombre del Propietario");
                indicador = false;
            } else {
                boolean seleccionRB = false;
                if (rbMotocicleta.isSelected()) {
                    seleccionRB = true;
                } else if (rbAutomovil.isSelected()) {
                    seleccionRB = true;
                }
                if (seleccionRB == true) {
                    indicador = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor seleccione el tipo de vehiculo");
                    indicador = false;
                }
            }
        }
        return indicador;
    }

    private void actualizarDisponibilidad() {
        int disponibles = 50 - Integer.parseInt(controlador.parqueaderosEnUSO());
        String stringDisponibles = String.valueOf(disponibles);

        etiquetaNumeroLibres.setText(stringDisponibles);
        etiquetaNumeroEnUso.setText(controlador.parqueaderosEnUSO());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        grupoBotones = new javax.swing.ButtonGroup();
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaPlaca = new javax.swing.JLabel();
        cajaPlaca = new javax.swing.JTextField();
        botonEstado = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonRegistros = new javax.swing.JButton();
        botonRetirar = new javax.swing.JButton();
        etiquetaImagen = new javax.swing.JLabel();
        etiquetaNombrePropietario = new javax.swing.JLabel();
        cajaNombrePropietario = new javax.swing.JTextField();
        etiquetaLibres = new javax.swing.JLabel();
        etiquetaNumeroLibres = new javax.swing.JLabel();
        etiquetaEnUso = new javax.swing.JLabel();
        etiquetaNumeroEnUso = new javax.swing.JLabel();
        rbMotocicleta = new javax.swing.JRadioButton();
        rbAutomovil = new javax.swing.JRadioButton();
        barraMenu = new javax.swing.JMenuBar();
        menuConfiguraciones = new javax.swing.JMenu();
        submenuVisual = new javax.swing.JMenu();
        submenuColorFondo = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        submenuCambiarTamañoLetra = new javax.swing.JMenu();
        submenuMasGrande = new javax.swing.JMenuItem();
        submenuMasPequeña = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parqueadero");
        setResizable(false);

        etiquetaTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        etiquetaTitulo.setText("Proyecto Parqueadero");

        etiquetaPlaca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPlaca.setText("Placa");

        cajaPlaca.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        cajaPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        botonEstado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonEstado.setText("...");
        botonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstadoActionPerformed(evt);
            }
        });

        botonRegistrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonBuscar.setText("Buscar");

        botonRegistros.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonRegistros.setText("Registros");

        botonRetirar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        botonRetirar.setText("Retirar");
        botonRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarActionPerformed(evt);
            }
        });

        etiquetaImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Parking.png"))); // NOI18N

        etiquetaNombrePropietario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaNombrePropietario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombrePropietario.setText("Nombre del Propietario");

        cajaNombrePropietario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cajaNombrePropietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        etiquetaLibres.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaLibres.setText("Libres:");

        etiquetaNumeroLibres.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaNumeroLibres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumeroLibres.setText("50");

        etiquetaEnUso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaEnUso.setText("En uso:");

        etiquetaNumeroEnUso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etiquetaNumeroEnUso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNumeroEnUso.setText("0");

        rbMotocicleta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbMotocicleta.setText("Motocicleta");

        rbAutomovil.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbAutomovil.setText("Automovil");

        menuConfiguraciones.setText("Configuraciones");

        submenuVisual.setText("Visual");

        submenuColorFondo.setText("Color de fondo");

        jMenuItem4.setText("Por defecto (Gris)");
        submenuColorFondo.add(jMenuItem4);

        jMenuItem5.setText("Blanco");
        submenuColorFondo.add(jMenuItem5);

        jMenuItem6.setText("Negro");
        submenuColorFondo.add(jMenuItem6);

        submenuVisual.add(submenuColorFondo);

        submenuCambiarTamañoLetra.setText("Cambiar Tamaño Letra");

        submenuMasGrande.setText("Mas grande +");
        submenuCambiarTamañoLetra.add(submenuMasGrande);

        submenuMasPequeña.setText("Mas pequeña -");
        submenuCambiarTamañoLetra.add(submenuMasPequeña);

        submenuVisual.add(submenuCambiarTamañoLetra);

        menuConfiguraciones.add(submenuVisual);

        barraMenu.add(menuConfiguraciones);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etiquetaLibres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaNumeroLibres, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(etiquetaNumeroEnUso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaEnUso, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(etiquetaImagen))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(botonRegistros)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(etiquetaTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(etiquetaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaNombrePropietario)
                                            .addComponent(cajaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cajaNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(rbMotocicleta)
                                .addGap(18, 18, 18)
                                .addComponent(rbAutomovil)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(etiquetaLibres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNumeroLibres)
                .addGap(18, 18, 18)
                .addComponent(etiquetaEnUso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNumeroEnUso)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(etiquetaTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(etiquetaPlaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaNombrePropietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaNombrePropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMotocicleta)
                    .addComponent(rbAutomovil))
                .addGap(18, 18, 18)
                .addComponent(botonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiquetaImagen)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarActionPerformed
        botonEstado.setEnabled(true);
        botonEstado.setText("Retirar");
        botonRetirar.setEnabled(false);
        botonRegistrar.setEnabled(true);
        rbMotocicleta.setEnabled(false);
        rbAutomovil.setEnabled(false);
        cajaPlaca.setEnabled(true);
        cajaNombrePropietario.setEnabled(false);
        actualizarDisponibilidad();
    }//GEN-LAST:event_botonRetirarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        botonEstado.setEnabled(true);
        botonEstado.setText("Registrar");
        botonRegistrar.setEnabled(false);
        botonRetirar.setEnabled(true);
        cajaPlaca.setEnabled(true);
        cajaNombrePropietario.setEnabled(true);
        rbMotocicleta.setEnabled(true);
        rbAutomovil.setEnabled(true);
        actualizarDisponibilidad();
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstadoActionPerformed
        String estado = botonEstado.getText();

        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        switch (estado) {
            case "Registrar":
                //*************REGISTRAR**********************************

                if (comprobarCampos()) {
                    String tipoVehiculo = "";
                    if (rbMotocicleta.isSelected()) {
                        tipoVehiculo = "Motocicleta";
                    }
                    if (rbAutomovil.isSelected()) {
                        tipoVehiculo = "Automovil";
                    }

                    vehiculo.setPlaca(cajaPlaca.getText());
                    vehiculo.setNombrePropietario(cajaNombrePropietario.getText());
                    vehiculo.setTipoDeVehiculo(tipoVehiculo);
                    vehiculo.setHoraEntrada(fechaHora.format(date));

                    if (controlador.verificarPlaca(vehiculo) == 1) {
                        if (controlador.verificarEstado(vehiculo) == "no") {
                            if (controlador.registrar(vehiculo)) {
                                JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
                                actualizarDisponibilidad();
                                limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al registrar");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe un vehiculo registrado con la misma placa");
                        }
                    } else {
                        if (controlador.registrar(vehiculo)) {
                            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
                            actualizarDisponibilidad();
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrar");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el vehiculo");
                }
                //********
                break;

            //************************RETIRAR******************************
            case "Retirar":
                if (cajaPlaca.getText() != "") {
                    vehiculo.setPlaca(cajaPlaca.getText());
                    vehiculo.setHoraSalida(fechaHora.format(date));
                    vehiculo.setEstado("no");
                    if (controlador.verificarPlaca(vehiculo) == 1) {
                        if (controlador.retirar(vehiculo)) {
                            if (controlador.valorCobrar(vehiculo)) {
                                actualizarDisponibilidad();
                                limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha podido hacer el cobro");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al retirar el vehiculo,");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un vehiculo con la placa: " + vehiculo.getPlaca());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor digite la placa del vehiculo a retirar.");
                }
                break;
        }
    }//GEN-LAST:event_botonEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEstado;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegistros;
    private javax.swing.JButton botonRetirar;
    private javax.swing.JTextField cajaNombrePropietario;
    private javax.swing.JTextField cajaPlaca;
    private javax.swing.JLabel etiquetaEnUso;
    private javax.swing.JLabel etiquetaImagen;
    private javax.swing.JLabel etiquetaLibres;
    private javax.swing.JLabel etiquetaNombrePropietario;
    private javax.swing.JLabel etiquetaNumeroEnUso;
    private javax.swing.JLabel etiquetaNumeroLibres;
    private javax.swing.JLabel etiquetaPlaca;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu menuConfiguraciones;
    private javax.swing.JRadioButton rbAutomovil;
    private javax.swing.JRadioButton rbMotocicleta;
    private javax.swing.JMenu submenuCambiarTamañoLetra;
    private javax.swing.JMenu submenuColorFondo;
    private javax.swing.JMenuItem submenuMasGrande;
    private javax.swing.JMenuItem submenuMasPequeña;
    private javax.swing.JMenu submenuVisual;
    // End of variables declaration//GEN-END:variables
}
