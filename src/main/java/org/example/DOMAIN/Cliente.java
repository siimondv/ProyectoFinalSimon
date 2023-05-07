package org.example.DOMAIN;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Cliente implements Serializable {
    private String nombre;
    private String contra;
    private int edad;
    private List<Menu> bolsa;

    public Cliente(String nombre, String contra, int edad){
        String patron = "[a-zA-Z]+\\d{2}";
        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            this.nombre = nombre;
            this.contra = contra;
            this.edad = edad;
            this.bolsa = new ArrayList<>();
        } else {
            throw new PatternSyntaxException("no valid",patron, 0);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Menu> getBolsa() {
        return bolsa;
    }

    public void setBolsa(List<Menu> bolsa) {
        this.bolsa = bolsa;
    }

    public void addMenuBolsa(Menu menu){
        this.bolsa.add(menu);
    }
    public void eliminarMenuBolsa(Menu menu){
        Iterator<Menu> iterator = bolsa.iterator();
        while (iterator.hasNext()) {
            Menu mn = iterator.next();
            if (mn.getNombreMenu().equals(menu.getNombreMenu())) {
                iterator.remove();
            }
        }
    }
    public double getTotalBolsa(){
        double total = 0;
        for (Menu mn : this.bolsa){
            total = total + mn.sumPrecio();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Mi nombre es " + nombre + " y mi edad es " + edad;
    }
}
