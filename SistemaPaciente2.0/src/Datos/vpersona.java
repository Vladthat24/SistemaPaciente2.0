/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author VladHat
 */
public class vpersona {

    private int idpersona;
    private String historia_clinica;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String tipo_seguro;
    private String direccion;
    private String celular;
    private String email;
    private String fecha_nacimiento;
    private String sexo;
    private String edad;
    private String fa_nombres;
    private String fa_apellidos;
    private String fa_edad;
    private String fa_direccion;
    private String fecha_actual;
    private String estado_civil;
    private String tipo_documento;
   

    

    public vpersona() {
    }

    public vpersona(int idpersona, String historia_clinica, String nombre, String apaterno, String amaterno, String tipo_seguro, String direccion, String celular, String email, String fecha_nacimiento, String sexo, String edad, String fa_nombres, String fa_apellidos, String fa_edad, String fa_direccion, String fecha_actual, String estado_civil, String tipo_documento) {
        this.idpersona = idpersona;
        this.historia_clinica = historia_clinica;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.tipo_seguro = tipo_seguro;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.edad = edad;
        this.fa_nombres = fa_nombres;
        this.fa_apellidos = fa_apellidos;
        this.fa_edad = fa_edad;
        this.fa_direccion = fa_direccion;
        this.fecha_actual = fecha_actual;
        this.estado_civil = estado_civil;
        this.tipo_documento = tipo_documento;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(String historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTipo_seguro() {
        return tipo_seguro;
    }

    public void setTipo_seguro(String tipo_seguro) {
        this.tipo_seguro = tipo_seguro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFa_nombres() {
        return fa_nombres;
    }

    public void setFa_nombres(String fa_nombres) {
        this.fa_nombres = fa_nombres;
    }

    public String getFa_apellidos() {
        return fa_apellidos;
    }

    public void setFa_apellidos(String fa_apellidos) {
        this.fa_apellidos = fa_apellidos;
    }

    public String getFa_edad() {
        return fa_edad;
    }

    public void setFa_edad(String fa_edad) {
        this.fa_edad = fa_edad;
    }

    public String getFa_direccion() {
        return fa_direccion;
    }

    public void setFa_direccion(String fa_direccion) {
        this.fa_direccion = fa_direccion;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

   
    
}
