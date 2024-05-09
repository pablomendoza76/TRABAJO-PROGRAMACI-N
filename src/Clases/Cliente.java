/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author Usuario iTC
 */
@Entity
public class Cliente extends Persona {
    private String celular;
    private ArrayList<Dirección>direcciones ;

    public Cliente() {
    }

    public Cliente(String celular, ArrayList<Dirección> direcciones) {
        this.celular = celular;
        this.direcciones = new ArrayList<>();
    }

    public Cliente(String celular, ArrayList<Dirección> direcciones, String dni, String nombre, String apellido, String gamil) {
        super(dni, nombre, apellido, gamil);
        this.celular = celular;
        this.direcciones = new ArrayList<>();
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ArrayList<Dirección> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Dirección> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", direcciones=" + direcciones + '}';
    }

   
    
}
