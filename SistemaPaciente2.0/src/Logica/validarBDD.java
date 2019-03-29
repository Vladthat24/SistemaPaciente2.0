/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Informatica
 */
public class validarBDD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql = "";

    public boolean validarDni(String num_dni) {
        try {
            sql = "select num_doc from paciente where num_doc ='" + num_dni + "'";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "N° DNI " + num_dni + " YA TIENE HISTORIA", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
    public boolean validarHistoriaClinica(String historiaClinica){
        try {
            sql="select historia_clinica from paciente where historia_clinica='"+ historiaClinica +"'";
            PreparedStatement pst= cn.prepareCall(sql);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        
    }

}
