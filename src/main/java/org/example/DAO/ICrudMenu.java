package org.example.DAO;

import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Producto;

import java.util.List;

public interface ICrudMenu {
    //crea un nuevo menu
    public void createMenu(String nombreMenu, List<Producto> menu, String tipo, int desucuento);
    //añade un producto al menu
    public void addProductoMenu(String nombreMenu,String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes);
    //modifica el precio de un menu
    public void editDescuentoMenu(String nombreMenu, int descuento);
    //cambia un producto de un menu a otro
    void changeProductoMenu(String nombreMenu1, String nombreMenu2, String nombreProducto);
    //modifica el nombre de un menu
    public void changeNombreMenu(String nombreMenu,String nombre);
    //elimina un producto del menu
    public void deleteProductoMenu(String nombreMenu,String nombre);
    //elimina un menu y sus productos
    public void deleteMenu(String nombreMenu,String nombre);
    //lista un menu en especifico
    String getContenidoMenu(String nombreMenu);
    List<String> getMenus();
    List<String> getMenusPrecioSort();
    List<String> getMenusCaloriasSort();
    String getMenusContieneIngrediente(String ingrediente);
    List<String>getMenusDesayuno();
    List<String> getMenusComida();
}
