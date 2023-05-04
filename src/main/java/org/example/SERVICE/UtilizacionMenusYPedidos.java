package org.example.SERVICE;

import org.example.COMMON.InsuficientesMenuException;
import org.example.COMMON.MenuNoEcontradoException;
import org.example.COMMON.TipoMenuException;
import org.example.COMMON.TipoProductoException;
import org.example.DAO.DaoAdministracionImplementacion;
import org.example.DAO.DaoMenusImplementacion;

import java.io.IOException;
import java.util.List;

public class UtilizacionMenus {

    private DaoMenusImplementacion daoMenusImplementacion;
    private DaoAdministracionImplementacion daoAdministracionImplementacion;
    public UtilizacionMenus() throws IOException {
        daoMenusImplementacion = new DaoMenusImplementacion();
        daoAdministracionImplementacion = new DaoAdministracionImplementacion();
    }

    public void addProductoMenu(String nombreMenu, String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws MenuNoEcontradoException, TipoProductoException, TipoMenuException, InsuficientesMenuException {
        daoMenusImplementacion.addProductoMenu(nombreMenu,nombre,precio,calorias,tamano,tipo,ingredientes);
    }

    public void editDescuentoMenu(String nombreMenu, int descuento) throws MenuNoEcontradoException{
        daoMenusImplementacion.editDescuentoMenu(nombreMenu,descuento);
    }

    public void changeNombreMenu(String nombreMenu, String nombreMenuNuevo) throws MenuNoEcontradoException{
        daoMenusImplementacion.changeNombreMenu(nombreMenu,nombreMenuNuevo);
    }

    public void deleteProductoMenu(String nombreMenu, String nombre) throws MenuNoEcontradoException{
        daoMenusImplementacion.deleteProductoMenu(nombreMenu,nombre);
    }


    public String getContenidoMenu(String nombreMenu) throws MenuNoEcontradoException{
       return daoMenusImplementacion.getContenidoMenu(nombreMenu);
    }

    public List<String> getMenus() {
        return daoMenusImplementacion.getMenus();
    }

    public List<String> getMenusPrecioSort() {
        return daoMenusImplementacion.getMenusPrecioSort();
    }

    public List<String> getMenusCaloriasSort() {
        return daoMenusImplementacion.getMenusCaloriasSort();
    }

    public String getMenusContieneIngrediente(String ingrediente) {
        return daoMenusImplementacion.getMenusContieneIngrediente(ingrediente);
    }

    public String getMenusExcluyeIngrediente(String ingrediente) {
        return daoMenusImplementacion.getMenusExcluyeIngrediente(ingrediente);
    }

    public List<String> getMenusDesayuno() {
        return daoMenusImplementacion.getMenusDesayuno();
    }

    public List<String> getMenuComida() {
        return daoMenusImplementacion.getMenusComida();
    }

    public void asignarCliente(String nombre, String contra, int edad){
        daoAdministracionImplementacion.asignarCLiente(nombre,contra,edad);
    }
    public void addMenuBolsa(String nombreMenu){
        daoMenusImplementacion.addMenuBolsa(nombreMenu,daoAdministracionImplementacion);
    }

    public void eliminarMenuBolsa(String nombreMenu) {
        daoMenusImplementacion.elimninarMenuBolsa(nombreMenu, daoAdministracionImplementacion);
    }
    public String listarBolsa(){
        return daoAdministracionImplementacion.getListaBolsa();
    }

    public void guardarEstadoCliente() throws IOException {
        daoAdministracionImplementacion.guardarEstadoCliente();
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
}
