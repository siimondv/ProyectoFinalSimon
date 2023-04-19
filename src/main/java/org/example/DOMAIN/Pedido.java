package org.example.DOMAIN;

import java.util.Date;

public class Pedido {
    private Date hora;
    private String nombreCliente;
    private int precioTotal;

    public Pedido(Date hora, String nombreCliente, int precioTotal) {
        this.hora = hora;
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
    }
}
