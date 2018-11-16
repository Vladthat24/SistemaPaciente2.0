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
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Direccion","Cargo Intitucion","Modalidad Contrato", "Doc", "Número Documento", "Celular", "Email", "FechaCreacion"};

        String[] registro = new String[12];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idptrabajador,p.nombre,p.apaterno,p.amaterno,p.direccion,p.cargo_institucion,p.modalidad_contrato,p.tipo_documento,"
                + "t.num_documento,t.celular,t.email,t.fecha_registro from persona_trabajador p inner join trabajador t "
                + "on p.idptrabajador=t.idptrabajador where num_documento like '%"
                + buscar + "%' order by idptrabajador desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idptrabajador");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("cargo_institucion");
                registro[6] = rs.getString("modalidad_contrato");
                registro[7] = rs.getString("tipo_documento");
                registro[8] = rs.getString("num_documento");
                registro[9] = rs.getString("celular");
                registro[10] = rs.getString("email");
                registro[11] = rs.getString("fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 01");
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into persona_trabajador (nombre,apaterno,amaterno,direccion,cargo_institucion,modalidad_contrato,tipo_documento)"
                + "values (?,?,?,?,?,?,?)";
        sSQL2 = "insert into trabajador(idptrabajador,num_documento,celular,email,fecha_registro)"
                + "values ((select idptrabajador from persona_trabajador order by idptrabajador desc limit 1),?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareCall(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCargo_institucion());
            pst.setString(6, dts.getModalidad_contrato());
            pst.setString(7, dts.getTipo_documento());

            pst2.setString(1, dts.getNum_documento());
            pst2.setString(2, dts.getCelular());
            pst2.setString(3, dts.getEmail());
            pst2.setString(4, dts.getFecha_registro());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 02");
            return false;
        }
    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update persona_trabajador set nombre=?,apaterno=?,amaterno=?,direccion=?,cargo_institucion=?,modalidad_contrato=?,tipo_documento=? where idptrabajador=?";
        sSQL2 = "update trabajador set num_documento=?,celular=?,email=?,fecha_registro=? where idptrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareCall(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCargo_institucion());
            pst.setString(6, dts.getModalidad_contrato());
            pst.setString(7, dts.getTipo_documento());
            pst.setInt(8, dts.getIdptrabajador());

            pst2.setString(1, dts.getNum_documento());
            pst2.setString(2, dts.getCelular());
            pst2.setString(3, dts.getEmail());
            pst2.setString(4, dts.getFecha_registro());
            pst2.setInt(5, dts.getIdptrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 03");
            return false;
        }
    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idptrabajador=?";
        sSQL2 = "delete from persona_trabajador where idptrabajador=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareCall(sSQL2);

            pst.setInt(1, dts.getIdptrabajador());
            pst2.setInt(1, dts.getIdptrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "error 04");
            return false;
        }
    }

//    public DefaultTableModel login(String login, String password) {
//        DefaultTableModel modelo;
//
//        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Acceso", "Login", "Clave", "Estado"};
//
//        String[] registro = new String[8];
//
//        totalregistros = 0;
//        modelo = new DefaultTableModel(null, titulos);
//
//        sSQL = "select p.idpersoa,p.nombre,p.apaterno,p.amaterno,"
//                + "t.acceso,t.login,t.password,t.estado from persona p inner join Trabajador t "
//                + "on p.idpersona=t.idpersona where t.login='"
//                + login + "' and t.password='" + password + "' and t.estado='A'";
//
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//
//            while (rs.next()) {
//                registro[0] = rs.getString("idpersona");
//                registro[1] = rs.getString("nombre");
//                registro[2] = rs.getString("apaterno");
//                registro[3] = rs.getString("amaterno");
//
//                registro[4] = rs.getString("acceso");
//                registro[5] = rs.getString("login");
//                registro[6] = rs.getString("password");
//                registro[7] = rs.getString("estado");
//
//                totalregistros = totalregistros + 1;
//                modelo.addRow(registro);
//
//            }
//            return modelo;
//
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//
//    }
}
