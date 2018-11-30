
package Logica;
import Datos.vpaciente;

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
public class fpaciente {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID","IDACCESO","USUARIO", "H. CLINICA", "NOMBRES", "APELLIDOS","TIPO SEGURO", "DIRECCION", "CELULAR","EMAIL","FECHA NAC.", "LUGAR NAC.",
                "           LUGAR PROC.","SEXO","EDAD","FECHA REG.","ESTADO CIVIL","TIPO DOC.","N° DOC.","GRADO INSTRUC.","OCUPACION","RELIGION","FA NOMBRES","FA APELLIDOS",
                            "FA EDAD","FA DIREC."};

        String[] registro = new String[26];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select idpaciente,idacceso,usuario_acceso,historia_clinica,nombre,apellidos,"
                + "tipo_seguro,direccion,celular,"
                + "email,fecha_nac,lugar_nac,lugar_proc,sexo,edad,fecha_reg,estado_civil,tipo_doc,num_doc,"
                + "grado_instruc,ocupacion,"
                + "religion,fa_nombres,fa_apellidos,fa_edad,fa_direccion"
                + " from paciente where nombre like '%"+ buscar + "%' or apellidos like '%"+ buscar+"%' or "
                + "historia_clinica like '%"
                + buscar+"%' num_doc like '%"+ buscar+"%' order by idpaciente desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpaciente");
                registro[1]=rs.getString("idacceso");
                registro[2] = rs.getString("usuario_acceso");
                registro[3] = rs.getString("historia_clinica");
                registro[4] = rs.getString("nombre");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("tipo_seguro");
                registro[7] = rs.getString("direccion");
                registro[8] = rs.getString("celular");
                registro[9] = rs.getString("email");
                registro[10] = rs.getString("fecha_nac");
                registro[11] = rs.getString("lugar");
                registro[12] = rs.getString("");
                registro[13] = rs.getString("fa_apellidos");
                registro[14] = rs.getString("fa_edad");
                registro[15] = rs.getString("fa_direccion");
                registro[16] = rs.getString("fecha_actual");
                registro[17] = rs.getString("estado_civil");
                registro[18] = rs.getString("tipo_documento");
                registro[19] = rs.getString("codigo_paciente_dni");
                

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + " PACIENTES BUSCAR 1 ");
            return null;
        }

    }

    public boolean insertar(vpaciente dts) {
        sSQL = "insert into persona (historia_clinica,nombre,apaterno,amaterno,tipo_seguro,"
                +"direccion,celular,email,fecha_nacimiento,sexo,edad,fa_nombres,fa_apellidos,"
                + "fa_edad,fa_direccion,fecha_actual,estado_civil,tipo_documento)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into h_paciente (idpersona,codigo_paciente_dni)"
                + "values ((select idpersona from persona order by idpersona desc limit 1),?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getHistoria_clinica());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApaterno());
            pst.setString(4, dts.getAmaterno());
            pst.setString(5, dts.getTipo_seguro());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getCelular());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_nacimiento());
            pst.setString(10, dts.getSexo());
            pst.setString(11, dts.getEdad());
            pst.setString(12, dts.getFa_nombres());
            pst.setString(13, dts.getFa_apellidos());
            pst.setString(14, dts.getFa_edad());
            pst.setString(15, dts.getFa_direccion());
            pst.setString(16, dts.getFecha_actual());
            pst.setString(17, dts.getEstado_civil());
            pst.setString(18, dts.getTipo_documento());

            pst2.setString(1, dts.getCodigo_paciente_dni());

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
            JOptionPane.showConfirmDialog(null, e + "fh_error 02");
            return false;
        }
    }

    public boolean editar( dts) {
        sSQL = "update persona set historia_clinica=?,nombre=?,apaterno=?,amaterno=?,"
                + "tipo_seguro=?,direccion=?,celular=?,email=?,fecha_nacimiento=?,"
                + "sexo=?,edad=?,fa_nombres=?,fa_apellidos=?,fa_edad=?,fa_direccion=?,fecha_actual=?,estado_civil=?,"
                + "tipo_documento=? where idpersona=?";

        sSQL2 = "update h_paciente set codigo_paciente_dni=?"
                + " where idpersona=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getHistoria_clinica());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApaterno());
            pst.setString(4, dts.getAmaterno());
            pst.setString(5, dts.getTipo_seguro());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getCelular());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_nacimiento());
            pst.setString(10, dts.getSexo());
            pst.setString(11, dts.getEdad());
            pst.setString(12, dts.getFa_nombres());
            pst.setString(13, dts.getFa_apellidos());
            pst.setString(14, dts.getFa_edad());
            pst.setString(15, dts.getFa_direccion());
            pst.setString(16, dts.getFecha_actual());
            pst.setString(17, dts.getEstado_civil());
            pst.setString(18, dts.getTipo_documento());
            pst.setInt(19, dts.getIdpersona());

            pst2.setString(1, dts.getCodigo_paciente_dni());
            pst2.setInt(2, dts.getIdpersona());

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
            JOptionPane.showConfirmDialog(null, e + " fh_error 03");
            return false;
        }
    }

    public boolean eliminar(vh_paciente dts) {
        sSQL = "delete from h_paciente where idpersona=?";
        sSQL2 = "delete from persona where idpersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdpersona());

            pst2.setInt(1, dts.getIdpersona());

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
}
