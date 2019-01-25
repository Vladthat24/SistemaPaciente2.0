/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vtrabajador;
import Logica.fpaciente;
import Logica.ftrabajador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class frmtrabajador extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcliente
     */
    public frmtrabajador() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    private String accion = "guardar";

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidtrabajador.setVisible(false);

        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbotipo_documento.setEnabled(false);
        txtnum_documento.setEnabled(false);
        txtcargo_intitucion.setEnabled(false);
        txtmodalidad_contrato.setEnabled(false);
        txtcelular.setEnabled(false);
        txtemail.setEnabled(false);
        lblfecha_registro.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);

        txtidtrabajador.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");

        txtnum_documento.setText("");
        txtcargo_intitucion.setText("");
        txtmodalidad_contrato.setText("");

        txtcelular.setText("");
        txtemail.setText("");

    }

    void habilitar() {
        txtidtrabajador.setVisible(false);

        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);

        cbotipo_documento.setEnabled(true);
        txtnum_documento.setEnabled(true);
        txtcargo_intitucion.setEnabled(true);
        txtmodalidad_contrato.setEnabled(true);

        txtcelular.setEnabled(true);
        txtemail.setEnabled(true);
        lblfecha_registro.setEnabled(true);

        btnguardar.setEnabled(true);

        btneliminar.setEnabled(true);

        txtidtrabajador.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");

        txtnum_documento.setText("");
        txtcargo_intitucion.setText("");
        txtmodalidad_contrato.setText("");

        txtcelular.setText("");
        txtemail.setText("");
        lblfecha_registro.setText("");

    }

    void fechaActual() {
        int agosto = 8;
        int septiembre = 9;
        Calendar today = Calendar.getInstance();
        int fhoy_dia = today.get(Calendar.DAY_OF_MONTH);
        int fhoy_mes = today.get(Calendar.MONTH) + 1;
        String mes = null;
        if (fhoy_mes == 01) {
            mes = "Enero";
        } else if (fhoy_mes == 02) {
            mes = "Febreso";
        } else if (fhoy_mes == 03) {
            mes = "Marzo";
        } else if (fhoy_mes == 04) {
            mes = "Abril";
        } else if (fhoy_mes == 05) {
            mes = "Mayo";
        } else if (fhoy_mes == 06) {
            mes = "Junio";
        } else if (fhoy_mes == 07) {
            mes = "Julio";
        } else if (fhoy_mes == agosto) {
            mes = "Agosto";
        } else if (fhoy_mes == septiembre) {
            mes = "Septiembre";
        } else if (fhoy_mes == 10) {
            mes = "Octubre";
        } else if (fhoy_mes == 11) {
            mes = "Noviembre";
        } else if (fhoy_mes == 12) {
            mes = "Diciembre";
        }
        int fhoy_year = today.get(Calendar.YEAR);

        lblfecha_registro.setText(fhoy_dia + " de " + mes + " del " + fhoy_year);
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ftrabajador func = new ftrabajador();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtidtrabajador = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        txtcargo_intitucion = new javax.swing.JTextField();
        txtmodalidad_contrato = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        cbotipo_documento = new javax.swing.JComboBox();
        txtnum_documento = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(158, 179, 193));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Trabajador"));

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/diskette.png"))); // NOI18N
        btnguardar.setMnemonic('G');
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/document_add.png"))); // NOI18N
        btnnuevo.setMnemonic('N');
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        txtcargo_intitucion.setBackground(new java.awt.Color(158, 179, 193));
        txtcargo_intitucion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cargo en la Institucion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtcargo_intitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcargo_intitucionActionPerformed(evt);
            }
        });
        txtcargo_intitucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcargo_intitucionKeyTyped(evt);
            }
        });

        txtmodalidad_contrato.setBackground(new java.awt.Color(158, 179, 193));
        txtmodalidad_contrato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modalidad de Contrato:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtmodalidad_contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmodalidad_contratoKeyTyped(evt);
            }
        });

        txtnombre.setBackground(new java.awt.Color(158, 179, 193));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        cbotipo_documento.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_documento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbotipo_documento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "Pasaporte" }));
        cbotipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentoActionPerformed(evt);
            }
        });

        txtnum_documento.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_documento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo Doc:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_documentoActionPerformed(evt);
            }
        });
        txtnum_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_documentoKeyTyped(evt);
            }
        });

        txtapellidos.setBackground(new java.awt.Color(158, 179, 193));
        txtapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        txtcelular.setBackground(new java.awt.Color(158, 179, 193));
        txtcelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tefl/Cel:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtcelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcelularActionPerformed(evt);
            }
        });
        txtcelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelularKeyTyped(evt);
            }
        });

        txtemail.setBackground(new java.awt.Color(158, 179, 193));
        txtemail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtnombre)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtapellidos))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtcargo_intitucion)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtmodalidad_contrato)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbotipo_documento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnum_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtidtrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcargo_intitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtmodalidad_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnum_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcelular, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(".:TRABAJADOR :.");

        jPanel2.setBackground(new java.awt.Color(93, 173, 170));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Trabajador"));

        tablalistado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        btnbuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/search.png"))); // NOI18N
        btnbuscar.setMnemonic('B');
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/file_delete.png"))); // NOI18N
        btneliminar.setMnemonic('E');
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setBackground(new java.awt.Color(93, 173, 170));
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar)
                    .addComponent(btnbuscar))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnum_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_documentoActionPerformed
        // TODO add your handling code here:
        txtnum_documento.transferFocus();
    }//GEN-LAST:event_txtnum_documentoActionPerformed

    private void cbotipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentoActionPerformed
        // TODO add your handling code here:
        cbotipo_documento.transferFocus();
    }//GEN-LAST:event_cbotipo_documentoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        fechaActual();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtcargo_intitucion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA CARGO");
            txtcargo_intitucion.requestFocus();
            return;
        }
        if (txtmodalidad_contrato.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA MODELAIDAD DE CONTRATO");
            txtmodalidad_contrato.requestFocus();
            return;
        }
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA NOMBRE");
            txtnombre.requestFocus();
            return;
        }
        if (txtapellidos.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA APELLIDOS");
            txtapellidos.requestFocus();
            return;
        }

        if (txtnum_documento.getText().length() != 8) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA LOS 8 DIGITOS DEL DNI");
            txtnum_documento.requestFocus();
            return;
        }

        vtrabajador dts = new vtrabajador();
        ftrabajador func = new ftrabajador();

        dts.setNombre(txtnombre.getText());

        dts.setApellidos(txtapellidos.getText());

        int seleccionado = cbotipo_documento.getSelectedIndex();
        dts.setTipo_doc((String) cbotipo_documento.getItemAt(seleccionado));

        dts.setNum_dni(txtnum_documento.getText());

        dts.setCargo_inst(txtcargo_intitucion.getText());

        dts.setMod_cont(txtmodalidad_contrato.getText());

        dts.setNum_cel(txtcelular.getText());

        dts.setEmail(txtemail.getText());

        dts.setFecha_reg(lblfecha_registro.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "REGISTRO GUARDADO");
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdtrabajador(Integer.parseInt(txtidtrabajador.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "REGISTRO EDITADO");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidtrabajador.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 1).toString());
        txtapellidos.setText(tablalistado.getValueAt(fila, 2).toString());
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 3).toString());
        txtnum_documento.setText(tablalistado.getValueAt(fila, 4).toString());
        txtcargo_intitucion.setText(tablalistado.getValueAt(fila, 5).toString());
        txtmodalidad_contrato.setText(tablalistado.getValueAt(fila, 6).toString());
        txtcelular.setText(tablalistado.getValueAt(fila, 7).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 8).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 9).toString());


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showInputDialog(Integer.parseInt(mostrar(txtbuscar.getText())));
        String dni;
        dni = JOptionPane.showInputDialog("INGRESA DNI");
        mostrar(dni);


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidtrabajador.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de eliminar al trabajador?", "Confirmar", 2);

            if (confirmacion == 0) {
                ftrabajador func = new ftrabajador();
                vtrabajador dts = new vtrabajador();

                dts.setIdtrabajador(Integer.parseInt(txtidtrabajador.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
        txtapellidos.transferFocus();
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
        txtcelular.transferFocus();
    }//GEN-LAST:event_txtcelularActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
        txtnombre.transferFocus();
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 30;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapellidos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtnum_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_documentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 8;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnum_documento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnum_documentoKeyTyped

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 9;
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtcelular.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        // TODO add your handling code here:
        int limite = 45;
        if (txtemail.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txtcargo_intitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcargo_intitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcargo_intitucionActionPerformed

    private void txtcargo_intitucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcargo_intitucionKeyTyped
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtcargo_intitucion.getText().length() == limite) {
            evt.consume();
        }

    }//GEN-LAST:event_txtcargo_intitucionKeyTyped

    private void txtmodalidad_contratoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmodalidad_contratoKeyTyped
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtmodalidad_contrato.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtmodalidad_contratoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmtrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cbotipo_documento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblfecha_registro;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcargo_intitucion;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidtrabajador;
    private javax.swing.JTextField txtmodalidad_contrato;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_documento;
    // End of variables declaration//GEN-END:variables
}
