/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

public class vtrabajador {

    private int idtrabajador;
    private String nombre;
    private String apellidos;
    private String tipo_doc;
    private String num_dni;
    private String cargo_inst;
    private String mod_cont;
    private String num_cel;
    private String email;
    private String fecha_reg;

    public vtrabajador() {
    }

    public vtrabajador(int idtrabajador, String nombre, String apellidos, String tipo_doc, String num_dni, String cargo_inst, String mod_cont, String num_cel, String email, String fecha_reg) {
        this.idtrabajador = idtrabajador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo_doc = tipo_doc;
        this.num_dni = num_dni;
        this.cargo_inst = cargo_inst;
        this.mod_cont = mod_cont;
        this.num_cel = num_cel;
        this.email = email;
        this.fecha_reg = fecha_reg;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_dni() {
        return num_dni;
    }

    public void setNum_dni(String num_dni) {
        this.num_dni = num_dni;
    }

    public String getCargo_inst() {
        return cargo_inst;
    }

    public void setCargo_inst(String cargo_inst) {
        this.cargo_inst = cargo_inst;
    }

    public String getMod_cont() {
        return mod_cont;
    }

    public void setMod_cont(String mod_cont) {
        this.mod_cont = mod_cont;
    }

    public String getNum_cel() {
        return num_cel;
    }

    public void setNum_cel(String num_cel) {
        this.num_cel = num_cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

  
}
