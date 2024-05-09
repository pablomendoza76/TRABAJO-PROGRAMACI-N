/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa_paquetes;

import Clases.Cliente;
import Clases.bodegero;
import Clases.repartidor;
import java.util.Date;
import java.util.Scanner;
import persistencia.controlador;

/**
 *
 * @author Usuario iTC
 */
public class Jpa_paquetes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        controlador control = new controlador();
        /*Cliente client = new Cliente("091822", "1105662157", "Pablo", "Mendoza", "pablo@gmail.com");
        control.crearCliente(client);
        repartidor repart = new repartidor(1, "LOJA", "1105662157", "Pablo", "Mendoza", "pablo@gmail.com");
        control.crearRepartidor(repart);
         bodegero bode = new bodegero("local3", "LOJA", "1105662157", "Pablo", "Mendoza", "pablo@gmail.com");
         control.crearBodeguero(bode);*/
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. crearcliente");
            System.out.println("2. Sumar dos números");
            System.out.println("3. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    control.crearCliente(generarInfo());
                    break;
                case 2:
                    ;
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }
   public static Cliente generarInfo() {
        Scanner sc = new Scanner(System.in);
        String aux;
        Cliente client = new Cliente();

        System.out.println("Ingrese DNI:");
        aux = sc.nextLine();
        client.setDni(aux);

        System.out.println("Ingrese nombre:");
        aux = sc.nextLine();
        client.setNombre(aux);

        System.out.println("Ingrese apellido:");
        aux = sc.nextLine();
        client.setApellido(aux);
        System.out.println("Ingrese gamil:");
        aux = sc.nextLine();
        client.setCelular(aux); 
        System.out.println("Ingrese nuemro:");
        aux = sc.nextLine();
        client.setGamil(aux);
        return client;
    }  
}
