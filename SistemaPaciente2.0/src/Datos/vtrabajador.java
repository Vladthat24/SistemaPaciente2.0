/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

public class vtrabajador extends vpersona_trabajador {

    private String num_documento;
    private String celular;
    private String email;
    private String fecha_registro;

    public vtrabajador() {
    }

    public vtrabajador(String num_documento, String celular, String email, String fecha_registro) {
        this.num_documento = num_documento;
        this.celular = celular;
        this.email = email;
        this.fecha_registro = fecha_registro;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
