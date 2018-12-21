/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vpaciente;
import Logica.conexion;
import Logica.fpaciente;
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

public class frmpaciente extends javax.swing.JInternalFrame {

    int codigo_paciente_dni;

    public frmpaciente() {
        initComponents();
        mostrar("");
        inhabilitar();
        lblusuario_acceso.setText(frmlogin.tablalistado.getValueAt(0, 2).toString());

    }
    private String accion = "guardar";

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();
        lblfecha_registro.setText(fechaactual.toString());
    }

    void guardar() {

        if (txthistoria_clinica.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESA HISTORIA CLINICA");
            txthistoria_clinica.requestFocus();
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

        if (txtdireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE DIRECCION");
            txtdireccion.requestFocus();
            return;
        }

        if (txtfecha_nacimiento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE FECHA DE NACIMIENTO");
            txtfecha_nacimiento.requestFocus();
            return;
        }

        if (lbledad.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE EDAD");
            lbledad.requestFocus();
            return;
        }

        if (lblfecha_registro.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE FECHA DE REGISTRO");
            txtdireccion.requestFocus();
            return;
        }
        if (txtnum_doc.getText().length() == 8) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE LOS 8 DIGITOS DEL DNI");
            txtnum_doc.requestFocus();
            return;
        }

        vpaciente dts = new vpaciente();
        fpaciente func = new fpaciente();

        dts.setHitoria_clinica(txthistoria_clinica.getText());
        dts.setNombre(txtnombre.getText());
        dts.setApellidos(txtapellidos.getText());
        int selecc = cbotipo_seguro.getSelectedIndex();
        dts.setTipo_seguro((String) cbotipo_seguro.getItemAt(selecc));
        dts.setDireccion(txtdireccion.getText());
        dts.setCelular(txtcelular.getText());
        dts.setEmail(txtemail.getText());
        dts.setFecha_nac(txtfecha_nacimiento.getText());
        dts.setLugar_nac(txtlugar_nac.getText());
        dts.setLugar_proc(txtlugar_proc.getText());
        selecc = cbosexo.getSelectedIndex();
        dts.setSexo((String) cbosexo.getItemAt(selecc));
        dts.setEdad(lbledad.getText());
        dts.setFecha_reg(lblfecha_registro.getText());
        selecc = cboestado_civil.getSelectedIndex();
        dts.setEstado_civil((String) cboestado_civil.getItemAt(selecc));
        selecc = cbotipo_documento.getSelectedIndex();
        dts.setTipo_doc((String) cbotipo_documento.getItemAt(selecc));
        dts.setNum_doc(txtnum_doc.getText());
        dts.setOcupacion(txtocupacion.getText());
        selecc = cboreligion.getSelectedIndex();
        dts.setReligion((String) cboreligion.getItemAt(selecc));
        dts.setFa_nombres(txtfa_nombres.getText());
        dts.setFa_apellidos(txtfa_apellidos.getText());
        dts.setFa_edad(txtfa_edad.getText());
        dts.setFa_direccion(txtfa_direccion.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "REGISTRO GUARDADO");
                mostrar("");
                inhabilitar();

                checkselecction.setSelected(false);

            }

        } else if (accion.equals("editar")) {
            dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "REGISTRO EDITADO");
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
    }

    void inhabilitar() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(false);
        txthistoria_clinica.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbotipo_seguro.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtcelular.setEnabled(false);
        txtemail.setEnabled(false);
        txtfecha_nacimiento.setEnabled(false);
        txtlugar_nac.setEnabled(false);
        txtlugar_proc.setEnabled(false);
        cbosexo.setEnabled(false);
        lbledad.setEnabled(false);
        lblfecha_registro.setEnabled(false);
        cboestado_civil.setEnabled(false);
        cbotipo_documento.setEnabled(false);
        txtnum_doc.setEnabled(false);
        txtocupacion.setEnabled(false);
        cboreligion.setEnabled(false);
        txtfa_nombres.setEnabled(false);
        txtfa_apellidos.setEnabled(false);
        txtfa_direccion.setEnabled(false);
        txtfa_edad.setEnabled(false);
        
        checkselecction.setEnabled(false);

        btnimprimir.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);

        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txtdireccion.setText("");
        txtcelular.setText("");
        txtemail.setText("");
        txtfecha_nacimiento.setText("");
        txtlugar_nac.setText("");
        txtlugar_proc.setText("");
        lbledad.setText("");
        lblfecha_registro.setText("");
        txtnum_doc.setText("");
        txtocupacion.setText("");

    }

    void habilitar() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(true);
        txthistoria_clinica.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellidos.setEnabled(true);
        cbotipo_seguro.setEnabled(true);
        txtdireccion.setEnabled(true);
        txtcelular.setEnabled(true);
        txtemail.setEnabled(true);
        txtfecha_nacimiento.setEnabled(true);
        txtlugar_nac.setEnabled(true);
        txtlugar_proc.setEnabled(true);
        cbosexo.setEnabled(true);
        lbledad.setEnabled(true);
        lblfecha_registro.setEnabled(true);
        cboestado_civil.setEnabled(true);
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);
        txtocupacion.setEnabled(true);
        cboreligion.setEnabled(true);
        txtfa_nombres.setEnabled(false);
        txtfa_apellidos.setEnabled(false);
        txtfa_direccion.setEnabled(false);
        txtfa_edad.setEnabled(false);

        checkselecction.setEnabled(true);

        btnimprimir.setEnabled(true);
        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);

        txtfa_nombres.setText("");
        txtfa_apellidos.setText("");
        txtfa_direccion.setText("");
        txtfa_edad.setText("");

        txthistoria_clinica.setText("");
        txtnombre.setText("");
        txtapellidos.setText("");
        txtdireccion.setText("");
        txtcelular.setText("");
        txtemail.setText("");
        txtfecha_nacimiento.setText("DD/MM/AAAA");
        txtlugar_nac.setText("");
        txtlugar_proc.setText("");
        lbledad.setText("");
        lblfecha_registro.setText("");
        txtnum_doc.setText("");
        txtocupacion.setText("");
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
            fpaciente func = new fpaciente();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtidpaciente = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtfa_nombres = new javax.swing.JTextField();
        txtfa_apellidos = new javax.swing.JTextField();
        txtfa_edad = new javax.swing.JTextField();
        txtfa_direccion = new javax.swing.JTextField();
        checkselecction = new javax.swing.JCheckBox();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtfecha_nacimiento = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        lbledad = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        lblfecha_registro = new javax.swing.JLabel();
        txthistoria_clinica = new javax.swing.JTextField();
        cboreligion = new javax.swing.JComboBox<String>();
        cbotipo_seguro = new javax.swing.JComboBox<String>();
        cbosexo = new javax.swing.JComboBox<String>();
        cbotipo_documento = new javax.swing.JComboBox();
        txtnum_doc = new javax.swing.JTextField();
        lblusuario_acceso = new javax.swing.JLabel();
        txtlugar_proc = new javax.swing.JTextField();
        txtlugar_nac = new javax.swing.JTextField();
        txtocupacion = new javax.swing.JTextField();
        cboestado_civil = new javax.swing.JComboBox<String>();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(".: Paciente :.");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listado de paciente", jPanel2);

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
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Completos de Acompañante del Paciente:"));

        txtfa_nombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres:"));
        txtfa_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_nombresKeyTyped(evt);
            }
        });

        txtfa_apellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos Completos:"));
        txtfa_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_apellidosKeyTyped(evt);
            }
        });

        txtfa_edad.setBorder(javax.swing.BorderFactory.createTitledBorder("Edad:"));
        txtfa_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_edadKeyTyped(evt);
            }
        });

        txtfa_direccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Direccion:"));
        txtfa_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_direccionKeyTyped(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtfa_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfa_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfa_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfa_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkselecction))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(checkselecction)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfa_nombres, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(txtfa_apellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtfa_edad)
                    .addComponent(txtfa_direccion))
                .addGap(25, 25, 25))
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

        txtapellidos.setBackground(new java.awt.Color(158, 179, 193));
        txtapellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos Completos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
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

        txtfecha_nacimiento.setBackground(new java.awt.Color(158, 179, 193));
        txtfecha_nacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Nacimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtfecha_nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_nacimientoActionPerformed(evt);
            }
        });
        txtfecha_nacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyTyped(evt);
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

        lblfecha_registro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Registro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

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

        cboreligion.setBackground(new java.awt.Color(158, 179, 193));
        cboreligion.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cboreligion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CATOLICO", "CRISTIANO", "TESTIGO DE JEHOVA", "ISRAELITAS ", "OTROS", "N/A", " ", " " }));
        cboreligion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Religion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cbotipo_seguro.setBackground(new java.awt.Color(158, 179, 193));
        cbotipo_seguro.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cbotipo_seguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIS", "ESSALUD", "OTROS", "S/N" }));
        cbotipo_seguro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Seguro:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cbosexo.setBackground(new java.awt.Color(158, 179, 193));
        cbosexo.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO", " " }));
        cbosexo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        cbotipo_documento.setBackground(new java.awt.Color(205, 201, 147));
        cbotipo_documento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbotipo_documento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " DNI", "PASAPORTE" }));
        cbotipo_documento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Documento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N
        cbotipo_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentoActionPerformed(evt);
            }
        });

        txtnum_doc.setBackground(new java.awt.Color(158, 179, 193));
        txtnum_doc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numero de Documento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtnum_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_docActionPerformed(evt);
            }
        });
        txtnum_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnum_docKeyTyped(evt);
            }
        });

        lblusuario_acceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario de Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12))); // NOI18N

        txtlugar_proc.setBackground(new java.awt.Color(158, 179, 193));
        txtlugar_proc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lugar de Procedencia:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtlugar_proc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlugar_procActionPerformed(evt);
            }
        });
        txtlugar_proc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlugar_procKeyTyped(evt);
            }
        });

        txtlugar_nac.setBackground(new java.awt.Color(158, 179, 193));
        txtlugar_nac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lugar de Nacimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtlugar_nac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlugar_nacActionPerformed(evt);
            }
        });
        txtlugar_nac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlugar_nacKeyTyped(evt);
            }
        });

        txtocupacion.setBackground(new java.awt.Color(158, 179, 193));
        txtocupacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ocupacion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N
        txtocupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtocupacionActionPerformed(evt);
            }
        });
        txtocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtocupacionKeyTyped(evt);
            }
        });

        cboestado_civil.setBackground(new java.awt.Color(158, 179, 193));
        cboestado_civil.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        cboestado_civil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTERO", "CASADO", "VIUDO", "CONVIVIENTE" }));
        cboestado_civil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado Civil:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(696, 696, 696))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbledad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblusuario_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtdireccion))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtlugar_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtlugar_proc, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(cboestado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtocupacion)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboreligion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusuario_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfecha_nacimiento)
                    .addComponent(lbledad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtlugar_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtlugar_proc, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(cbosexo)
                            .addComponent(lblfecha_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_documento)
                            .addComponent(cboestado_civil)
                            .addComponent(txtnum_doc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btnguardar)))
                    .addComponent(cboreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtlugar_nac.getAccessibleContext().setAccessibleName("Lugar de Nacimiento:");

        jTabbedPane1.addTab("Registro de Paciente", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
        txtnum_doc.transferFocus();
    }//GEN-LAST:event_txtnum_docActionPerformed

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

        txtidpaciente.setText(tablalistado.getValueAt(fila, 0).toString());
        lblusuario_acceso.setText(tablalistado.getValueAt(fila, 1).toString());
        txthistoria_clinica.setText(tablalistado.getValueAt(fila, 2).toString());
        txtnombre.setText(tablalistado.getValueAt(fila, 3).toString());
        txtapellidos.setText(tablalistado.getValueAt(fila, 4).toString());
        cbotipo_seguro.setSelectedItem(tablalistado.getValueAt(fila, 5).toString());
        txtdireccion.setText(tablalistado.getValueAt(fila, 6).toString());
        txtcelular.setText(tablalistado.getValueAt(fila, 7).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 8).toString());
        txtfecha_nacimiento.setText(tablalistado.getValueAt(fila, 9).toString());
        txtlugar_nac.setText(tablalistado.getValueAt(fila, 10).toString());
        txtlugar_proc.setText(tablalistado.getValueAt(fila, 11).toString());
        cbosexo.setSelectedItem(tablalistado.getValueAt(fila, 12).toString());
        lbledad.setText(tablalistado.getValueAt(fila, 13).toString());
        lblfecha_registro.setText(tablalistado.getValueAt(fila, 14).toString());
        cboestado_civil.setSelectedItem(tablalistado.getValueAt(fila, 15).toString());
        cbotipo_documento.setSelectedItem(tablalistado.getValueAt(fila, 16).toString());
        txtnum_doc.setText(tablalistado.getValueAt(fila, 17).toString());
        txtocupacion.setText(tablalistado.getValueAt(fila, 18).toString());
        cboreligion.setSelectedItem(tablalistado.getValueAt(fila, 19).toString());

        txtfa_nombres.setText(tablalistado.getValueAt(fila, 20).toString());
        txtfa_apellidos.setText(tablalistado.getValueAt(fila, 21).toString());
        txtfa_edad.setText(tablalistado.getValueAt(fila, 22).toString());
        txtfa_direccion.setText(tablalistado.getValueAt(fila, 23).toString());

        codigo_paciente_dni = Integer.parseInt(txtidpaciente.getText());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showInputDialog(Integer.parseInt(mostrar(txtbuscar.getText())));
        String dni;
        dni = JOptionPane.showInputDialog("INGRESE N° DE DNI");
        mostrar(dni);


    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpaciente.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿ESTAS SEGURO?", "Confirmar", 2);

            if (confirmacion == 0) {
                fpaciente func = new fpaciente();
                vpaciente dts = new vpaciente();

                dts.setIdpaciente(Integer.parseInt(txtidpaciente.getText()));
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

    private void txtfecha_nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoActionPerformed
        // TODO add your handling code here:
        txtfecha_nacimiento.transferFocus();
    }//GEN-LAST:event_txtfecha_nacimientoActionPerformed

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

    private void txtnum_docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_docKeyTyped

        //codigo para validar dato numero y limitar los digitos.....
        char c = evt.getKeyChar();
        int limiete = 8;
        if (!Character.isDigit(c)) {//si es diferente a letra...
            evt.consume();
        }
        if (txtnum_doc.getText().length() == limiete) {
            evt.consume();
        }


    }//GEN-LAST:event_txtnum_docKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 100;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtapellidos.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtfecha_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 24;
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtfecha_nacimiento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyTyped

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
        int limite = 256;
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
        int limite = 100;
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

    private void txtlugar_procActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugar_procActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugar_procActionPerformed

    private void txtlugar_procKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugar_procKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlugar_procKeyTyped

    private void txtlugar_nacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugar_nacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugar_nacActionPerformed

    private void txtlugar_nacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugar_nacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlugar_nacKeyTyped

    private void txtocupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtocupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtocupacionActionPerformed

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtocupacionKeyTyped

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
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpaciente().setVisible(true);
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
    private javax.swing.JComboBox<String> cboreligion;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox cbotipo_documento;
    private javax.swing.JComboBox<String> cbotipo_seguro;
    private javax.swing.JCheckBox checkselecction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbledad;
    private javax.swing.JLabel lblfecha_registro;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lblusuario_acceso;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfa_apellidos;
    private javax.swing.JTextField txtfa_direccion;
    private javax.swing.JTextField txtfa_edad;
    private javax.swing.JTextField txtfa_nombres;
    private javax.swing.JTextField txtfecha_nacimiento;
    private javax.swing.JTextField txthistoria_clinica;
    private javax.swing.JTextField txtidpaciente;
    private javax.swing.JTextField txtlugar_nac;
    private javax.swing.JTextField txtlugar_proc;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtocupacion;
    // End of variables declaration//GEN-END:variables
}
