/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vacceso;
import Datos.vtrabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class facceso {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDTRABAJADOR", "NOMBRE DEL TRABJ.","APELL. DEL TRABJ.", "ACCESO", "USUARIO", "CONTRASEÑA", "ESTADO","FECHA REG."};

        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
//        sSQL = "select idacceso,acceso,idtrabajador,login,password,estado from acceso where idtrabajador IN (select nombre from persona_trabajador where idtrabajador=idtrabajador)";

        sSQL = "select idacceso,idtrabajador,"
                + "(select nombre from trabajador where idtrabajador=idtrabajador) as tnombre,"
                + "(select apellidos from trabajador where idtrabajador=idtrabajador) as tapellidos,"
                + "acceso,login,password,estado,fecha_reg from acceso where login like '%" + buscar + "%' order by idacceso desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idacceso");
                registro[1] = rs.getString("idtrabajador");
                registro[2] = rs.getString("tnombre");
                registro[3] = rs.getString("tapellidos");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");
                registro[8] = rs.getString("fecha_reg");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR 1 FACCESO");
            return null;
        }

    }

    public boolean insertar(vacceso dts) {
        sSQL = "insert into acceso (idtrabajador,acceso,login,password,estado,fecha_reg)"
                + "values (?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

 
            pst.setInt(1, dts.getIdtrabajador());
            pst.setString(2, dts.getAcceso());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getPassword());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getFecha_reg());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR 2 FACCESO");
            return false;
        }
    }

    public boolean editar(vacceso dts) {
        sSQL = "update acceso set idtrabajador=?,acceso=?,login=?,password=?,estado=?,fecha_reg=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

           
            pst.setInt(1, dts.getIdtrabajador());
            pst.setString(2, dts.getAcceso());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getPassword());
            pst.setString(5, dts.getEstado());
            pst.setString(6, dts.getFecha_reg());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR 3 FACCESO");
            return false;
        }
    }

    public boolean eliminar(vacceso dts) {
        sSQL = "delete from acceso where idacceso=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdacceso());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR 2 FACCESO");
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
        String[] titulos = {"IDACCESO", "IDTRABAJADOR", "TRABAJADOR", "ACCESO", "USUARIO", "CONTRASEÑA", "ESTADO","FECHA REG."};
        String[] registros = new String[8];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT idacceso,idtrabajador,"
                + "(select nombre from trabajador where idtrabajador=idtrabajador) as nombretrab,"
                + "(select apellidos from trabajador where idtrabajador=idtrabajador)as apellidos,"
                + "acceso,login,password,estado,fecha_reg from acceso where login='" + login + "' and password='" + password + "' and estado='ACTIVO'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registros[0] = rs.getString("idacceso");
                registros[1] = rs.getString("idtrabajador");
                registros[2] = rs.getString("nombretrab") + " " + rs.getString("apellidos");
                registros[3] = rs.getString("acceso");
                registros[4] = rs.getString("login");
                registros[5] = rs.getString("password");
                registros[6] = rs.getString("estado");
                registros[7] =rs.getString("fecha_reg");

                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR DEFAULTTABLEMODEL ACCESO LOGIN ");
            return null;
        }
    }
}
