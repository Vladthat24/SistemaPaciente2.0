/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author CARLOS
 */
public class vacceso {

    private int idacceso;
    private int idtrabajador;
    private String acceso;
    private String login;
    private String password;
    private String estado;
    private String fecha_reg;

    public vacceso() {
    }

    public vacceso(int idacceso, int idtrabajador, String acceso, String login, String password, String estado, String fecha_reg) {
        this.idacceso = idacceso;
        this.idtrabajador = idtrabajador;
        this.acceso = acceso;
        this.login = login;
        this.password = password;
        this.estado = estado;
        this.fecha_reg = fecha_reg;
    }

    public int getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(int idacceso) {
        this.idacceso = idacceso;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

}
