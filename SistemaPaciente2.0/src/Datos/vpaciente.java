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
public class vpaciente {
    
  private int idpaciente;
  private String usuario_acceso;
  private String hitoria_clinica;
  private String nombre;
  private String apellidos;
  private String tipo_seguro;
  private String direccion;
  private String celular;
  private String email;
  private String fecha_nac;
  private String lugar_nac;
  private String lugar_proc;
  private String sexo;
  private String edad;
  private String fecha_reg;
  private String estado_civil;
  private String tipo_doc;
  private String num_doc;
  private String ocupacion;
  private String religion;
  private String fa_nombres;
  private String fa_apellidos;
  private String fa_edad;
  private String fa_direccion;

    public vpaciente() {
    }

    public vpaciente(int idpaciente, String usuario_acceso, String hitoria_clinica, String nombre, String apellidos, String tipo_seguro, String direccion, String celular, String email, String fecha_nac, String lugar_nac, String lugar_proc, String sexo, String edad, String fecha_reg, String estado_civil, String tipo_doc, String num_doc, String ocupacion, String religion, String fa_nombres, String fa_apellidos, String fa_edad, String fa_direccion) {
        this.idpaciente = idpaciente;
        this.usuario_acceso = usuario_acceso;
        this.hitoria_clinica = hitoria_clinica;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo_seguro = tipo_seguro;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.lugar_proc = lugar_proc;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha_reg = fecha_reg;
        this.estado_civil = estado_civil;
        this.tipo_doc = tipo_doc;
        this.num_doc = num_doc;
        this.ocupacion = ocupacion;
        this.religion = religion;
        this.fa_nombres = fa_nombres;
        this.fa_apellidos = fa_apellidos;
        this.fa_edad = fa_edad;
        this.fa_direccion = fa_direccion;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getUsuario_acceso() {
        return usuario_acceso;
    }

    public void setUsuario_acceso(String usuario_acceso) {
        this.usuario_acceso = usuario_acceso;
    }

    public String getHitoria_clinica() {
        return hitoria_clinica;
    }

    public void setHitoria_clinica(String hitoria_clinica) {
        this.hitoria_clinica = hitoria_clinica;
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

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getLugar_proc() {
        return lugar_proc;
    }

    public void setLugar_proc(String lugar_proc) {
        this.lugar_proc = lugar_proc;
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

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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

 
}

