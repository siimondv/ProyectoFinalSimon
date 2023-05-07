package org.example.DAO;

import org.example.COMMON.NumeroMenuException;
import org.example.COMMON.MenuNoEcontradoException;
import org.example.COMMON.TipoMenuException;
import org.example.COMMON.TipoProductoException;

import java.util.List;

public interface ICrudMenu {
    public boolean addProductoMenu(String nombreMenu,String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws MenuNoEcontradoException, TipoProductoException, TipoMenuException, NumeroMenuException;
    public boolean editDescuentoMenu(String nombreMenu, int descuento) throws MenuNoEcontradoException;
    public boolean changeNombreMenu(String nombreMenu,String nombre)throws MenuNoEcontradoException;
    public String getContenidoMenu(String nombreMenu)throws MenuNoEcontradoException;
    public String getMenus();
    public String getMenusPrecioSort(boolean ascendente);
    public String getMenusCaloriasSort(boolean ascendente);
    public String getMenusContieneIngrediente(String ingrediente);
    public String getMenusExcluyeIngrediente(String ingrediente);
    public String getMenusDesayuno();
    public String getMenusComida();
    public boolean deleteProductoMenu(String nombreMenu,String nombre) throws MenuNoEcontradoException, NumeroMenuException;
    public boolean addMenuBolsa(String nombreMenu, IAdministracion administracion) throws MenuNoEcontradoException;
    public boolean elimninarMenuBolsa(String nombreMenu, IAdministracion administracion) throws MenuNoEcontradoException;

}
