package org.example.DOMAIN;

import java.util.List;

public class Menu {
    private List<Producto> menu;
    private String tipo;
    private int desucuento;

    public Menu(List<Producto> menu, String tipo, int desucuento) {
        this.menu = menu;
        this.tipo = tipo;
        this.desucuento = desucuento;
    }
}
