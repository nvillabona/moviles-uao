package com.example.screenlogin;

import java.io.Serializable;

//Profesor
public class Teacher implements Serializable {
    private String nombres;
    private String apellidos;
    private String horarios;
    private String correo;
    private String telefono;
    private String codigo;

    public Teacher(String nombres, String apellidos, String horarios, String correo, String telefono, String codigo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horarios = horarios;
        this.correo = correo;
        this.telefono = telefono;
        this.codigo = codigo;
    }

    /* El constructor vacío es necesario */
    public Teacher() {

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
