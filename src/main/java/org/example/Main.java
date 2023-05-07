package org.example;

import org.example.COMMON.*;
import org.example.DAO.Ficheros;
import org.example.DAO.Menus;
import org.example.UI.FuncionesAplicacion;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        FuncionesAplicacion fn = null;
        try {
            fn = new FuncionesAplicacion();
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_FICHERO);
        }
        do {
            try {
                System.out.println(Constantes.MENU_MAIN);
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        if (fn.inicioSesion())
                            fn.menuAplicacionUsuario();
                        break;
                    }
                    case 2: {
                        if (fn.inicioSesionAdmin())
                            fn.menuAplicacionAdmin();
                        break;
                    }
                    case 3: {
                        if (fn.inicioSesionAdmin())
                            fn.pedidosAplicacionAdmin();
                        break;
                    }
                    case 4: {
                        System.out.println(Constantes.DESPEDIDA);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(Constantes.ERROR_FICHERO);
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(Constantes.ERROR_INPUT);
            }
        }
        while (opcion != 4);
    }
}