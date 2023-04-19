package org.example.SERVICE;

import org.example.DOMAIN.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InicioAplicacion {
    private InicioAplicacion(){}

    //convierte los archivos JSON
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

    public void cargarFicheroMenu(HashMap<String, List<Producto>> diferentesProductos){

    }

}
