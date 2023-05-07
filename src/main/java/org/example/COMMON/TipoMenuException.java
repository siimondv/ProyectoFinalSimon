package org.example.COMMON;

import org.example.DOMAIN.Menu;

public class TipoMenuException extends Exception{

    public TipoMenuException(){
        super("EL tipo de producto no encaja con el tipo de menu");
    }

    public TipoMenuException(String tipoMenmu, String tipoProducto){
        super("EL tipo de producto no encaja con el Menu");
    }
}
