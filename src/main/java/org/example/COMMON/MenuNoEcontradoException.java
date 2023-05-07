package org.example.COMMON;

public class MenuNoEcontradoException extends Exception{
    public MenuNoEcontradoException(){
        super("EL menu no ha sido encontrado");
    }
    public MenuNoEcontradoException(String nombreMenu){
        super("EL menu " + nombreMenu + " no ha sido encontrado");
    }
}
