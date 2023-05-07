package org.example.COMMON;

import java.io.IOException;
import java.util.Scanner;

public class Constantes {
    public static final String NO_MENU_CARTA = "ningun menu en la carta";
    public static final String NO_MENU_INGREDIENTE ="ninguno menu con ese ingrediente";
    public static final String NO_MENU_DESAYUNO = "ningun menu de desayuno";
    public static final String NO_MENU_COMIDA = "ningun menu de desayuno";
    public static final String BOLSA_VACIA ="La bolsa esta vacía";
    public static final String NINGUN_PEDIDO = "No hay ningun pedido";
    public static final String  MENU_MAIN = "Elige entre las siguientes opciones:\n" +
            "1.Hacer nueva compra como cliente.\n2.Editar carta como administrador.\n3.Editar pedidos como administrador.\n4.Salir";
    public static final String INICIOSESIONADMIN = "Dime la contrasena para acceder modo admin";
    public static final String INICIOSESIONINTRO = "Dime tu nombre de usuario (Tiene que tener 2 numeros al final para que sea valido)";
    public static final String INICIOSESIONEDAD = "Dime tu edad";
    public static final String INICIOSESIONCONTRA = "Dime tu contrasena";
    public static final String INICIOSESIONBIENVENIDA = "Bienvenido de vuelta";
    public static final String INICIOSESIONINCORRECTO = "Incorrecta";
    public static final String MENU_CLIENTE = "Pulsa una de las siguientes opciones \n1: Listar Menus. \n2: Listar por precio.\n3: Listar por calorias.\n4: Listar menus de desayuno." +
            "\n5: Listar menus de comida.\n6: Listar contenido menu.\n7: Listar menu con ingrediente especifico." +
            "\n8: Listar menu sin ingrediente especifico.\n9: Anadir a la bolsa menu.\n10: Eliminar menu bolsa.\n11: Listar bolsa.\n12: Finalizar compra.\n13: Guardar estado.\n14: Salir.";
    public static final String MENU_ADMIN = "Pulsa una de las siguientes opciones \n1: Listar Menus.\n2: Listar  menus contenido.\n3: Anadir producto al menu." +
            "\n4: Cambiar descuento menu.\n5: Cambiar nombre menu.\n6: Eliminar producto del menu.\n7: Salir.";
    public static final String PEDIDOS_ADMIN = "Pulsa una de las siguientes opciones \n1: Listar Pedidos.\n2: Listar pedidos maximo precio.\n3: Listar pedidos por nombre cliente." +
            "\n4: Modificar precio del pedido.\n5: Modificar nombre del pedido.\n6: Eliminar pedido.\n7: Eliminar todos los pedidos.\n8: Salir.";
    public static final String ORDEN = "En orden ascendente (pulsando 1), en orden ascendente (pulsando otro numero)";

    public static final String MENU_NOMBRE = "Dime el nombre del menu del cual quieres ver el contenido";
    public static final String MENU_INGREDIENTE = "Dime el nombre del ingrediente (ej: lemons)";
    public static final String MENU_ANADIR = "Dime el menu que quieres anadir";
    public static final String MENU_ELIMINAR = "Dime el menu que quieres eliminar";
    public static final String MENU_CAMBIAR_DESCUENTO = "Dime el menu al que quieres cambiar el descuento";
    public static final String MENU_NUEVO_DESCUENTO = "Dime el nuevo descuento que quieres aplicar";
    public static final String MENU_CAMBIAR_NOMBRE = "Dime el menu al que quieres cambiar el nombre";
    public static final String MENU_NUEVO_NOMBRE = "Dime el nuevo nombre";
    public static final String MENU_ELIMINAR_PRODUCTO= "Dime el menu del que quieres eliminar un producto";
    public static final String MENU_PRODUCTO_A_ELIMINAR = "Dime el nombre del producto el cual quieres eliminar";
    public static final String PEDIDO_MAX_PRECIO = "Dime el precio maximo por el que quieres filtrar";
    public static final String PEDIDO_CLIENTE_FILTRAR = "Dime el nombre de el cliente por el que quieres filtrar";
    public static final String PEDIDO_ID = "Dime el id del pedido";
    public static final String PEDIDO_NUEVO_PRECIO = "Dime el nuevo precio";
    public static final String PEDIDO_NUEVO_NOMBRE = "Dime el nuevo nombre";
    public static final String MENU_NUEVO_PRODUCTO= "Dime el menu del que quieres anadir un producto";
    public static final String PRODUCTO_NOMBRE = "Dime el nombre del producto";
    public static final String PRODUCTO_PRECIO = "Dime el precio del producto";
    public static final String PRODUCTO_CALORIAS = "Dime las calorias del producto";
    public static final String PRODUCTO_TAMANO = "Dime el tamano del producto";
    public static final String PRODUCTO_TIPO = "Dime el tipo del producto (food,breakfast,drink)";
    public static final String PRODUCTO_NUMERO_INGREDIENTES= "Dime cuantos ingredientes va a tener el producto";
    public static final String PRODUCTO_INGREDIENTES= "Dime el ingrediente";
    public static final String LISTO = "Listo";
    public static final String FALLO= "No se pudo realizar la accion";
    public static final String DESPEDIDA= "Hasta luego";
    public static final String ERROR_MENUNOENCONTRADO= "El menu no se encontro";
    public static final String ERROR_INSUFICIENTEMENU= "Numero maximo o minimo superado de productos en el menu";
    public static final String ERROR_TIPOPRODUCTO= "El tipo de producto no es el adecuado";
    public static final String ERROR_TIPOMENU= "No encaja el tipo de producto con el tipo de menu";
    public static final String ERROR_COMUN= "Revisar que lo que has puesto este bien";
    public static final String ERROR_INPUT= "Input no adecuado";
    public static final String ERROR_FICHERO= "algo con los ficheros no salio bien";

}
