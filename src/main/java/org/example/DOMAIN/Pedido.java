package org.example.DOMAIN;

import java.time.LocalDate;

public class Pedido implements Comparable<Pedido>{
    private int id;
    private String nombreCliente;
    private double precioTotal;
    private LocalDate fecha;

    public Pedido(){

    }
    public Pedido( String nombreCliente, double precioTotal, int id) {
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.id = id;
        fecha = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return id + " " + nombreCliente + " " +  precioTotal + " " + fecha;
    }

    @Override
    public int compareTo(Pedido p) {
        return ((Integer)id).compareTo(p.getId());
    }

}
