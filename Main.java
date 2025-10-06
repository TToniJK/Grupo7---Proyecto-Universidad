package Proyecto.src;

import java.util.Scanner;

public class Main {
    private static ListaProductos listaProductos = new ListaProductos();
    private static Scanner scanner = new Scanner(System.in);  

    public static void main(String[] args) {
        menu();
    }   

    public static void menu() {
        int opc;

        do {
            System.out.println("\n\t=== SISTEMA DE GESTIÓN DE VENTAS ===");
            System.out.println("1. Insertar producto al inicio");
            System.out.println("2. Insertar producto al final");
            System.out.println("3. Modificar producto");
            System.out.println("4. Agregar imagen al producto");
            System.out.println("5. Reporte de costos");
            System.out.println("6. Buscar producto");
            System.out.println("7. Mostrar productos");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Salir");
            System.out.println("\nSeleccione una opción: ");

            opc = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opc) {
                case 1:
                    insertarProductoInicio();
                    break;
                case 2:
                    insertarProductoFinal();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    agregarImagenProducto();
                    break;
                case 5:
                    listaProductos.generarReporte();
                    break;
                case 6:
                    buscarProducto();
                    break;
                case 7:
                    listaProductos.mostrarProductos();
                    break;
                case 8:
                    eliminarProducto();
                    break;
                case 9:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opc != 9);
    }

    // Método para leer datos del producto
    private static void leerDatosProducto(String[] datos) {
    System.out.print("Nombre del producto: ");
    datos[0] = scanner.nextLine();
    System.out.print("Precio: ");
    double precio = scanner.nextDouble(); 
    scanner.nextLine(); 
    datos[1] = String.valueOf(precio); 
    System.out.print("Categoría: ");
    datos[2] = scanner.nextLine();
    System.out.print("Cantidad en inventario: ");
    int cantidad = scanner.nextInt(); 
    scanner.nextLine(); 
    datos[3] = String.valueOf(cantidad); 
}

    private static void insertarProductoInicio() {
        System.out.println("\n--- INSERTAR PRODUCTO AL INICIO ---");
        String[] datos = new String[4];
        leerDatosProducto(datos);
        
        listaProductos.InsertarProductoInicial(
            datos[0], 
            Double.parseDouble(datos[1]), 
            datos[2], 
            null, 
            Integer.parseInt(datos[3])
        );
        System.out.println("✅ Producto insertado al inicio");
    }

    private static void insertarProductoFinal() {
        System.out.println("\n--- INSERTAR PRODUCTO AL FINAL ---");
        String[] datos = new String[4];
        leerDatosProducto(datos);
        
        listaProductos.InsertarProductoUltimo(
            datos[0], 
            Double.parseDouble(datos[1]), 
            datos[2], 
            null, 
            Integer.parseInt(datos[3])
        );
        System.out.println("✅ Producto insertado al final");
    }

    private static void modificarProducto() {
        System.out.println("\n--- MODIFICAR PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombreViejo = scanner.nextLine();

        // Buscar si existe
        Producto productoExistente = listaProductos.buscarProducto(nombreViejo);
        if (productoExistente != null) {
            System.out.println("Producto encontrado. Ingrese los nuevos datos:");
            
            String[] nuevosDatos = new String[4];
            leerDatosProducto(nuevosDatos);
            
            // Crear nuevo producto con los datos actualizados
            Producto nuevoProducto = new Producto(
                nuevosDatos[0], 
                Double.parseDouble(nuevosDatos[1]), 
                nuevosDatos[2], 
                null, 
                Integer.parseInt(nuevosDatos[3])
            );
            
            // Modificar el producto
            System.out.println("⚠️ Función de modificación por implementar");
            
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
    }

    private static void agregarImagenProducto() {
        System.out.println("\n--- AGREGAR IMAGEN A PRODUCTO ---");
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ruta de la imagen: ");
        String rutaImagen = scanner.nextLine();

        boolean exito = listaProductos.agregarImagen(nombre, rutaImagen);
        if (exito) {
            System.out.println("✅ Imagen agregada exitosamente");
        }
    }

    private static void buscarProducto() {
        System.out.println("\n--- BUSCAR PRODUCTO ---");
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        Producto producto = listaProductos.buscarProducto(nombre);
        if (producto != null) {
            System.out.println("✅ Producto encontrado:");
            System.out.println(producto.toString());
        }
    }

    private static void eliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Producto eliminado = listaProductos.eliminaProducto(nombre);
        if (eliminado != null) {
            System.out.println("✅ Producto eliminado exitosamente");
        }
    }
}
