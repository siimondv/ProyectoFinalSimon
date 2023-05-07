package org.example.DAO;

import org.example.DOMAIN.Menu;

import java.io.IOException;

public interface IAdministracion {
    public void asignarCLiente(String nombre, String contra, int edad);
    public void addMenuBolsa(Menu menu);
    public String getListaBolsa();
    public void eliminarMenuBolsa(Menu menu);
    public boolean addPedido() throws IOException;
    public String listarPedidos();
    public String listarPedidosMaxPrecio(int precio);
    public String listarPedidosPorNombre(String nombre);
    public boolean modifyPrecioPedido(int id,double total);
    public boolean modifyNombrePedido(int id,String nombre);
    public boolean deletePedido(int id);
    public boolean deleteAllPedidos();
    public boolean guardarEstadoCliente() throws IOException;
    public boolean recuperarEstadoCliente(String nombreCliente) throws IOException;
    public boolean revisarContrasena(String contrasena);
}
