package org.example;

import org.example.SERVICE.InicioAplicacion;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            InicioAplicacion.cargarJson();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}