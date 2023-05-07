package org.example.DAO;

import org.example.COMMON.Constantes;
import org.example.DOMAIN.Cliente;
import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Pedido;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DaoAdministracionImplementacion implements IAdministracion {
    private Pedidos pedidos;

    public DaoAdministracionImplementacion() throws IOException {
        pedidos = new Pedidos(new ArrayList<>());
    }

    @Override
    public void asignarCLiente(String nombre, String contra, int edad) {
        pedidos.setCliente(new Cliente(nombre, contra, edad));
    }

    @Override
    public void addMenuBolsa(Menu menu) {
        pedidos.getCliente().addMenuBolsa(menu);
    }

    @Override
    public String getListaBolsa() {
        if (pedidos.getCliente().getBolsa().isEmpty()) {
            return Constantes.BOLSA_VACIA;
        }
        return pedidos.getCliente().getBolsa().stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
    }

    @Override
    public void eliminarMenuBolsa(Menu menu) {
        pedidos.getCliente().eliminarMenuBolsa(menu);
    }

    @Override
    public boolean addPedido() {
        TreeSet<Pedido> lista = pedidos.getPedidos();
        if (pedidos.getCliente().getNombre().isEmpty()) {
            return false;
        } else {
            int id;
            if (lista.isEmpty()) {
                id = 0;
            } else {
                id = lista.last().getId() + 1;
            }
            Pedido pe = new Pedido(pedidos.getCliente().getNombre(), pedidos.getCliente().getTotalBolsa(), id);
            lista.add(pe);
            pedidos.setPedidos(lista);
            pedidos.getCliente().setBolsa(new ArrayList<>());
            return true;
        }
    }

    @Override
    public String listarPedidos() {
        if (!pedidos.getPedidos().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Pedido s : pedidos.getPedidos()) {
                sb.append(s).append("\n");
            }
            return sb.toString();

        } else {
            return Constantes.NINGUN_PEDIDO;
        }
    }

    @Override
    public String listarPedidosMaxPrecio(int precio) {
        if (!pedidos.getPedidos().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Pedido s : pedidos.getPedidos().stream().filter(pedido -> pedido.getPrecioTotal() < precio).collect(Collectors.toList())) {
                sb.append(s).append("\n");
            }
            return sb.toString();

        } else {
            return Constantes.NINGUN_PEDIDO;
        }
    }

    @Override
    public String listarPedidosPorNombre(String nombre) {
        if (!pedidos.getPedidos().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Pedido s : pedidos.getPedidos().stream().filter(pedido -> pedido.getNombreCliente().equals(nombre)).collect(Collectors.toList())) {
                sb.append(s).append("\n");
            }
            return sb.toString();

        } else {
            return Constantes.NINGUN_PEDIDO;
        }
    }

    @Override
    public boolean modifyPrecioPedido(int id, double total) {
        boolean entro = false;
        for (Pedido p : pedidos.getPedidos()) {
            if (p.getId() == id) {
                p.setPrecioTotal(total);
                entro = true;
            }
        }
        if (entro)
            return true;
        else return false;
    }

    @Override
    public boolean modifyNombrePedido(int id, String nombre) {
        boolean entro = false;
        for (Pedido p : pedidos.getPedidos()) {
            if (p.getId() == id) {
                p.setNombreCliente(nombre);
                entro = true;
            }
        }
        if (entro)
            return true;
        else return false;
    }

    @Override
    public boolean deletePedido(int id) {
        boolean entro = false;
        TreeSet<Pedido> lista = pedidos.getPedidos();
        Iterator<Pedido> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Pedido p = iterator.next();
            if (p.getId() == id) {
                entro = true;
                iterator.remove();
            }
        }
        pedidos.setPedidos(lista);
        if (entro) return true;
        else return false;
    }

    @Override
    public boolean deleteAllPedidos() {
        pedidos.setPedidos(new TreeSet<>());
        return true;
    }

    @Override
    public boolean guardarEstadoCliente() throws IOException {
        return Ficheros.guardarFicheroBinario("src/main/resources/clientes/" + pedidos.getCliente().getNombre() + ".user", pedidos.getCliente());
    }

    @Override
    public boolean recuperarEstadoCliente(String nombreCliente) throws IOException {
        File fichero = new File("src/main/resources/clientes/" + nombreCliente + ".user");
        if (!fichero.exists()) {
            return false;

        } else {
            pedidos.setCliente(Ficheros.recuperarFicheroBinario(fichero));
            return true;
        }
    }

    @Override
    public boolean revisarContrasena(String contrasena) {
        if (pedidos.getCliente().getContra().equals(contrasena))
            return true;
        else return false;
    }
}
