/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author CARLOS
 */
public class frminicio extends javax.swing.JFrame {

    /**
     * Creates new form frminicio
     */
    public frminicio() {
        initComponents();
        lblidacceso.setVisible(false);
        this.setExtendedState(frminicio.MAXIMIZED_BOTH);
        this.setTitle(".::SAPT/DRS SJM - VMT::.");
//        setIconImage(new ImageIcon(getClass().getResource("../Files/icodeinicio")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblidacceso = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnusisreserva = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuconsultas = new javax.swing.JMenu();
        mnureservas = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        menutrabajador = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuacceso = new javax.swing.JMenuItem();
        mnuayuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(167, 186, 186));

        lblidacceso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblidacceso.setText("jLabel1");
        escritorio.add(lblidacceso);
        lblidacceso.setBounds(10, 100, 130, 16);

        lblacceso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblacceso.setText("jLabel7");
        escritorio.add(lblacceso);
        lblacceso.setBounds(10, 130, 130, 16);

        jLabel1.setText("Desarrollador:");
        escritorio.add(jLabel1);
        jLabel1.setBounds(10, 0, 80, 20);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Yosshi Condori M.");
        escritorio.add(jLabel2);
        jLabel2.setBounds(40, 30, 150, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setText("Areá de Informática");
        escritorio.add(jLabel3);
        jLabel3.setBounds(50, 50, 130, 17);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        mnusisreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/application.png"))); // NOI18N
        mnusisreserva.setMnemonic('f');
        mnusisreserva.setText("Inicio");
        mnusisreserva.add(jSeparator1);

        menuBar.add(mnusisreserva);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/folder_add.png"))); // NOI18N
        mnuconsultas.setText("Reservas");
        menuBar.add(mnuconsultas);

        mnureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_edit.png"))); // NOI18N
        mnureservas.setMnemonic('h');
        mnureservas.setText("Historia Paciente");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/user_manage.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Pacientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        mnureservas.add(aboutMenuItem);

        menuBar.add(mnureservas);

        menutrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/computer.png"))); // NOI18N
        menutrabajador.setText("Configuraciones");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/36_32x32.png"))); // NOI18N
        jMenuItem2.setText("Trabajador");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menutrabajador.add(jMenuItem2);

        menuacceso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuacceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/safe.png"))); // NOI18N
        menuacceso.setText("Acceso");
        menuacceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuaccesoActionPerformed(evt);
            }
        });
        menutrabajador.add(menuacceso);

        menuBar.add(menutrabajador);

        mnuayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/message.png"))); // NOI18N
        mnuayuda.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/coffee.png"))); // NOI18N
        jMenuItem3.setText("Acerca de...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuayuda.add(jMenuItem3);

        menuBar.add(mnuayuda);

        mnusalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/notification_error.png"))); // NOI18N
        mnusalir.setText("Salir");
        mnusalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnusalirMouseClicked(evt);
            }
        });
        mnusalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnusalirKeyPressed(evt);
            }
        });
        menuBar.add(mnusalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        frmpaciente form = new frmpaciente();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//         TODO add your handling code here:
        frmtrabajador form = new frmtrabajador();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnusalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnusalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnusalirMouseClicked

    private void menuaccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuaccesoActionPerformed
        // TODO add your handling code here:
        frmacceso form = new frmacceso();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_menuaccesoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Acercade form = new Acercade();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnusalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnusalirKeyPressed
        
    }//GEN-LAST:event_mnusalirKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frminicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblidacceso;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuacceso;
    public static javax.swing.JMenu menutrabajador;
    private javax.swing.JMenu mnuayuda;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnureservas;
    private javax.swing.JMenu mnusalir;
    private javax.swing.JMenu mnusisreserva;
    // End of variables declaration//GEN-END:variables

}
