package org.example.COMMON;


public class TipoProductoException extends Exception {
    public TipoProductoException(){
        super("EL tipo de producto no es valido");
    }

    public TipoProductoException(String tipoProducto){
        super("EL tipo " + tipoProducto + " no es valido");
    }
}
