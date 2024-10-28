package com.angelpuentesdevv.creditcard.principal;

import com.angelpuentesdevv.creditcard.modelos.Compra;
import com.angelpuentesdevv.creditcard.modelos.TarjetaDeCredito;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Indica el límite de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while (salir != 0) {
            System.out.println("¿Qué deseas comprar?: ");
            String descripcion = lectura.next();

            System.out.println("¿Cuánto vale?: ");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra terminada con éxito!");
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                salir = 0;
            }
        }
        System.out.println("<------------------------>");
        System.out.println("Compras realizadas:\n");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
        }
        System.out.println("<------------------------->");
        System.out.println("\nSaldo disponible: " + tarjeta.getSaldo());
    }
}