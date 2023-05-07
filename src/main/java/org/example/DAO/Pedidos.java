package org.example.DAO;

import org.example.DOMAIN.Cliente;
import org.example.DOMAIN.Pedido;

import java.util.*;

public class Pedidos {
    private TreeSet<Pedido> pedidos;
    private Cliente cliente;
    public Pedidos(List<Pedido> pedidos){
        this.pedidos = new TreeSet<>(pedidos);
    }

    public TreeSet<Pedido> getPedidos() {
        return new TreeSet<>(pedidos);
    }

    public void setPedidos(TreeSet<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
