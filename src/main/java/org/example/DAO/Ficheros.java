package org.example.DAO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.DOMAIN.Cliente;
import org.example.DOMAIN.Menu;
import org.example.DOMAIN.Pedido;
import org.example.DOMAIN.Producto;

import java.io.*;
import java.util.*;

public class Ficheros {
    public static HashMap<String, List<Producto>> cargarJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Properties pr = new Properties();
        InputStream entrada = new FileInputStream("src/main/resources/Properties/fichero.properties");
        pr.load(entrada);

        File comidasFile = new File(pr.getProperty("food"));
        List<Producto> comidas = objectMapper.readValue(comidasFile, new TypeReference<List<Producto>>() {});

        File desayunosFile = new File(pr.getProperty("breakfast"));
        List<Producto> desayunos = objectMapper.readValue(desayunosFile, new TypeReference<List<Producto>>() {});

        File bebidasFile = new File(pr.getProperty("drinks"));
        List<Producto> bebidas = objectMapper.readValue(bebidasFile, new TypeReference<List<Producto>>() {});

        HashMap<String, List<Producto>> productos = new HashMap<>();
        productos.put("comidas",comidas);
        productos.put("desayunos",desayunos);
        productos.put("bebidas",bebidas);

        entrada.close();

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

    public static Cliente recuperarFicheroBinario(File fichero) throws IOException {
        Cliente aux = null;
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(fichero))){
            aux = (Cliente) os.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new IOException();
        }
        return aux;
    }
    public static boolean  guardarFicheroBinario(String nombreFichero, Cliente cliente) throws IOException {
        boolean escrito = false;
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            os.writeObject(cliente);
            escrito = true;
        }
        catch (IOException e ){
            throw e;
        }
        return escrito;
    }

    public static TreeSet<Pedido> recuperarFicheroPedidos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File pedidosFile = new File("src/main/resources/pedidos.json");
        TreeSet<Pedido> pedidos = objectMapper.readValue(pedidosFile, new TypeReference<TreeSet<Pedido>>() {});

        return pedidos;
    }

}
