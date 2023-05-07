package org.example.DAO;

import org.example.DOMAIN.Menu;

import java.util.*;


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
