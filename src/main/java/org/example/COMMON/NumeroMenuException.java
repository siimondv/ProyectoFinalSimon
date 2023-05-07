package org.example.COMMON;

public class NumeroMenuException extends Exception{

    public NumeroMenuException(){
        super("El tamano del menu no puede superar 4 productos");
    }
}
