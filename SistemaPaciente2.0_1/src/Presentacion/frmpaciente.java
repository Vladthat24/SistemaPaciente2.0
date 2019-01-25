/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vpaciente;
import Logica.conexion;
import Logica.fpaciente;
import Logica.validarBDD;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
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
import reports.impHistoriaClinica;

public class frmpaciente extends javax.swing.JInternalFrame {

    int idhistoriaClinica_modelviewclick;

    public frmpaciente() {
        initComponents();
        mostrar("");
        inhabilitar();

    }
    private String accion = "guardar";
    private String acceso = frmlogin.tablalistado.getValueAt(0, 2).toString();
    private String accionDNI = "validardni";

    void fecha_actual() {

        LocalDate fechaactual = LocalDate.now();

        lblfecha_registro.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(fechaactual));

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
        if (txtcelular.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE CELULAR");
            txtcelular.requestFocus();
            return;
        }

        if (txtfecha_nacimiento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE FECHA DE NACIMIENTO");
            txtfecha_nacimiento.requestFocus();
            return;
        }
        if (txtlugar_nac.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE LUGAR NACIMIENTO");
            txtlugar_nac.requestFocus();
            return;
        }
        if (txtlugar_proc.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE LUGAR DE PROCEDENCIA");
            txtlugar_proc.requestFocus();
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
        if (txtnum_doc.getText().length() < 8) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE LOS 8 DIGITOS DEL DNI");
            txtnum_doc.requestFocus();
            return;
        }
        if (txtocupacion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE OCUPACION");
            txtocupacion.requestFocus();
            return;
        }
        vpaciente dts = new vpaciente();
        fpaciente func = new fpaciente();

        dts.setUsuario_acceso(lblusuario_acceso.getText());
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
                inhabilitarNuevo_Existe();
                //para imprimir con el idhistoriaclinca en el formulario

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
        //idpaciente
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        //usuario
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

