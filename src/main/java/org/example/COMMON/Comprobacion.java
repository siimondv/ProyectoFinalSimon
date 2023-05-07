package org.example.COMMON;

import org.example.DOMAIN.Menu;

public class Comprobacion {

    public static void TipoProductoOK(String tipoProducto) throws TipoProductoException {
        boolean esta = false;
        TipoProductos aux [] = TipoProductos.values();
        for(int i=0; i<aux.length ;i++){
            if (aux[i].toString().equalsIgnoreCase(tipoProducto))
                esta=true;
        }
        if (!esta)
            throw new TipoProductoException(tipoProducto);
    }

    public static void TipoMenuOK(String tipoMenu, String tipoProducto) throws  TipoMenuException {
        boolean valido = false;
        if (tipoMenu.equals(TipoMenus.comida.toString()) && (tipoProducto.equals(TipoProductos.food.toString()) || tipoProducto.equals(TipoProductos.drink.toString()))){
            valido = true;
        }
        if (tipoMenu.equals(TipoMenus.desayuno.toString()) && (tipoProducto.equals(TipoProductos.breakfast.toString()) || tipoProducto.equals(TipoProductos.drink.toString()))){
            valido = true;
        }
        if (!valido){
            throw new TipoMenuException(tipoMenu,tipoProducto);
        }
    }

    public static void numeroProductos(Menu menu) throws NumeroMenuException {
        if(menu.getMenu().size() >= 3){
            throw new NumeroMenuException();
        }
    }

}
