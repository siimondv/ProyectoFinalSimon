package org.example.SERVICE;

import org.example.DAO.DaoMenusImplementacion;
import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Producto;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UtilizacionMenusCliente {

    private DaoMenusImplementacion daoMenusImplementacion;
    public UtilizacionMenusCliente() throws IOException {
        daoMenusImplementacion = new DaoMenusImplementacion();
    }
    public void createMenu(String nombreMenu, List<Producto> menu, String tipo, int desucuento) throws IllegalArgumentException{
        daoMenusImplementacion.createMenu(nombreMenu,menu,tipo,desucuento);
    }

    public void addProductoMenu(String nombreMenu, String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws IllegalArgumentException{
        daoMenusImplementacion.addProductoMenu(nombreMenu,nombre,precio,calorias,tamano,tipo,ingredientes);
    }

    public void editDescuentoMenu(String nombreMenu, int descuento) throws IllegalArgumentException{
        daoMenusImplementacion.editDescuentoMenu(nombreMenu,descuento);
    }

    public void changeProductoMenu(String nombreMenu1, String nombreMenu2, String nombreProducto) throws IllegalArgumentException{
        daoMenusImplementacion.changeProductoMenu(nombreMenu1,nombreMenu2,nombreProducto);
    }

    public void changeNombreMenu(String nombreMenu, String nombreMenuNuevo) throws IllegalArgumentException{
        daoMenusImplementacion.changeNombreMenu(nombreMenu,nombreMenuNuevo);
    }

    public void deleteProductoMenu(String nombreMenu, String nombre) throws IllegalArgumentException{
        daoMenusImplementacion.deleteProductoMenu(nombreMenu,nombre);
    }

    public void deleteMenu(String nombreMenu, String nombre) throws IllegalArgumentException{
        daoMenusImplementacion.deleteMenu(nombreMenu,nombre);
    }

    public String getContenidoMenu(String nombreMenu) throws IllegalArgumentException{
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

    public List<String> getMenusContieneIngrediente(String ingrediente) {
        return daoMenusImplementacion.getMenusContieneIngrediente(ingrediente);
    }

    public List<String> getMenusDesayuno() {
        return daoMenusImplementacion.getMenusDesayuno();
    }

    public List<String> getMenuComida() {
        return daoMenusImplementacion.getMenusComida();
    }
}
