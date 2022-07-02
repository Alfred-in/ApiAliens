package com.example.apialiensapp.model;

public class Usuario {
    private String alien_usuario;
    private String alien_nombre;
    private String alien_ap;
    private String alien_am;
    private String alien_correo;
    private String alien_contrasenia;
    private String alien_nac;
    private String alien_status;
    private String Mensaje;

    public Usuario(String alien_usuario, String alien_nombre, String alien_ap, String alien_am, String alien_correo, String alien_contrasenia, String alien_nac, String alien_status) {
        this.alien_usuario = alien_usuario;
        this.alien_nombre = alien_nombre;
        this.alien_ap = alien_ap;
        this.alien_am = alien_am;
        this.alien_correo = alien_correo;
        this.alien_contrasenia = alien_contrasenia;
        this.alien_nac = alien_nac;
        this.alien_status = alien_status;
    }
    public Usuario(String alien_usuario, String alien_nombre, String alien_ap, String alien_am, String alien_correo, String alien_contrasenia, String alien_nac) {
        this.alien_usuario = alien_usuario;
        this.alien_nombre = alien_nombre;
        this.alien_ap = alien_ap;
        this.alien_am = alien_am;
        this.alien_correo = alien_correo;
        this.alien_contrasenia = alien_contrasenia;
        this.alien_nac = alien_nac;
    }
    public String getAlien_usuario() {
        return alien_usuario;
    }

    public void setAlien_usuario(String alien_usuario) {
        this.alien_usuario = alien_usuario;
    }

    public String getAlien_nombre() {
        return alien_nombre;
    }

    public void setAlien_nombre(String alien_nombre) {
        this.alien_nombre = alien_nombre;
    }

    public String getAlien_ap() {
        return alien_ap;
    }

    public void setAlien_ap(String alien_ap) {
        this.alien_ap = alien_ap;
    }

    public String getAlien_am() {
        return alien_am;
    }

    public void setAlien_am(String alien_am) {
        this.alien_am = alien_am;
    }

    public String getAlien_correo() {
        return alien_correo;
    }

    public void setAlien_correo(String alien_correo) {
        this.alien_correo = alien_correo;
    }

    public String getAlien_contrasenia() {
        return alien_contrasenia;
    }

    public void setAlien_contrasenia(String alien_contrasenia) {
        this.alien_contrasenia = alien_contrasenia;
    }

    public String getAlien_nac() {
        return alien_nac;
    }

    public void setAlien_nac(String alien_nac) {
        this.alien_nac = alien_nac;
    }

    public String getAlien_status() {
        return alien_status;
    }

    public void setAlien_status(String alien_status) {
        this.alien_status = alien_status;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
