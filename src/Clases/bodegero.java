/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
//bodegero

import javax.persistence.Entity;

/**
 *
 * @author Usuario iTC
 */
@Entity
public class bodegero extends Empleado {
    private String local;

    public bodegero() {
    }

    public bodegero(String local) {
        this.local = local;
    }

    public bodegero(String local, String ciudad) {
        super(ciudad);
        this.local = local;
    }

    public bodegero(String local, String ciudad, String dni, String nombre, String apellido, String gamil) {
        super(ciudad, dni, nombre, apellido, gamil);
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "bodegero{" + "local=" + local + '}';
    }
    
}
