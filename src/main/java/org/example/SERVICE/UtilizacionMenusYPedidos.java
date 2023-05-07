package org.example.SERVICE;

import org.example.COMMON.NumeroMenuException;
import org.example.COMMON.MenuNoEcontradoException;
import org.example.COMMON.TipoMenuException;
import org.example.COMMON.TipoProductoException;
import org.example.DAO.DaoAdministracionImplementacion;
import org.example.DAO.DaoMenusImplementacion;

import java.io.IOException;
import java.util.List;

public class UtilizacionMenusYPedidos {

    private DaoMenusImplementacion daoMenusImplementacion;
    private DaoAdministracionImplementacion daoAdministracionImplementacion;

    public UtilizacionMenusYPedidos() throws IOException {
        daoMenusImplementacion = new DaoMenusImplementacion();
        daoAdministracionImplementacion = new DaoAdministracionImplementacion();
    }

    public boolean addProductoMenu(String nombreMenu, String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws MenuNoEcontradoException, TipoProductoException, TipoMenuException, NumeroMenuException {
        return daoMenusImplementacion.addProductoMenu(nombreMenu, nombre, precio, calorias, tamano, tipo, ingredientes);
    }

    public boolean editDescuentoMenu(String nombreMenu, int descuento) throws MenuNoEcontradoException {
        return daoMenusImplementacion.editDescuentoMenu(nombreMenu, descuento);
    }

    public boolean changeNombreMenu(String nombreMenu, String nombreMenuNuevo) throws MenuNoEcontradoException {
        return daoMenusImplementacion.changeNombreMenu(nombreMenu, nombreMenuNuevo);
    }

    public boolean deleteProductoMenu(String nombreMenu, String nombre) throws MenuNoEcontradoException, NumeroMenuException {
        return daoMenusImplementacion.deleteProductoMenu(nombreMenu, nombre);
    }


    public String getContenidoMenu(String nombreMenu) throws MenuNoEcontradoException {
        return daoMenusImplementacion.getContenidoMenu(nombreMenu);
    }

    public String getMenus() {
        return daoMenusImplementacion.getMenus();
    }

    public String getMenusPrecioSort(boolean ascendente) {
        return daoMenusImplementacion.getMenusPrecioSort(ascendente);
    }

    public String getMenusCaloriasSort(boolean ascendente) {
        return daoMenusImplementacion.getMenusCaloriasSort(ascendente);
    }

    public String getMenusContieneIngrediente(String ingrediente) {
        return daoMenusImplementacion.getMenusContieneIngrediente(ingrediente);
    }

    public String getMenusExcluyeIngrediente(String ingrediente) {
        return daoMenusImplementacion.getMenusExcluyeIngrediente(ingrediente);
    }

    public String getMenusDesayuno() {
        return daoMenusImplementacion.getMenusDesayuno();
    }

    public String getMenuComida() {
        return daoMenusImplementacion.getMenusComida();
    }

    public void asignarCliente(String nombre, String contra, int edad) {
        daoAdministracionImplementacion.asignarCLiente(nombre, contra, edad);
    }

    public boolean addMenuBolsa(String nombreMenu) throws MenuNoEcontradoException {
        return daoMenusImplementacion.addMenuBolsa(nombreMenu, daoAdministracionImplementacion);
    }

    public boolean eliminarMenuBolsa(String nombreMenu) throws MenuNoEcontradoException {
        return daoMenusImplementacion.elimninarMenuBolsa(nombreMenu, daoAdministracionImplementacion);
    }

    public String listarBolsa() {
        return daoAdministracionImplementacion.getListaBolsa();
    }

    public boolean guardarEstadoCliente() throws IOException {
        return daoAdministracionImplementacion.guardarEstadoCliente();
    }

    public boolean recuperarEstadoCliente(String nombreCliente) throws IOException {
        return daoAdministracionImplementacion.recuperarEstadoCliente(nombreCliente);
    }

    public boolean revisarContrasena(String contrasena) {
        return daoAdministracionImplementacion.revisarContrasena(contrasena);
    }

    public boolean addPedido() throws IOException {
        return daoAdministracionImplementacion.addPedido();
    }

    public String listarPedidos() {
        return daoAdministracionImplementacion.listarPedidos();
    }

    public String listarPedidosMaxPrecio(int precio) {
        return daoAdministracionImplementacion.listarPedidosMaxPrecio(precio);
    }

    public String listarPedidosPorNombre(String nommbre) {
        return daoAdministracionImplementacion.listarPedidosPorNombre(nommbre);
    }

    public boolean modifyPedidoPrecio(int id, double total) {
        return daoAdministracionImplementacion.modifyPrecioPedido(id, total);
    }

    public boolean modifyNombrePedido(int id, String nombre) {
        return daoAdministracionImplementacion.modifyNombrePedido(id, nombre);
    }

    public boolean deletePedido(int id) {
        return daoAdministracionImplementacion.deletePedido(id);
    }

    public boolean deleteAllPedidos() {
        return daoAdministracionImplementacion.deleteAllPedidos();
    }
}
