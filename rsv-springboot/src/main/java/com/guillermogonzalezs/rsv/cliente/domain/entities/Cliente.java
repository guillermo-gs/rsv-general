package com.guillermogonzalezs.rsv.cliente.domain.entities;


import java.math.BigDecimal;
import java.util.Date;

public class Cliente {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fisicoJuridico;
    private String telefono;
    private String direccion;
    private String cpostal;
    private String poblacion;
    private String email;
    private Boolean activo;
    private String nombreCompleto;

    public Cliente() {

    }

    public Integer getId() {
        return id;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellidos;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFisicoJuridico() {
        return fisicoJuridico;
    }

    public void setFisicoJuridico(String fisicoJuridico) {
        this.fisicoJuridico = fisicoJuridico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}