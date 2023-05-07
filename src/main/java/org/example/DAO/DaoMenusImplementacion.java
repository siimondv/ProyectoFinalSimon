package org.example.DAO;

import org.example.COMMON.*;
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
            Ficheros.escribirFicheroMenu(Ficheros.cargarJson());
            this.menus = new Menus(Ficheros.cargarFicheroMenu());
        }
        else{
            this.menus = new Menus(Ficheros.cargarFicheroMenu());
        }
    }

    @Override
    public boolean addProductoMenu(String nombreMenu, String nombre, int precio, int calorias, int tamano, String tipo, List<String> ingredientes) throws MenuNoEcontradoException, TipoProductoException, TipoMenuException, NumeroMenuException {
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException(nombreMenu);
        }
        else{
            Comprobacion.TipoProductoOK(tipo);
            Comprobacion.TipoMenuOK(menus.getMenusMap().get(nombreMenu).getTipo(), tipo);
            Comprobacion.numeroProductos(menus.getMenusMap().get(nombreMenu));
            menus.getMenusMap().get(nombreMenu).addProductoMenu(new Producto(nombre,precio,calorias,tamano,tipo,ingredientes));
            entro = true;
        }
        return entro;
    }

    @Override
    public boolean editDescuentoMenu(String nombreMenu, int descuento) throws MenuNoEcontradoException {
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException(nombreMenu);
        }
        else{
            entro = true;
            menus.getMenusMap().get(nombreMenu).setDesucuento(descuento);
        }
        return entro;
    }

    @Override
    public boolean changeNombreMenu(String nombreMenu, String nombreMenuNuevo) throws MenuNoEcontradoException{
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException(nombreMenu);
        }
        else{
            menus.getMenusMap().get(nombreMenu).setNombreMenu(nombreMenuNuevo);
            TreeMap<String, Menu> menuss = menus.getMenusMap();
            menuss.put(nombreMenuNuevo,menus.getMenusMap().get(nombreMenu));
            menuss.remove(nombreMenu);
            menus.setMenusMap(menuss);
            entro = true;
        }
        return entro;
    }

    @Override
    public String getContenidoMenu(String nombreMenu) throws MenuNoEcontradoException{
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException(nombreMenu);
        }
        else {
            return menus.getMenusMap().get(nombreMenu).getMenu().toString();
        }
    }

    @Override
    public String getMenus() {
        if(menus.getMenusMap().values().isEmpty()){
            return  Constantes.NO_MENU_CARTA;
        }
        else return menus.getMenusMap().values().stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
    }

    @Override
    public String getMenusPrecioSort(boolean descendente) {
        if(menus.getMenusMap().values().isEmpty()){
            return  Constantes.NO_MENU_CARTA;
        }
        else {Comparator<Menu> precioComparator;

            if (descendente){
                precioComparator = (m1, m2) ->{
                    int aux = Double.compare(m1.sumPrecio(),m2.sumPrecio());
                    if(aux==0){
                        aux=m1.getNombreMenu().compareTo(m2.getNombreMenu());
                    }
                    return aux;
                };
            }
            else {
                precioComparator = (m1, m2) ->{
                    int aux = Double.compare(m2.sumPrecio(),m1.sumPrecio());
                    if(aux==0){
                        aux=m1.getNombreMenu().compareTo(m2.getNombreMenu());
                    }
                    return aux;
                };
            }

            List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
            Collections.sort(tm, precioComparator);
            return tm.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
        }
    }

    @Override
    public String getMenusCaloriasSort(boolean ascendente) {
        if(menus.getMenusMap().values().isEmpty()){
            return  Constantes.NO_MENU_CARTA;
        }
        else {
            Comparator<Menu> caloriasComparator;
            if (ascendente){
                 caloriasComparator = (m1, m2) ->{
                    int aux = Integer.compare(m1.sumCalorias(),m2.sumCalorias());
                    if(aux==0){
                        aux=m1.getNombreMenu().compareTo(m2.getNombreMenu());
                    }
                    return aux;
                };
            }
            else {
                caloriasComparator = (m1, m2) ->{
                    int aux = Integer.compare(m2.sumCalorias(),m1.sumCalorias());
                    if(aux==0){
                        aux=m1.getNombreMenu().compareTo(m2.getNombreMenu());
                    }
                    return aux;
                };
            }

            List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
            Collections.sort(tm, caloriasComparator);
            return tm.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
        }
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
        if (menuIngre.isEmpty()){
            return Constantes.NO_MENU_INGREDIENTE;
        }
        else {
            return menuIngre.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
        }

    }
    @Override
    public String getMenusExcluyeIngrediente(String ingrediente) {
        List<Menu> tm = new ArrayList<>(menus.getMenusMap().values());
        List<Menu> menuIngreAremover  = new ArrayList<>();
        List<Menu> menuIngre  = new ArrayList<>(tm);
        for (Menu mn : tm){
            for (Producto pr : mn.getMenu()){
                if (pr.getIngredients().contains(ingrediente)){
                    menuIngreAremover.add(mn);
                }
            }
        }
        menuIngre.removeAll(menuIngreAremover);
        if (menuIngre.isEmpty()){
            return Constantes.NO_MENU_INGREDIENTE;
        }
        else {
            return menuIngre.stream().map(menu -> menu.getNombreMenu()).collect(Collectors.toList()).toString();
        }

    }


    @Override
    public String getMenusDesayuno() {
        List<String> lista = menus.getMenusMap().values().stream().filter(menu -> menu.getTipo().equals("desayuno")).map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
        if (lista.isEmpty()) return Constantes.NO_MENU_DESAYUNO;
        else return lista.toString();
    }

    @Override
    public String getMenusComida() {
        List<String> lista =menus.getMenusMap().values().stream().filter(menu -> menu.getTipo().equals("comida")).map(menu -> menu.getNombreMenu()).collect(Collectors.toList());
        if(lista.isEmpty()) return Constantes.NO_MENU_COMIDA;
        else return lista.toString();
    }
    @Override
    public boolean deleteProductoMenu(String nombreMenu, String nombre) throws MenuNoEcontradoException, NumeroMenuException {
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException(nombreMenu);
        }
        else{
            entro = true;
            if (menus.getMenusMap().get(nombreMenu).getMenu().size() == 1) throw new NumeroMenuException();
            menus.getMenusMap().get(nombreMenu).removeRetrieveProductoMenu(nombre);
        }
        return entro;
    }

    @Override
    public boolean addMenuBolsa(String nombreMenu, IAdministracion administracion) throws MenuNoEcontradoException {
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException();
        }
        else {
            entro = true;
            Menu menuAnadir = menus.getMenusMap().get(nombreMenu);
            administracion.addMenuBolsa(menuAnadir);
        }
        return entro;
    }

    @Override
    public boolean elimninarMenuBolsa(String nombreMenu, IAdministracion administracion) throws MenuNoEcontradoException {
        boolean entro = false;
        if (!menus.getMenusMap().containsKey(nombreMenu)){
            throw new MenuNoEcontradoException();
        }
        else {
            entro = true;
            Menu menuAnadir = menus.getMenusMap().get(nombreMenu);
            administracion.eliminarMenuBolsa(menuAnadir);
        }
        return entro;
    }

}
