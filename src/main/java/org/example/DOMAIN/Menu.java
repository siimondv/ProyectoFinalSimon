package org.example.DOMAIN;


import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable, Comparable<Menu>  {
    private List<Producto> menu;
    private String tipo;
    private int desucuento;
    private String nombreMenu;

    private Menu(){

    }
    public Menu(String nombreMenu, List<Producto> menu, String tipo, int desucuento) {
        this.nombreMenu = nombreMenu;
        this.menu = menu;
        this.tipo = tipo;
        this.desucuento = desucuento;
    }

    public Menu(List<Producto> menu, String tipo, int desucuento) {
        this.menu = menu;
        this.tipo = tipo;
        this.desucuento = desucuento;
    }

    public List<Producto> getMenu() {
        return menu;
    }

    public void setMenu(List<Producto> menu) {
        this.menu = menu;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDesucuento() {
        return desucuento;
    }

    public void setDesucuento(int desucuento) {
        this.desucuento = desucuento;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }
    public void addProductoMenu(Producto pr){
        menu.add(pr);
    }
    public Producto removeRetrieveProductoMenu(String pr) throws IllegalArgumentException{
        for (Producto pro: menu) {
            if (pro.getFoodName().equals(pr)){
                menu.remove(pro);
                return pro;
            }
        }
            throw new IllegalArgumentException();
    }
    public int sumCalorias(){
        int suma = 0;
        for (Producto pr: menu) {
            suma += pr.getCalories();
        }
        return suma;
    }

    public double sumPrecio(){
        double precio = 0;
        for (Producto pr: menu) {
            if (desucuento != 0){
                precio = precio + (pr.getPrice() - (pr.getPrice()  * (desucuento / 100)));
            }
            else {
                precio = precio + pr.getPrice();
            }

        }
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu.get(0).firstName())
                .append(menu.get(1).firstName())
                .append(" ")
                .append(sumPrecio())
                .append("$ ")
                .append(sumCalorias())
                .append(" kcal");
        return sb.toString();
    }

    @Override
    public int compareTo(Menu o) {
        return nombreMenu.compareTo(o.nombreMenu);
    }
}
