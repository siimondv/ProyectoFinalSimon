package org.example.DAO;

import org.example.DOMAIN.Menu;

import java.io.IOException;
import java.util.List;

public interface ICrudAdministracion {
    public void asignarCLiente(String nombre, String contra, int edad);
    public void addMenuBolsa(Menu menu);
    public void eliminarMenuBolsa(Menu menu);
    public String getListaBolsa();
    public boolean addPedido() throws IOException;
    public void modifyPedido(int total);
    public void deletePedido(int id);
    public List<String> listarPedidosMaxPrecio(int precio);
    public void guardarEstadoCliente() throws IOException;
    public boolean recuperarEstadoCliente(String nombreCliente) throws IOException;
    public boolean revisarContrasena(String contrasena);
}