        //tipo de seguro
        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        //direccion
        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        //celular
        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        //email
        tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);

        //fecha de nacimiento
        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);

        //lugar de nacimiento
        tablalistado.getColumnModel().getColumn(10).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(10).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(10).setPreferredWidth(0);

        //lugar de procedencia
        tablalistado.getColumnModel().getColumn(11).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(11).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(11).setPreferredWidth(0);

        //estado civil
        tablalistado.getColumnModel().getColumn(15).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(15).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(15).setPreferredWidth(0);

        //ocupacion
        tablalistado.getColumnModel().getColumn(18).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(18).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(18).setPreferredWidth(0);

        //religion
        tablalistado.getColumnModel().getColumn(19).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(19).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(19).setPreferredWidth(0);

        //acompañante nombres
        tablalistado.getColumnModel().getColumn(20).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(20).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(20).setPreferredWidth(0);

        //acompañante apellidos
        tablalistado.getColumnModel().getColumn(21).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(21).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(21).setPreferredWidth(0);

        //acompañante edad
        tablalistado.getColumnModel().getColumn(22).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(22).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(22).setPreferredWidth(0);

        //acompañante direccion
        tablalistado.getColumnModel().getColumn(23).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(23).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(23).setPreferredWidth(0);

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
        //para validar en la base de datos
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);

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
        btnnuevo.setEnabled(false);

        lblusuario_acceso.setText(acceso);
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
        lblrestaValidarHistoriaClinica.setText("");

    }

    void inhabilitarNuevo_Existe() {
        txtidpaciente.setVisible(false);

        lblusuario_acceso.setEnabled(true);
        txthistoria_clinica.setEnabled(true);
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
        //para validar en la base de datos
        cbotipo_documento.setEnabled(true);
        txtnum_doc.setEnabled(true);

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
        btnnuevo.setEnabled(false);
        lblusuario_acceso.setText(acceso);
    }

    void habilitarCajasTexto() {
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
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(true);
        btnnuevo.setEnabled(true);
        lblusuario_acceso.setText(acceso);
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
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(true);
        btnnuevo.setEnabled(true);

        txtfa_nombres.setText("");
        txtfa_apellidos.setText("");
        txtfa_direccion.setText("");
        txtfa_edad.setText("");

        lblusuario_acceso.setText(acceso);
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
        jPanel4 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtidpaciente = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
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
        lblnotanumero_doc = new javax.swing.JLabel();
        lblnotahistoriaclinica = new javax.swing.JLabel();
        lblnotaacceso = new javax.swing.JLabel();
        lblrestaValidarHistoriaClinica = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtfa_nombres = new javax.swing.JTextField();
        txtfa_edad = new javax.swing.JTextField();
        txtfa_direccion = new javax.swing.JTextField();
        checkselecction = new javax.swing.JCheckBox();
        txtfa_apellidos = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(".: REGISTRO DE HISTORIA CLINICA DEL CENTRO MATERNO INFANTIL \"DANIEL ALCIDES CARRIÓN\" :.");

        jPanel4.setBackground(new java.awt.Color(93, 174, 172));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pacientes"));

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
        tablalistado.setDragEnabled(true);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablalistadoMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistado);

        txtbuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda por N° DNI o Apellidos:"));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar)
                        .addGap(32, 32, 32)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(159, 180, 197));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfecha_nacimientoKeyPressed(evt);
            }
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txthistoria_clinicaKeyPressed(evt);
            }
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnum_docKeyPressed(evt);
            }
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

        lblnotanumero_doc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnotanumero_doc.setText("NOTA: Al terminar de introducir el N° DNI, precionar ENTER.");

        lblnotahistoriaclinica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnotahistoriaclinica.setText("NOTA: Al terminar de introducir el N° de Historia Clinica, precionar ENTER para validar si ya se encuentra agregada");

        lblnotaacceso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnotaacceso.setText("NOTA: Todo registro de historia clinica tendra un responsable.");

        lblrestaValidarHistoriaClinica.setForeground(new java.awt.Color(255, 0, 51));
        lblrestaValidarHistoriaClinica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("NOTA: Al terminar de digitar la fecha de nacimiento, precionar ENTER para generar la edad del paciente.");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("EJEMPLOS FORMATOS DE DIGITACION: 29/03/1994 - 06/12/1996 - 09/09/2015");

        jPanel3.setBackground(new java.awt.Color(158, 179, 193));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Completos de Acompañante del Paciente:"));

        txtfa_nombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres:"));
        txtfa_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_nombresKeyTyped(evt);
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

        txtfa_apellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos Completos:"));
        txtfa_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfa_apellidosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(checkselecction, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtfa_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfa_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfa_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfa_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(checkselecction)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfa_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfa_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfa_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfa_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtlugar_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlugar_proc, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboestado_civil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtocupacion))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblrestaValidarHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnotanumero_doc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblnotahistoriaclinica, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblnotaacceso, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblusuario_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblnotaacceso)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblusuario_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btnguardar)
                            .addComponent(txtidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbotipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblnotanumero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblnotahistoriaclinica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthistoria_clinica, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblrestaValidarHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbotipo_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblfecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtlugar_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlugar_proc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboestado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbledad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel1)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Connection connection = new conexion().conectar();
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

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        impHistoriaClinica imprimirHC = new impHistoriaClinica();
        imprimirHC.ImpHistoriaClinica(idhistoriaClinica_modelviewclick);
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";
        accionDNI = "validarDNI";

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

        idhistoriaClinica_modelviewclick = Integer.parseInt(txtidpaciente.getText());


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void tablalistadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoMouseEntered

    private void txtocupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtocupacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtocupacionKeyTyped

    private void txtocupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtocupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtocupacionActionPerformed

    private void txtlugar_nacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugar_nacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlugar_nacKeyTyped

    private void txtlugar_nacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugar_nacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugar_nacActionPerformed

    private void txtlugar_procKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlugar_procKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtlugar_procKeyTyped

    private void txtlugar_procActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlugar_procActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlugar_procActionPerformed

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

    private void txtnum_docKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnum_docKeyPressed
        // TODO add your handling code here:
        if (accionDNI.equals("validarDNI")) {//validar el dni cuendo el tablemodel envia ValidarDNI
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS 8 DIGITOS DEL DNI");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {
                    inhabilitar();
                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    habilitarCajasTexto();
                }

            }

        } else if (accionDNI.equals("nuevaHistoria")) {//validar dni cuento el boton
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS 8 DIGITOS DEL DNI");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {

                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txthistoria_clinica.setEnabled(true);
                }

            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (txtnum_doc.getText().length() < 8) {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE LOS 8 DIGITOS DEL DNI");
                    txtnum_doc.requestFocus();
                    return;
                }
                validarBDD validar_numero_dni = new validarBDD();
                if (validar_numero_dni.validarDni(txtnum_doc.getText())) {

                } else {
                    JOptionPane.showMessageDialog(null, "NO CUENTA CON HISTORIA CLINICA, PUEDE CREAR UNA NUEVA HISTORIA CLINICA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    txthistoria_clinica.setEnabled(true);
                }

            }

        }
    }//GEN-LAST:event_txtnum_docKeyPressed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
        txtnum_doc.transferFocus();
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void cbotipo_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentoActionPerformed
        // TODO add your handling code here:
        cbotipo_documento.transferFocus();
    }//GEN-LAST:event_cbotipo_documentoActionPerformed

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

    private void txthistoria_clinicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthistoria_clinicaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validarBDD validar_historia_clinica = new validarBDD();
            if (validar_historia_clinica.validarHistoriaClinica(txthistoria_clinica.getText())) {
                lblrestaValidarHistoriaClinica.setText(" EL N° DE HISTORIA CLINICA YA EXISTE, POR FAVOR PROBAR CON OTRO NUMERO");
                inhabilitarNuevo_Existe();
            } else {
                lblrestaValidarHistoriaClinica.setText(" PUEDE CREAR UNA NUEVA HISTORIA CLINICA CON EL N°" + txthistoria_clinica.getText() + "");
                habilitarCajasTexto();
                btnguardar.setEnabled(true);
                fecha_actual();

            }

        }
    }//GEN-LAST:event_txthistoria_clinicaKeyPressed

    private void txthistoria_clinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthistoria_clinicaActionPerformed

    }//GEN-LAST:event_txthistoria_clinicaActionPerformed

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
        int limite = 256;
        if (txtdireccion.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
        txtdireccion.transferFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        int limite = 44;
        if (txtemail.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

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

    private void txtcelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcelularActionPerformed
        // TODO add your handling code here:
        txtcelular.transferFocus();
    }//GEN-LAST:event_txtcelularActionPerformed

    private void txtfecha_nacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 24;
        //        if (Character.isDigit(c)) {
        //            evt.consume();
        //        }
        if (txtfecha_nacimiento.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyTyped

    private void txtfecha_nacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoKeyPressed
        try { // ALGORITMO PARA SACAR LA EDAD Y LANZARLO AL LBLEDAD
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                //PARA SACAR LA EDAD A TRAVES DE LA FECHA DE NACIMIENTO           
                DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechamacimineto = LocalDate.parse(txtfecha_nacimiento.getText(), date);
                LocalDate fechaactual = LocalDate.now();

                Period periodo = Period.between(fechamacimineto, fechaactual);
                String resultado = (+periodo.getYears() + " Años " + periodo.getMonths() + " Meses" + " y " + periodo.getDays() + " Dias");

                lbledad.setText(resultado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "INGRESE CORRECTAMENTE LA FECHA", "Error de Digitacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtfecha_nacimientoKeyPressed

    private void txtfecha_nacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_nacimientoActionPerformed
        // TODO add your handling code here:
        txtfecha_nacimiento.transferFocus();
    }//GEN-LAST:event_txtfecha_nacimientoActionPerformed

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

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
        txtapellidos.transferFocus();
    }//GEN-LAST:event_txtapellidosActionPerformed

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

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void checkselecctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkselecctionActionPerformed
        // TODO add your handling code here:
        seleccionarFamiliar();
    }//GEN-LAST:event_checkselecctionActionPerformed

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

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:

        inhabilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
        accionDNI = "nuevaHistoria";
        checkselecction.setSelected(false);
        seleccionarFamiliar();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyTyped

    }//GEN-LAST:event_btnguardarKeyTyped

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:12
        String dni;
        dni = txtbuscar.getText();
        mostrar(dni);
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
        //codigo para validar dato numero y limitar los digitos.....
//        char c = evt.getKeyChar();
//        int limiete = 8;
//        if (!Character.isDigit(c)) {//si es diferente a letra...
//            evt.consume();
//        }
//        if (txtnum_doc.getText().length() == limiete) {
//            evt.consume();
//        }
    }//GEN-LAST:event_txtbuscarKeyTyped

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbledad;
    private javax.swing.JLabel lblfecha_registro;
    private javax.swing.JLabel lblnotaacceso;
    private javax.swing.JLabel lblnotahistoriaclinica;
    private javax.swing.JLabel lblnotanumero_doc;
    private javax.swing.JLabel lblrestaValidarHistoriaClinica;
    private javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JLabel lblusuario_acceso;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtbuscar;
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
