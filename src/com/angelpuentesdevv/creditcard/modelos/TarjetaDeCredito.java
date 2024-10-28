package com.angelpuentesdevv.creditcard.modelos;

import java.util.ArrayList;

public class TarjetaDeCredito {

    private double limite;

    private double saldo;

    private ArrayList<String> listaDeCompras = new ArrayList<>();

    public TarjetaDeCredito(double limite, double saldo) {
        this.limite = limite;
        this.saldo = saldo;
    }


}
