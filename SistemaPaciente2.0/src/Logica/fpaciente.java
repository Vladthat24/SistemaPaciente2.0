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

        String[] titulos = {"ID", "USUARIO", "H. CLINICA", "NOMBRES", "APELLIDOS", "TIPO SEGURO", "DIRECCION", "CELULAR", "EMAIL", "FECHA NAC.", "LUGAR NAC.",
            "LUGAR PROC.", "SEXO", "EDAD", "FECHA REG.", "ESTADO CIVIL", "TIPO DOC.", "N° DOC.", "OCUPACION", "RELIGION", "FA NOMBRES", "FA APELLIDOS",
            "FA EDAD", "FA DIREC."};

        String[] registro = new String[24];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

//        sSQL = "select * from paciente where num_doc like '%"+buscar+"%'"
//                + " OR apellidos like '%"+buscar+"%' order by idpaciente desc limit 50000";
        sSQL = "select * from paciente where num_doc like '%" + buscar + "%' order by idpaciente desc limit 50000";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpaciente");
                registro[1] = rs.getString("usuario_acceso");
                registro[2] = rs.getString("historia_clinica");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("apellidos");
                registro[5] = rs.getString("tipo_seguro");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("celular");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("fecha_nac");
                registro[10] = rs.getString("lugar_nac");
                registro[11] = rs.getString("lugar_proc");
                registro[12] = rs.getString("sexo");
                registro[13] = rs.getString("edad");
                registro[14] = rs.getString("fecha_reg");
                registro[15] = rs.getString("estado_civil");
                registro[16] = rs.getString("tipo_doc");
                registro[17] = rs.getString("num_doc");
                registro[18] = rs.getString("ocupacion");
                registro[19] = rs.getString("religion");
                registro[20] = rs.getString("fa_nombres");
                registro[21] = rs.getString("fa_apellidos");
                registro[22] = rs.getString("fa_edad");
                registro[23] = rs.getString("fa_direccion");

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

        sSQL = "insert into paciente (usuario_acceso,historia_clinica,nombre,apellidos,"
                + "tipo_seguro,direccion,celular,"
                + "email,fecha_nac,lugar_nac,lugar_proc,sexo,edad,fecha_reg,estado_civil,tipo_doc,num_doc,"
                + "ocupacion,"
                + "religion,fa_nombres,fa_apellidos,fa_edad,fa_direccion)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getUsuario_acceso());
            pst.setString(2, dts.getHitoria_clinica());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getApellidos());
            pst.setString(5, dts.getTipo_seguro());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getCelular());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_nac());
            pst.setString(10, dts.getLugar_nac());
            pst.setString(11, dts.getLugar_proc());
            pst.setString(12, dts.getSexo());
            pst.setString(13, dts.getEdad());
            pst.setString(14, dts.getFecha_reg());
            pst.setString(15, dts.getEstado_civil());
            pst.setString(16, dts.getTipo_doc());
            pst.setString(17, dts.getNum_doc());
            pst.setString(18, dts.getOcupacion());
            pst.setString(19, dts.getReligion());
            pst.setString(20, dts.getFa_nombres());
            pst.setString(21, dts.getFa_apellidos());
            pst.setString(22, dts.getFa_edad());
            pst.setString(23, dts.getFa_direccion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "PACIENTE INSERT 02");
            return false;
        }

    }

    public boolean editar(vpaciente dts) {
        sSQL = "update paciente set usuario_acceso=?,"
                + "historia_clinica=?,nombre=?,apellidos=?,"
                + "tipo_seguro=?,direccion=?,celular=?,"
                + "email=?,fecha_nac=?,lugar_nac=?,lugar_proc=?,"
                + "sexo=?,edad=?,fecha_reg=?,estado_civil=?,"
                + "tipo_doc=?,num_doc=?,"
                + "ocupacion=?,"
                + "religion=?,fa_nombres=?,fa_apellidos=?,fa_edad=?,fa_direccion=?"
                + " where idpaciente=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getUsuario_acceso());
            pst.setString(2, dts.getHitoria_clinica());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getApellidos());
            pst.setString(5, dts.getTipo_seguro());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getCelular());
            pst.setString(8, dts.getEmail());
            pst.setString(9, dts.getFecha_nac());
            pst.setString(10, dts.getLugar_nac());
            pst.setString(11, dts.getLugar_proc());
            pst.setString(12, dts.getSexo());
            pst.setString(13, dts.getEdad());
            pst.setString(14, dts.getFecha_reg());
            pst.setString(15, dts.getEstado_civil());
            pst.setString(16, dts.getTipo_doc());
            pst.setString(17, dts.getNum_doc());
            pst.setString(18, dts.getOcupacion());
            pst.setString(19, dts.getReligion());
            pst.setString(20, dts.getFa_nombres());
            pst.setString(21, dts.getFa_apellidos());
            pst.setString(22, dts.getFa_edad());
            pst.setString(23, dts.getFa_direccion());
            pst.setInt(24, dts.getIdpaciente());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + " PACIENTE EDIT 03");
            return false;
        }
    }

    public boolean eliminar(vpaciente dts) {
        sSQL = "delete from paciente where idpaciente=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdpaciente());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "PACIENTE ELIMINAR 04");
            return false;
        }
    }
}
