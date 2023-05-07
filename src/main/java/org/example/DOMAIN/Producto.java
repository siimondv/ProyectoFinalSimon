package org.example.DOMAIN;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class Producto implements Serializable {
    @Getter
    @Setter
    private String foodName;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private int calories;
    @Getter
    @Setter
    private int plateSize;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private List<String> ingredients;

    private Producto() {

    }
    public Producto(String nombre, double precio, int calorias, int tamaño, String tipo, List<String> ingredientes) {
        this.foodName = nombre;
        this.price = precio;
        this.calories = calorias;
        this.plateSize = tamaño;
        this.type = tipo;
        this.ingredients = ingredientes;
    }

    public String firstName(){
        return foodName.split(" ")[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(foodName).append(", ")
                .append(price).append("$,")
                .append(calories).append(" kcal, size: ")
                .append(plateSize);
        return sb.toString();
    }
}
