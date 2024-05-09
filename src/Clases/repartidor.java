/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.persistence.Entity;

/**
 *
 * @author Usuario iTC
 */
@Entity
public class repartidor extends Empleado{
    private int zona;

    public repartidor() {
    }
    

    public repartidor(int par, String string, String pablo, String mendoza, String pablogmailcom) {
    }

    public repartidor(int zona) {
        this.zona = zona;
    }

    public repartidor(int zona, String ciudad) {
        super(ciudad);
        this.zona = zona;
    }

    public repartidor(int zona, String ciudad, String dni, String nombre, String apellido, String gamil) {
        super(ciudad, dni, nombre, apellido, gamil);
        this.zona = zona;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "repartidor{" + "zona=" + zona + '}';
    }
    
}
