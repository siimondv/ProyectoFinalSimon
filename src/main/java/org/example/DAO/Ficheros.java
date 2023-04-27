package org.example.DAO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Producto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Ficheros {
    public static HashMap<String, List<Producto>> cargarJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File comidasFile = new File("src/main/resources/food.json");
        List<Producto> comidas = objectMapper.readValue(comidasFile, new TypeReference<List<Producto>>() {});

        File desayunosFile = new File("src/main/resources/breakfast.json");
        List<Producto> desayunos = objectMapper.readValue(desayunosFile, new TypeReference<List<Producto>>() {});

        File bebidasFile = new File("src/main/resources/drinks.json");
        List<Producto> bebidas = objectMapper.readValue(bebidasFile, new TypeReference<List<Producto>>() {});

        HashMap<String, List<Producto>> productos = new HashMap<>();
        productos.put("comidas",comidas);
        productos.put("desayunos",desayunos);
        productos.put("bebidas",bebidas);

        return productos;
    }


    public static void escribirFicheroMenu(HashMap<String, List<Producto>> diferentesProductos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Random rm = new Random();
        FileWriter fw = new FileWriter("src/main/resources/menuUsuario.json");

        List<Producto> comidas =  diferentesProductos.get("comidas");
        List<Producto> desayunos =  diferentesProductos.get("desayunos");
        List<Producto> bebidas =  diferentesProductos.get("bebidas");

        fw.write("[");
        for(int i = 0; i<3; i++){
            List<Producto> comidaMenu = new ArrayList<>();
            comidaMenu.add(comidas.get(rm.nextInt(comidas.size() )));
            comidaMenu.add(bebidas.get(rm.nextInt(bebidas.size() )));

            List<Producto> desayunoMenu = new ArrayList<>();
            desayunoMenu.add(desayunos.get(rm.nextInt(desayunos.size() )));
            desayunoMenu.add(bebidas.get(rm.nextInt(bebidas.size() )));

            Menu menuComida = new Menu(comidaMenu.get(0).firstName() + comidaMenu.get(1).firstName() ,comidaMenu,"comida",20);
            Menu menuDesayuno = new Menu(desayunoMenu.get(0).firstName() + desayunoMenu.get(1).firstName() ,desayunoMenu,"desayuno",20);

            String json = mapper.writeValueAsString(menuComida);
            fw.write( json + ",");
            json = mapper.writeValueAsString(menuDesayuno);
            if(i == 2){
                fw.write(json);
            }
            else {
                fw.write(json + ",");
            }
        }
        fw.write("]");
        fw.close();
    }

    public static List<Menu> cargarFicheroMenu() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File comidasFile = new File("src/main/resources/menuUsuario.json");
        List<Menu> menus = objectMapper.readValue(comidasFile, new TypeReference<List<Menu>>() {});

        return menus;
    }

}
