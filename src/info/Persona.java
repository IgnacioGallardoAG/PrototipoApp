/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

/**
 *
 * @author altra
 */
public class Persona {
    private String nombre;
    private String run;
    private String direccion;
    private String correo;
    private String numeroCelular;
    private int numFamiliares;

    // Constructor, getters y setters aquí

    public String getNombre() {
        return nombre;
    }

    public String getRun() {
        return run;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public int getNumFamiliares() {
        return numFamiliares;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setNumFamiliares(int numFamiliares) {
        this.numFamiliares = numFamiliares;
    }
    
    
}
