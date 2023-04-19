package org.example.DAO;

import java.util.List;

public interface ICrudMenu {
    //crea un nuevo menu
    public void createMenu(String nombreMenu);
    //añade un producto al menu
    public void addProductoMenu(String nombreMenu,String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes);
    //modifica el nombre de un producto en el menu
    public void editNombreProductoMenu(String nombreMenu,String nombre, String nombreNuevo);
    //modifica el precio de un menu
    public void editDescuentoMenu(String nombreMenu,String nombre, int precio);

    //cambia un producto de un menu a otro
    public void changeProductoMenu(String nombreMenu,String nombre);
    //modifica el nombre de un menu
    public void changeNombreMenu(String nombreMenu,String nombre);
    //elimina un producto del menu
    public void deleteProductoMenu(String nombreMenu,String nombre);
    //elimina un menu y sus productos
    public void deleteMenu(String nombreMenu,String nombre);
    //lista un menu en especifico
    public void listarMenu(String nombreMenu);
    //lista todos los menus
    public void listarMenus();
    //lista todos los menus de desayuno
    public void listarMenusDesayuno();
    //lista todos los menus de comida
    public void listarMenuComida();

}
