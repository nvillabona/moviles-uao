package com.example.screenlogin;

// Curso
public class Class {
    private String nombre;
    private String descripcion;
    private String fechas;
    private String horario;
    private String codigoProfesor;
    private double Latitud;
    private double Longitud;

    public Class(String nombre, String descripcion, String fechas, String horario, String codigoProfesor, double latitud, double longitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechas = fechas;
        this.horario = horario;
        this.codigoProfesor = codigoProfesor;
        Latitud = latitud;
        Longitud = longitud;
    }

    /* El constructor vacío es necesario */
    public Class() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }
}
