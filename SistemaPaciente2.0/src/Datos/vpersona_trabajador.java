/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author INFORMATICA
 */
public class vpersona_trabajador {
    private int idptrabajador;
    private String nombre;
    private String amaterno;
    private String apaterno;
    private String direccion;
    private String cargo_institucion;
    private String modalidad_contrato;
    private String tipo_documento;

    public vpersona_trabajador() {
    }

    public vpersona_trabajador(int idptrabajador, String nombre, String amaterno, String apaterno, String direccion, String cargo_institucion, String modalidad_contrato, String tipo_documento) {
        this.idptrabajador = idptrabajador;
        this.nombre = nombre;
        this.amaterno = amaterno;
        this.apaterno = apaterno;
        this.direccion = direccion;
        this.cargo_institucion = cargo_institucion;
        this.modalidad_contrato = modalidad_contrato;
        this.tipo_documento = tipo_documento;
    }

    public int getIdptrabajador() {
        return idptrabajador;
    }

    public void setIdptrabajador(int idptrabajador) {
        this.idptrabajador = idptrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo_institucion() {
        return cargo_institucion;
    }

    public void setCargo_institucion(String cargo_institucion) {
        this.cargo_institucion = cargo_institucion;
    }

    public String getModalidad_contrato() {
        return modalidad_contrato;
    }

    public void setModalidad_contrato(String modalidad_contrato) {
        this.modalidad_contrato = modalidad_contrato;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

 
    
    
}
