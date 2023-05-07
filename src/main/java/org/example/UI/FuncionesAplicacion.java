package org.example.UI;

import org.example.COMMON.*;
import org.example.SERVICE.UtilizacionMenusYPedidos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class FuncionesAplicacion {
    private UtilizacionMenusYPedidos utilizacionMenusCliente;
    public FuncionesAplicacion() throws IOException {
        utilizacionMenusCliente = new UtilizacionMenusYPedidos();
    }
    public boolean inicioSesion() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INICIOSESIONINTRO);
        String nombreUsuario = sc.nextLine();
        if (!utilizacionMenusCliente.recuperarEstadoCliente(nombreUsuario)){
            System.out.println(Constantes.INICIOSESIONEDAD);
            int edad = sc.nextInt();
            sc.nextLine();
            System.out.println(Constantes.INICIOSESIONCONTRA);
            String contrasena = sc.nextLine();
            utilizacionMenusCliente.asignarCliente(nombreUsuario,contrasena,edad);
            utilizacionMenusCliente.guardarEstadoCliente();
            return true;
        }
        else {
            System.out.println(Constantes.INICIOSESIONCONTRA);
            String contrasena = sc.nextLine();
            if (utilizacionMenusCliente.revisarContrasena(contrasena)){
                System.out.println(Constantes.INICIOSESIONBIENVENIDA);
                return true;
            }
            else {
                System.out.println(Constantes.INICIOSESIONINCORRECTO);
                return false;
            }
        }
    }
    public boolean inicioSesionAdmin() throws IOException {
        Properties pr = new Properties();
        InputStream entrada = new FileInputStream("src/main/resources/Properties/fichero.properties");
        pr.load(entrada);
        String contraAdmin = pr.getProperty("contraAdmin");
        entrada.close();
        Scanner sc = new Scanner(System.in);
        System.out.println(Constantes.INICIOSESIONADMIN);
        String intento = sc.nextLine();
        if (intento.equals(contraAdmin)){
            System.out.println(Constantes.INICIOSESIONBIENVENIDA);
            return true;
        }
        else {
            System.out.println(Constantes.INICIOSESIONINCORRECTO);
            return false;
        }
    }
    public void menuAplicacionUsuario() throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
            do {
                try {
                    cargarMenuCliente();
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1: {
                            System.out.println(utilizacionMenusCliente.getMenus());
                            break;
                        }
                        case 2: {
                            System.out.println(Constantes.ORDEN);
                            int orden = sc.nextInt();
                            System.out.println(utilizacionMenusCliente.getMenusPrecioSort(((Integer)orden).equals(1)));
                            break;
                        }
                        case 3: {
                            System.out.println(Constantes.ORDEN);
                            int orden = sc.nextInt();
                            System.out.println(utilizacionMenusCliente.getMenusCaloriasSort(((Integer)orden).equals(1)));
                            break;
                        }
                        case 4: {
                            System.out.println(utilizacionMenusCliente.getMenusDesayuno());
                            break;
                        }
                        case 5: {
                            System.out.println(utilizacionMenusCliente.getMenuComida());
                            break;
                        }
                        case 6: {
                            sc.nextLine();
                            System.out.println(Constantes.MENU_NOMBRE);
                            String nombreMenu = sc.nextLine();
                            System.out.println(utilizacionMenusCliente.getContenidoMenu(nombreMenu));
                            break;
                        }
                        case 7: {
                            sc.nextLine();
                            System.out.println(Constantes.MENU_INGREDIENTE);
                            String nombreIngrediente = sc.nextLine();
                            System.out.println(utilizacionMenusCliente.getMenusContieneIngrediente(nombreIngrediente));
                            break;
                        }
                        case 8: {
                            sc.nextLine();
                            System.out.println(Constantes.MENU_INGREDIENTE);
                            String nombreIngrediente = sc.nextLine();
                            System.out.println(utilizacionMenusCliente.getMenusExcluyeIngrediente(nombreIngrediente));
                            break;
                        }
                        case 9: {
                            sc.nextLine();
                            System.out.println(Constantes.MENU_ANADIR);
                            String nombreMenu = sc.nextLine();
                            if (utilizacionMenusCliente.addMenuBolsa(nombreMenu))
                                System.out.println(Constantes.LISTO);
                            else System.out.println(Constantes.FALLO);
                            break;
                        }
                        case 10: {
                            sc.nextLine();
                            System.out.println(Constantes.MENU_ELIMINAR);
                            String nombreMenu = sc.nextLine();
                            if (utilizacionMenusCliente.eliminarMenuBolsa(nombreMenu))
                                System.out.println(Constantes.LISTO);
                            else System.out.println(Constantes.FALLO);
                            break;
                        }
                        case 11: {
                            System.out.println(utilizacionMenusCliente.listarBolsa());
                            break;
                        }
                        case 12: {
                            if (utilizacionMenusCliente.addPedido()) System.out.println(Constantes.LISTO);
                            else System.out.println(Constantes.FALLO);
                            break;
                        }
                        case 13: {
                            if (utilizacionMenusCliente.guardarEstadoCliente())
                                System.out.println(Constantes.LISTO);
                            else System.out.println(Constantes.FALLO);
                            break;
                        }
                        case 14: {
                            System.out.println(Constantes.DESPEDIDA);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                catch (MenuNoEcontradoException ex){
                    System.out.println(Constantes.ERROR_MENUNOENCONTRADO);
                }
                catch (InputMismatchException e){
                    sc.nextLine();
                    System.out.println(Constantes.ERROR_INPUT);
                }
            }
            while (opcion != 14);
    }

    public void menuAplicacionAdmin()  {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                cargarMenuAdmin();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        System.out.println(utilizacionMenusCliente.getMenus());
                        break;
                    }
                    case 2: {
                        sc.nextLine();
                        System.out.println(Constantes.MENU_NOMBRE);
                        String nombreMenu = sc.nextLine();
                        System.out.println(utilizacionMenusCliente.getContenidoMenu(nombreMenu));

                        break;
                    }
                    case 3: {
                        crearProducto();
                        break;
                    }
                    case 4: {
                        sc.nextLine();
                        System.out.println(Constantes.MENU_CAMBIAR_DESCUENTO);
                        String nombreMenu = sc.nextLine();
                        System.out.println(Constantes.MENU_NUEVO_DESCUENTO);
                        int descuento = sc.nextInt();
                        if (utilizacionMenusCliente.editDescuentoMenu(nombreMenu, descuento))
                            System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 5: {
                        sc.nextLine();
                        System.out.println(Constantes.MENU_CAMBIAR_NOMBRE);
                        String nombreMenu = sc.nextLine();
                        System.out.println(Constantes.MENU_NUEVO_NOMBRE);
                        String nuevoNombre = sc.nextLine();
                        if (utilizacionMenusCliente.changeNombreMenu(nombreMenu, nuevoNombre))
                            System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 6: {
                        sc.nextLine();
                        System.out.println(Constantes.MENU_ELIMINAR_PRODUCTO);
                        String nombreMenu = sc.nextLine();
                        System.out.println(Constantes.MENU_PRODUCTO_A_ELIMINAR);
                        String nombreProducto = sc.nextLine();
                        if (utilizacionMenusCliente.deleteProductoMenu(nombreMenu, nombreProducto))
                            System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 7: {
                        System.out.println(Constantes.DESPEDIDA);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } catch (NumeroMenuException e) {
                System.out.println(Constantes.ERROR_INSUFICIENTEMENU);
            } catch (MenuNoEcontradoException e) {
                System.out.println(Constantes.ERROR_MENUNOENCONTRADO);
            } catch (TipoProductoException e) {
                System.out.println(Constantes.ERROR_TIPOPRODUCTO);
            } catch (TipoMenuException e) {
                System.out.println(Constantes.ERROR_TIPOMENU);
            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println(Constantes.ERROR_INPUT);
            }
            catch (IllegalArgumentException e){
                System.out.println(Constantes.ERROR_COMUN);
            }
        }while (opcion!= 7);

    }
    public void pedidosAplicacionAdmin(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                cargarPedidosAdmin();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        System.out.println(utilizacionMenusCliente.listarPedidos());
                        break;
                    }
                    case 2: {
                        sc.nextLine();
                        System.out.println(Constantes.PEDIDO_MAX_PRECIO);
                        int MaxPrecio = sc.nextInt();
                        System.out.println(utilizacionMenusCliente.listarPedidosMaxPrecio(MaxPrecio));
                        break;
                    }
                    case 3: {
                        sc.nextLine();
                        System.out.println(Constantes.PEDIDO_CLIENTE_FILTRAR);
                        String nombreCliente = sc.nextLine();
                        System.out.println(utilizacionMenusCliente.listarPedidosPorNombre(nombreCliente));
                        break;
                    }
                    case 4: {
                        System.out.println(Constantes.PEDIDO_ID);
                        int id = sc.nextInt();
                        System.out.println(Constantes.PEDIDO_NUEVO_PRECIO);
                        double precio = sc.nextDouble();
                        if (utilizacionMenusCliente.modifyPedidoPrecio(id, precio))
                            System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 5: {
                        System.out.println(Constantes.PEDIDO_ID);
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println(Constantes.PEDIDO_NUEVO_NOMBRE);
                        String nombre = sc.nextLine();
                        if (utilizacionMenusCliente.modifyNombrePedido(id, nombre))
                            System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 6: {
                        System.out.println(Constantes.PEDIDO_ID);
                        int id = sc.nextInt();
                        if (utilizacionMenusCliente.deletePedido(id)) System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 7: {
                        if (utilizacionMenusCliente.deleteAllPedidos()) System.out.println(Constantes.LISTO);
                        else System.out.println(Constantes.FALLO);
                        break;
                    }
                    case 8: {
                        System.out.println(Constantes.DESPEDIDA);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println(Constantes.ERROR_INPUT);
            }
        }
        while (opcion != 8);

    }

    private void cargarMenuCliente(){
        System.out.println(Constantes.MENU_CLIENTE);
    }
    private void cargarMenuAdmin(){
        System.out.println(Constantes.MENU_ADMIN);
    }
    private void cargarPedidosAdmin(){
        System.out.println(Constantes.PEDIDOS_ADMIN);
    }

    private void crearProducto() throws MenuNoEcontradoException, TipoProductoException, TipoMenuException, NumeroMenuException {
        Scanner sc = new Scanner(System.in);
        List<String> ingredientes = new ArrayList<>();
        System.out.println(Constantes.MENU_NUEVO_PRODUCTO);
        String nombreMenu = sc.nextLine();
        System.out.println(Constantes.PRODUCTO_NOMBRE);
        String nombre = sc.nextLine();
        System.out.println(Constantes.PRODUCTO_PRECIO);
        int precio = sc.nextInt();
        System.out.println(Constantes.PRODUCTO_CALORIAS);
        int calorias = sc.nextInt();
        System.out.println(Constantes.PRODUCTO_TAMANO);
        int tamano = sc.nextInt();
        System.out.println(Constantes.PRODUCTO_TIPO);
        sc.nextLine();
        String tipo = sc.nextLine();
        System.out.println(Constantes.PRODUCTO_NUMERO_INGREDIENTES);
        int cantidad = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidad; i++){
            System.out.println(Constantes.PRODUCTO_INGREDIENTES);
            ingredientes.add(sc.nextLine());
        }
        if (cantidad > 0){
            utilizacionMenusCliente.addProductoMenu(nombreMenu,nombre,precio,calorias,tamano,tipo,ingredientes);
        }

    }

}
