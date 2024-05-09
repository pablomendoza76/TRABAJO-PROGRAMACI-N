/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
//Empleado
/**
 *
 * @author Usuario iTC
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.persistence.Entity;

import javax.persistence.Entity;

/**
 *
 * @author Usuario iTC
 */
@Entity
public class Empleado extends Persona {
    private String ciudad;

    public Empleado() {
    }

    public Empleado(String ciudad) {
        this.ciudad = ciudad;
    }

    public Empleado(String ciudad, String dni, String nombre, String apellido, String gamil) {
        super(dni, nombre, apellido, gamil);
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ciudad=" + ciudad + '}';
    }
    

}
