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
public class vacceso{
    
     private int idacceso;
     private String acceso;
     private int idtrabajador;
     private String login;
     private String password;
     private String estado;


    public vacceso() {
    }

    public vacceso(int idacceso, String acceso, int idtrabajador, String login, String password, String estado) {
        this.idacceso = idacceso;
        this.acceso = acceso;
        this.idtrabajador = idtrabajador;
        this.login = login;
        this.password = password;
        this.estado = estado;
    }

    public int getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(int idacceso) {
        this.idacceso = idacceso;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
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

   
    
     
     
}
