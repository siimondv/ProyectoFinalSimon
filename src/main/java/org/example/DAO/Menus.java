package org.example.DAO;

import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Producto;

import java.util.*;
import java.util.stream.Collectors;

public class Menus {
    private TreeMap<String, Menu> menusMap;

    public Menus(List<Menu> menus){
        menusMap = new TreeMap<>();
        for (Menu mn: menus) {
            menusMap.put(mn.getNombreMenu(),mn);
        }
    }

    public TreeMap<String, Menu> getMenusMap() {
        return new TreeMap<>(menusMap);
    }

    public void setMenusMap(TreeMap<String, Menu> menusMap) {
        this.menusMap = menusMap;

    }
}
