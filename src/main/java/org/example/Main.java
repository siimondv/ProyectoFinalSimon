package org.example;

import org.example.DAO.Ficheros;
import org.example.DAO.Menus;
import org.example.UI.FuncionesAplicacion;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FuncionesAplicacion fn = new FuncionesAplicacion();
            fn.menuAplicacionUsuario();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}