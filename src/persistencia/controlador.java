/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Clases.Cliente;
import Clases.bodegero;
import Clases.repartidor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario iTC
 */
public class controlador {
    bodegeroJpaController bodegeroJPA = new bodegeroJpaController();
    ClienteJpaController clienteJPA = new ClienteJpaController();
    repartidorJpaController repartJPA = new repartidorJpaController();
    public void crearCliente (Cliente cliente){
        try {
            clienteJPA.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearRepartidor (repartidor repart){
        try {
            repartJPA.create(repart);
        } catch (Exception ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearBodeguero (bodegero bode){
        try {
            bodegeroJPA.create(bode);
        } catch (Exception ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
