/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vacceso;
import Datos.vpaciente;
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
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "NOMBRE", "APELLIDOS", "TIPO DOC.", "NUM. DNI", "CARGO INST.", "MOD. CONTRAT.", "NUM. CEL.", "EMAIL", "FECHA REG."};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select idtrabajador,nombre,apellidos,tipo_doc,num_dni,cargo_inst,mod_cont,num_cel,email,fecha_reg from trabajador where num_dni like '%"
                + buscar + "%' order by idtrabajador desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idtrabajador");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("tipo_doc");
                registro[4] = rs.getString("num_dni");
                registro[5] = rs.getString("cargo_inst");
                registro[6] = rs.getString("mod_cont");
                registro[7] = rs.getString("num_cel");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("fecha_reg");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR TRABAJADOR 01");
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into trabajador (nombre,apellidos,tipo_doc,num_dni,cargo_inst,mod_cont,num_cel,email,fecha_reg)"
                + "values (?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipo_doc());
            pst.setString(4, dts.getNum_dni());
            pst.setString(5, dts.getCargo_inst());
            pst.setString(6, dts.getMod_cont());
            pst.setString(7, dts.getNum_cel());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_reg());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR TRABAJADOR 02");
            return false;
        }
    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update trabajador set nombre=?,apellido=?,tipo_doc=?,num_dni=?,cargo_inst=?,"
                + "mod_cont=?,num_cel=?,email=?,fecha_reg=? where idtrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTipo_doc());
            pst.setString(4, dts.getNum_dni());
            pst.setString(5, dts.getCargo_inst());
            pst.setString(6, dts.getMod_cont());
            pst.setString(7, dts.getNum_cel());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_reg());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "ERROR TRABAJADOR 03");
            return false;
        }
    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idtrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdtrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 04");
            return false;
        }
    }

}
