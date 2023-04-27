package org.example.DOMAIN;

import java.io.Serializable;
import java.util.List;

public class Producto implements Serializable {
    private String foodName;
    private double price;
    private int calories;
    private int plateSize;
    private String type;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPlateSize() {
        return plateSize;
    }

    public void setPlateSize(int plateSize) {
        this.plateSize = plateSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String firstName(){
        return foodName.split(" ")[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(foodName).append(", ")
                .append(calories).append(" kcal, size: ")
                .append(plateSize);
        return sb.toString();
    }
}
