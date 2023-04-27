package org.example.UI;

import org.example.SERVICE.UtilizacionMenusCliente;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FuncionesAplicacion {
    private UtilizacionMenusCliente utilizacionMenusCliente;
    public FuncionesAplicacion() throws IOException {
        utilizacionMenusCliente = new UtilizacionMenusCliente();
    }
    public void menuAplicacionUsuario(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Pulsa una de las siguientes opciones \n1: Nuevo pedido. \n2: Cargar Pedido.");
        opcion = sc.nextInt();
        if (opcion == 1){
            //cargarMenu();
            do {
                System.out.println("Pulsa una de las siguientes opciones \n1: Listar Menus. \n2: Listar por precio.\n3: Listar por calorias.\n4: Listar menus de desayuno." +
                        "\n5: Listar menus de comida.\n6: Listar contenido menu.\n7: Listar menu con ingrediente especifico." +
                        "\n8: Listar menu sin ingrediente especifico.\n9: Anadir a la bolsa menu.\n10: Finalizar compra.\n11: Guardar bolsa.\n12: Salir.");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:{
                        System.out.println(utilizacionMenusCliente.getMenus());
                        break;
                    }
                    case 2:{
                        System.out.println(utilizacionMenusCliente.getMenusPrecioSort());
                        break;
                    }
                    case 3:{
                        System.out.println(utilizacionMenusCliente.getMenusCaloriasSort());
                        break;
                    }
                    case 4:{
                        System.out.println(utilizacionMenusCliente.getMenusDesayuno());
                        break;
                    }
                    case 5:{
                        System.out.println(utilizacionMenusCliente.getMenuComida());
                        break;
                    }
                    case 6:{
                        sc.nextLine();
                        System.out.println("Dime el nombre del menu del cual quieres ver el contenidp");
                        String nombreMenu = sc.nextLine();
                        System.out.println(utilizacionMenusCliente.getContenidoMenu(nombreMenu));
                        break;
                    }
                    case 7:{
                        sc.nextLine();
                        System.out.println("Dime el nombre del ingrediente");
                        String nombreIngrediente = sc.nextLine();
                        System.out.println(utilizacionMenusCliente.getMenusContieneIngrediente(nombreIngrediente));
                        break;
                    }
                    case 8:{
                        break;
                    }
                    case 9:{
                        break;
                    }
                    case 10:{
                        break;
                    }
                    case 11:{
                        break;
                    }
                    case 12:{
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
            while (opcion != 13);

        }
        else{
            System.out.println("Indica el nombre de usuario");
            String nombreUsuario = sc.nextLine();
            if(reivsarFichero(nombreUsuario)){
                //pasar el fichero binario a objeto Cliente
                System.out.println("Indicame la contrasena");
                //Revisas contra y listas menu
            }
        }
    }

    public void menuAplicacionAdmin(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Pulsa una de las siguientes opciones \n1: Listar Menus.\n2: Anadir menu.\n3: Anadir producto al menu." +
                "\n4: Cambiar descuento menu.\n5: Cambiar nombre menu.\n6: Eliminar producto del menu.\n7: Eliminar menu.\n7: Salir.");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:{
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
            case 5:{
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            default:{
                break;
            }
        }
    }
    public void pedidosAplicacionAdmin(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Pulsa una de las siguientes opciones \n1: Listar Pedidos.\n2: Listar pedidos filtrado.\n3: Modificar pedido." +
                "\n4: Eliminar pedido.\n5: Salir.\n6: Eliminar producto del menu.\n7: Eliminar menu.\n7: Salir.");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:{
                break;
            }
            case 2:{
                break;
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
            case 5:{
                break;
            }
            case 6:{
                break;
            }
            case 7:{
                break;
            }
            default:{
                break;
            }
        }
    }

    private boolean reivsarFichero(String nombreFichero){
        File fichero = new File(nombreFichero);
        if (!fichero.exists()){
            return false;
        }
        return true;
    }
    private void cargarMenu(){
        System.out.println("Pulsa una de las siguientes opciones \n1: Listar Menus. \n2: Listar por precio.\n3: Listar por calorias.\n4: Listar menus de desayuno." +
                "\n5: Listar menus de comida.\n6: Listar menus de comida.\n7: Listar contenido menu.\n8: Listar menu con ingrediente especifico." +
                "\n9: Listar menu sin ingrediente especifico.\n10: Anadir a la bolsa menu.\n11: Finalizar compra.\n12: Guardar bolsa.\n13: Salir.");
    }

}
