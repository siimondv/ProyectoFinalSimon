package org.example.DAO;

import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Producto;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DaoMenusImplementacion  implements ICrudMenu{
    private final Menus menus;
    public DaoMenusImplementacion() throws IOException {
        File fichero = new File("src/main/resources/menuUsuario.json");
        if (!fichero.exists()){
            System.out.println("Entro squi");
            Ficheros.escribirFicheroMenu(Ficheros.cargarJson());
            this.menus = new Menus(Ficheros.cargarFicheroMenu());
        }
        else{
            this.menus = new Menus(Ficheros.cargarFicheroMenu());
        }
    }
    @Override
    public void createMenu(String nombreMenu, List<Producto> menu, String tipo, int desucuento) throws IllegalArgumentException{
        //revisar error maximo 3 productos
        if (menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu ya existe");
        }
        else{
            menus.getMenusMap().put(nombreMenu, new Menu(nombreMenu,menu,tipo,desucuento));
        }
    }

    @Override
    public void addProductoMenu(String nombreMenu, String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws IllegalArgumentException{
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else{
            menus.getMenusMap().get(nombreMenu).addProductoMenu(new Producto(nombre,precio,calorias,tamano,tipo,ingredientes));
        }
    }

    @Override
    public void editDescuentoMenu(String nombreMenu, int descuento) throws IllegalArgumentException{
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else{
            menus.getMenusMap().get(nombreMenu).setDesucuento(descuento);
        }
    }

    @Override
    public void changeProductoMenu(String nombreMenu1, String nombreMenu2, String nombreProducto) throws IllegalArgumentException{
        //revisar minimo 2 productos, revisar minimo una comida o desayuno y revisar que menu de translado sea de mismo tipo
        if (!menus.getMenusMap().containsKey(nombreMenu1)){
            throw new IllegalArgumentException("El menu inicial no existe");
        }
        else if (!menus.getMenusMap().containsKey(nombreMenu2)){
            throw new IllegalArgumentException("El menu de destino no existe");
        }
        else{
            menus.getMenusMap().get(nombreMenu2).addProductoMenu(menus.getMenusMap().get(nombreMenu1).removeRetrieveProductoMenu(nombreProducto));
        }
    }

    @Override
    public void changeNombreMenu(String nombreMenu, String nombreMenuNuevo) throws IllegalArgumentException{
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else{
            menus.getMenusMap().put(nombreMenuNuevo,menus.getMenusMap().get(nombreMenu));
            menus.getMenusMap().remove(nombreMenu);
        }

    }

    @Override
    public void deleteProductoMenu(String nombreMenu, String nombre) throws IllegalArgumentException{
        //revisar minimo 2 productos, revisar minimo una comida o desayuno
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else{
            menus.getMenusMap().get(nombreMenu).removeRetrieveProductoMenu(nombre);
        }
    }

    @Override
    public void deleteMenu(String nombreMenu, String nombre) throws IllegalArgumentException{
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else{
            menus.getMenusMap().remove(nombreMenu);
        }
    }

    @Override
    public String getContenidoMenu(String nombreMenu) throws IllegalArgumentException{
        //comprobar que existe menu
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new IllegalArgumentException("Este menu no existe");
        }
        else {
            return menus.getMenusMap().get(nombreMenu).getMenu().toString();
        }
    }

    @Override
    public List<String> getMenus() {
        //List<Producto> listaa = lista.stream().map(menu -> menu.getMenu()).flatMap(List::stream).collect(Collectors.toList());
        return menus.getMenusMap().values().stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
    }

    @Override
    public List<String> getMenusPrecioSort() {
        Comparator<Menu> precioComparator = (m1, m2) -> (int) (m1.sumPrecio() - m2.sumPrecio());
        List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
        Collections.sort(tm, precioComparator);
        return tm.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
    }

    @Override
    public List<String> getMenusCaloriasSort() {
        Comparator<Menu> precioComparator = (m1, m2) -> (int) (m1.sumCalorias() - m2.sumCalorias());
        List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
        Collections.sort(tm, precioComparator);
        return tm.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
    }

    @Override
    public String getMenusContieneIngrediente(String ingrediente) {
        List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
        List<Menu> menuIngre = new ArrayList<>();
        for (Menu mn : tm){
            for (Producto pr : mn.getMenu()){
                if (pr.getIngredients().contains(ingrediente)){
                    menuIngre.add(mn);
                }
            }
        }
        tm.stream().forEach(menu -> menu.getMenu().forEach(producto -> producto.getIngredients().forEach(s -> s.equals(ingrediente))));
        //return menus.getMenusMap().values().stream().filter(menu -> menu.getMenu().stream().map(producto -> producto.getIngredients()).collect(Collectors.toList()).contains(ingrediente)).map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
        if (menuIngre.isEmpty()){
            return "ninguno menu con ese ingrediente";
        }
        else {
            return menuIngre.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
        }

    }

    @Override
    public List<String> getMenusDesayuno() {
        return menus.getMenusMap().values().stream().filter(menu -> menu.getTipo().equals("desayuno")).map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
    }

    @Override
    public List<String> getMenusComida() {
        return menus.getMenusMap().values().stream().filter(menu -> menu.getTipo().equals("comida")).map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
    }

}
