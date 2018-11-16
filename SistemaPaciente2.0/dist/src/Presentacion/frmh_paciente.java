/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vh_paciente;
import Logica.conexion;
import Logica.fh_paciente;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.PieChart;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reports.Reporte_Paciente;

public class frmh_paciente extends javax.swing.JInternalFrame {

    int codigo_paciente_dni;

    public frmh_paciente() {
        initComponents();
        mostrar("");
        inhabilitar();
        txtfecha_nacimiento.setText("00/00/0000");
    }
    private String accion = "guardar";

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();
        lblfecha_actual.setText(fechaactual.toString());
    }

    void guardar() {
        if (txtnombre.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Nombre para el paciente");
            txtnombre.requestFocus();
            return;
        }
        if (txtapaterno.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el paciente");
            txtapaterno.requestFocus();
            return;
        }

        if (txtamaterno.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un apellido para el paciente");
            txtamaterno.requestFocus();
            return;
        }

        if (txtcodigo_paciente_dni.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Doc para el paciente");
            txtcodigo_paciente_dni.requestFocus();
            return;
        }

        if (txtdireccion.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar la direccion del paciente");
            txtdireccion.requestFocus();
            return;
        }

        vh_paciente dts = new vh_paciente();
        fh_paciente func = new fh_paciente();

        dts.setHistoria_clinica(txthistoria_clinica.getText());
        dts.setNombre(txtnombre.getText());
        dts.setApaterno(txtapaterno.getText());
        dts.setAmaterno(txtamaterno.getText());
        int selecc = cbotipo_seguro.getSelectedIndex();
        dts.setTipo_seguro((String) cbotipo_seguro.getItemAt(selecc));
        dts.setDireccion(txtdireccion.getText());
        dts.setCelular(txtcelular.getText());
        dts.setEmail(txtemail.getText());
        dts.setFecha_nacimiento(txtfecha_nacimiento.getText());
        selecc = cbosexo.getSelectedIndex();
        dts.setSexo((String) cbosexo.getItemAt(selecc));
        dts.setEdad(lbledad.getText());
        dts.setFa_nombres(txtfa_nombres.getText());
        dts.setFa_apellidos(txtfa_apellidos.getText());
        dts.setFa_edad(txtfa_edad.getText());
        dts.setFa_direccion(txtfa_direccion.getText());

        dts.setFecha_actual(lblfecha_actual.getText());
        selecc = cboestado_civil.getSelectedIndex();
        dts.setEstado_civil((String) cboestado_civil.getItemAt(selecc));
        selecc = cbotipo_documento.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_documento.getItemAt(selecc));
        dts.setCodigo_paciente_dni(txtcodigo_paciente_dni.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "el paciente fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();

                checkselecction.setSelected(false);

            }

        } else if (accion.equals("editar")) {
            dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El paciente fue Editado satisfactoriamente");
                mostrar("");
                inhabilitar();

                checkselecction.setSelected(false);
            }
        }
    }

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(12).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(12).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(12).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(13).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(13).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(13).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(14).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(14).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(14).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(15).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(16).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(16).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(16).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(17).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(17).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(17).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidpersona.setVisible(false);

        txthistoria_clinica.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapaterno.setEnabled(false);
        txtamaterno.setEnabled(false);
        cbotipo_seguro.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtcelular.setEnabled(false);
        txtemail.setEnabled(false);
        txtfecha_nacimiento.setEnabled(false);
        cbosexo.setEnabled(false);
        lbledad.setEnabled(false);
        txtfa_nombres.setEnabled(false);
        txtfa_apellidos.setEnabled(false);
        txtfa_edad.setEnabled(false);
        txtfa_direccion.setEnabled(false);
        lblfecha_actual.setEnabled(false);
        cboestado_civil.setEnabled(false);
        cbotipo_documento.setEnabled(false);
        txtcodigo_paciente_dni.setEnabled(false);
        checkselecction.setEnabled(false);

        btnimprimir.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);

        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapaterno.setText("");
        txtamaterno.setText("");
        txtdireccion.setText("");
        txtcelular.setText("");
        txtemail.setText("");
        lbledad.setText("");
        txtfa_nombres.setText("");
        txtfa_apellidos.setText("");
        txtfa_edad.setText("");
        txtfa_direccion.setText("");
        txtcodigo_paciente_dni.setText("");

    }

    void habilitar() {
        txtidpersona.setVisible(false);

        txthistoria_clinica.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapaterno.setEnabled(true);
        txtamaterno.setEnabled(true);
        cbotipo_seguro.setEnabled(true);
        txtdireccion.setEnabled(true);
        txtcelular.setEnabled(true);
        txtemail.setEnabled(true);
        txtfecha_nacimiento.setEnabled(true);
        cbosexo.setEnabled(true);
        lbledad.setEnabled(true);
        txtfa_nombres.setEnabled(false);
        txtfa_apellidos.setEnabled(false);
        txtfa_edad.setEnabled(false);
        txtfa_direccion.setEnabled(false);
        lblfecha_actual.setEnabled(true);
        cboestado_civil.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtcodigo_paciente_dni.setEnabled(true);
        checkselecction.setEnabled(true);

        btnimprimir.setEnabled(true);
        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);

        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapaterno.setText("");
        txtamaterno.setText("");
        txtdireccion.setText("");
        txtfecha_nacimiento.setText("00/00/0000");
        txtcelular.setText("");
        txtemail.setText("");
        lbledad.setText("");
        txtfa_nombres.setText("");
        txtfa_apellidos.setText("");
        txtfa_edad.setText("");
        txtfa_direccion.setText("");
        txtcodigo_paciente_dni.setText("");

    }

    private void seleccionarFamiliar() {
        if (checkselecction.isSelected()) {
            txtfa_nombres.setEnabled(true);
            txtfa_apellidos.setEnabled(true);
            txtfa_edad.setEnabled(true);
            txtfa_direccion.setEnabled(true);
        } else if (checkselecction.isSelected() == false) {
            txtfa_nombres.setEnabled(false);
            txtfa_apellidos.setEnabled(false);
            txtfa_edad.setEnabled(false);
            txtfa_direccion.setEnabled(false);
        }
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fh_paciente func = new fh_paciente();
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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtidpersona = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtfa_nombres = new javax.swing.JTextField();
        txtfa_apellidos = new javax.swing.JTextField();
        txtfa_edad = new javax.swing.JTextField();
        txtfa_direccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapaterno = new javax.swing.JTextField();
        txtamaterno = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lbledad = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        checkselecction = new javax.swing.JCheckBox();
        lblfecha_actual = new javax.swing.JLabel();
        txthistoria_clinica = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbotipo_seguro = new javax.swing.JComboBox<String>();
        cboestado_civil = new javax.swing.JComboBox<String>();
        cbosexo = new javax.swing.JComboBox<String>();
        cbotipo_documento = new javax.swing.JComboBox();
        txtcodigo_paciente_dni = new javax.swing.JTextField();
        txtfecha_nacimiento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(".:: Paciente ::.");

        jPanel1.setBackground(new java.awt.Color(159, 180, 197));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Paciente"));

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
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnguardarKeyTyped(evt);
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
        btnnuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnnuevoKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtfa_nombres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfa_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_nombresKeyTyped(evt);
            }
        });

        txtfa_apellidos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfa_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_apellidosKeyTyped(evt);
            }
        });

        txtfa_edad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfa_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_edadKeyTyped(evt);
            }
        });

        txtfa_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtfa_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_direccionKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel15.setText("Nombres:");

        jLabel16.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel16.setText("Apellidos:");

        jLabel17.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel17.setText("Direccion:");

        jLabel18.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel18.setText("Edad:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtfa_direccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(190, 190, 190)
                                    .addComponent(jLabel18))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtfa_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                        .addComponent(txtfa_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtfa_apellidos, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfa_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfa_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtfa_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfa_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtnombre.setBackground(new java.awt.Color(159, 180, 196));
        txtnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombres:", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
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

        txtapaterno.setBackground(new java.awt.Color(158, 179, 193));
        txtapaterno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido Paterno:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtapaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapaternoActionPerformed(evt);
            }
        });
        txtapaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapaternoKeyTyped(evt);
            }
        });

        txtamaterno.setBackground(new java.awt.Color(158, 179, 193));
        txtamaterno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellido Materno:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtamaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamaternoActionPerformed(evt);
            }
        });
        txtamaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtamaternoKeyTyped(evt);
            }
        });

        txtcelular.setBackground(new java.awt.Color(158, 179, 193));
        txtcelular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cel/Telf:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
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
        txtemail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
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

        lbledad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txtdireccion.setBackground(new java.awt.Color(158, 179, 193));
        txtdireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        checkselecction.setBackground(new java.awt.Color(135, 155, 173));
        checkselecction.setText("Seleccionar Familiar Acompañante:");
        checkselecction.setBorder(new javax.swing.border.MatteBorder(null));
        checkselecction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkselecctionActionPerformed(evt);
            }
        });

        lblfecha_actual.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Actual:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        txthistoria_clinica.setBackground(new java.awt.Color(158, 179, 193));
        txthistoria_clinica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historia Clinica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txthistoria_clinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthistoria_clinicaActionPerformed(evt);
            }
        });
        txthistoria_clinica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthistoria_clinicaKeyTyped(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(158, 179, 193));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbotipo_seguro.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_seguro.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cbotipo_seguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIS", "ESSALUD", "OTROS", "S/N" }));
        cbotipo_seguro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cboestado_civil.setBackground(new java.awt.Color(158, 179, 193));
        cboestado_civil.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cboestado_civil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTERO", "CASADO", "VIUDO", "CONVIVIENTE" }));
        cboestado_civil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cbosexo.setBackground(new java.awt.Color(158, 179, 193));
        cbosexo.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO", "OTROS" }));
        cbosexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cbotipo_documento.setBackground(new java.awt.Color(205, 201, 147));
        cbotipo_documento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbotipo_documento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "    DNI", "Pasaporte" }));
        cbotipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentoActionPerformed(evt);
            }
        });

        txtcodigo_paciente_dni.setBackground(new java.awt.Color(158, 179, 193));
        txtcodigo_paciente_dni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo Doc:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtcodigo_paciente_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo_paciente_dniActionPerformed(evt);
            }
        });
        txtcodigo_paciente_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigo_paciente_dniKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cboestado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcodigo_paciente_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboestado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(txtcodigo_paciente_dni))
                .addContainerGap())
        );

        txtfecha_nacimiento.setBackground(new java.awt.Color(136, 159, 175));
        txtfecha_nacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Nacimiento"));
        txtfecha_nacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtfecha_nacimientoPropertyChange(evt);
            }
        });
        txtfecha_nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txthistoria_clinica, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(txtnombre))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(355, 355, 355))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(467, 467, 467)
                                .addComponent(checkselecction)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblfecha_actual, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(225, 225, 225)
                                    .addComponent(txtapaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtamaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkselecction))
                    .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(txtamaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapaterno, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(lblfecha_actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbledad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(txtfecha_nacimiento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardar)
                            .addComponent(btnnuevo))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro de Paciente", jPanel1);

        jPanel2.setBackground(new java.awt.Color(93, 174, 172));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pacientes"));

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

        lbltotalregistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnimprimir.setBackground(new java.awt.Color(51, 51, 51));
        btnimprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/printer.png"))); // NOI18N
        btnimprimir.setMnemonic('I');
        btnimprimir.setToolTipText("");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabla de registro de paciente", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigo_paciente_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo_paciente_dniActionPerformed
        // TODO add your handling code here:
        txtcodigo_paciente_dni.transferFocus();
    }//GEN-LAST:event_txtcodigo_paciente_dniActionPerformed

    private void cbotipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentoActionPerformed
        // TODO add your handling code here:
        cbotipo_documento.transferFocus();
    }//GEN-LAST:event_cbotipo_documentoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        checkselecction.setSelected(false);
        
        seleccionarFamiliar();
        fecha_actual();


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        jTabbedPane1.setSelectedIndex(0);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());
//        codigo_paciente_dni = Integer.parseInt(txtidpersona.getText());

        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txthistoria_clinica.setText(tablalistado.getValueAt(fila, 1).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 2).toString());
        txtapaterno.setText(tablalistado.getValueAt(fila, 3).toString());
        txtamaterno.setText(tablalistado.getValueAt(fila, 4).toString());
        cbotipo_seguro.setSelectedItem(tablalistado.getValueAt(fila, 5).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 6).toString());
        txtcelular.setText(tablalistado.getValueAt(fila, 7).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 8).toString());
        txtfecha_nacimiento.setText(tablalistado.getValueAt(fila, 9).toString());
        cbosexo.setSelectedItem(tablalistado.getValueAt(fila, 10).toString());
        lbledad.setText(tablalistado.getValueAt(fila, 11).toString());
        txtfa_nombres.setText(tablalistado.getValueAt(fila, 12).toString());
        txtfa_apellidos.setText(tablalistado.getValueAt(fila, 13).toString());
        txtfa_edad.setText(tablalistado.getValueAt(fila, 14).toString());
        txtfa_direccion.setText(tablalistado.getValueAt(fila, 15).toString());
        lblfecha_actual.setText(tablalistado.getValueAt(fila, 16).toString());
        cboestado_civil.setSelectedItem(tablalistado.getValueAt(fila, 17));
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 18));
        txtcodigo_paciente_dni.setText(tablalistado.getValueAt(fila, 19).toString());
        codigo_paciente_dni = Integer.parseInt(txtidpersona.getText());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showInputDialog(Integer.parseInt(mostrar(txtbuscar.getText())));
        String dni;
        dni = JOptionPane.showInputDialog("Ingrese N° Historia, Nombre, Apellido o DNI");
        mostrar(dni);


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el paciente?", "Confirmar", 2);

            if (confirmacion == 0) {
                fh_paciente func = new fh_paciente();
                vh_paciente dts = new vh_paciente();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtapaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapaternoActionPerformed
        // TODO add your handling code here:
        txtapaterno.transferFocus();
    }//GEN-LAST:event_txtapaternoActionPerformed

    private void txtamaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamaternoActionPerformed
        // TODO add your handling code here:
        txtamaterno.transferFocus();
    }//GEN-LAST:event_txtamaternoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
        txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

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
    }//GEN-LAST:event_txtnombreActionPerformed
    private Connection connection = new conexion().conectar();
    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        Reporte_Paciente g = new Reporte_Paciente();
        g.reportePacientes(codigo_paciente_dni);

    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped

        char c = evt.getKeyChar();
        int limiete = 34;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtnombre.getText().length() == limiete) {
            evt.consume();
        }

    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtcodigo_paciente_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigo_paciente_dniKeyTyped

        //codigo para validar dato numero y limitar los digitos.....
        char c = evt.getKeyChar();
        int limiete = 8;
        if (!Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtcodigo_paciente_dni.getText().length() == limiete) {
            evt.consume();
        }


    }//GEN-LAST:event_txtcodigo_paciente_dniKeyTyped

    private void txtapaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 24;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapaterno.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapaternoKeyTyped

    private void txtamaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamaternoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 24;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtamaterno.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtamaternoKeyTyped

    private void txtcelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelularKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limiete = 9;
        if (!Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtcelular.getText().length() == limiete) {
            evt.consume();
        }


    }//GEN-LAST:event_txtcelularKeyTyped

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        int limite = 44;
        if (txtemail.getText().length() == limite) {
            evt.consume();
        }

    }//GEN-LAST:event_txtemailKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        int limite = 44;
        if (txtdireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void checkselecctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkselecctionActionPerformed
        // TODO add your handling code here:
        seleccionarFamiliar();
    }//GEN-LAST:event_checkselecctionActionPerformed

    private void txthistoria_clinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthistoria_clinicaActionPerformed

    }//GEN-LAST:event_txthistoria_clinicaActionPerformed

    private void txthistoria_clinicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthistoria_clinicaKeyTyped
        char c = evt.getKeyChar();

        int limite = 20;
        if (c < '0' || c > '9') {
            evt.consume();
        }
        if (txthistoria_clinica.getText().length() == limite) {
            evt.consume();
        }

    }//GEN-LAST:event_txthistoria_clinicaKeyTyped

    private void txtfa_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfa_nombresKeyTyped
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtfa_nombres.getText().length() == limite) {
            evt.consume();
        }


    }//GEN-LAST:event_txtfa_nombresKeyTyped

    private void txtfa_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfa_apellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 34;
        if (Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtfa_apellidos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfa_apellidosKeyTyped

    private void txtfa_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfa_direccionKeyTyped
        // TODO add your handling code here:
        int limite = 34;
        if (txtdireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfa_direccionKeyTyped

    private void txtfa_edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfa_edadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 4;
        if (!Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtfa_edad.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfa_edadKeyTyped

    private void btnguardarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyTyped

    }//GEN-LAST:event_btnguardarKeyTyped

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnnuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnnuevoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_N) {
            habilitar();
            btnguardar.setText("Guardar");
            accion = "guardar";
            checkselecction.setSelected(false);
            seleccionarFamiliar();

        }
    }//GEN-LAST:event_btnnuevoKeyPressed

    private void txtfecha_nacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtfecha_nacimientoPropertyChange

    private void txtfecha_nacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechamacimineto = LocalDate.parse(txtfecha_nacimiento.getText(), date);
            LocalDate fechaactual = LocalDate.now();

            Period periodo = Period.between(fechamacimineto, fechaactual);
            String resultado = (+ periodo.getYears() + " Años " + periodo.getMonths() + " Meses" + " y " + periodo.getDays() + " Dias");

            lbledad.setText(resultado);
        }

    }//GEN-LAST:event_txtfecha_nacimientoKeyPressed

    private void txtfecha_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 10;
        if (txtfecha_nacimiento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyTyped

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
            java.util.logging.Logger.getLogger(frmh_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmh_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmh_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmh_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmh_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cboestado_civil;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox cbotipo_documento;
    private javax.swing.JComboBox<String> cbotipo_seguro;
    private javax.swing.JCheckBox checkselecction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbledad;
    private javax.swing.JLabel lblfecha_actual;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtamaterno;
    private javax.swing.JTextField txtapaterno;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigo_paciente_dni;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfa_apellidos;
    private javax.swing.JTextField txtfa_direccion;
    private javax.swing.JTextField txtfa_edad;
    private javax.swing.JTextField txtfa_nombres;
    private javax.swing.JTextField txtfecha_nacimiento;
    private javax.swing.JTextField txthistoria_clinica;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
