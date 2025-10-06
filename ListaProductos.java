package Proyecto.src;

import java.util.Date;

public class ListaProductos {

    private Producto primero;
    private Producto ultimo;



    public ListaProductos() {primero = null;}
    public Producto getPrimero() {return primero;}
    public void setPrimero(Producto Nuevoprimero) {this.primero = Nuevoprimero;}
    public Producto getUltimo() {return ultimo;}
    public void setUltimo(Producto NuevoUltimo) {this.ultimo = NuevoUltimo;}

    //Metodos
    public void InsertarProductoInicial(String nombreProducto,double precioProducto
    ,String categoriaProducto,Date fechaVencimientoProducto
    ,int cantidadProducto) {
        Producto nuevoNodoInicial = new Producto(nombreProducto, 
        precioProducto, categoriaProducto, 
        fechaVencimientoProducto, cantidadProducto);
        nuevoNodoInicial.setSiguiente(primero);
        setPrimero(nuevoNodoInicial);
    }

    public void InsertarProductoUltimo(String nombreProducto,double precioProducto
    ,String categoriaProducto,Date fechaVencimientoProducto
    ,int cantidadProducto) { 

        Producto nuevoNodoFinal = new Producto(nombreProducto, 
        precioProducto, categoriaProducto, 
        fechaVencimientoProducto, cantidadProducto);

        if (primero == null) {
            setPrimero(nuevoNodoFinal); 
            return;
        }
        Producto nodoTemp = primero;
        while (nodoTemp.getSiguiente() != null) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        nodoTemp.setSiguiente(nuevoNodoFinal);
    }

    public Producto buscarProducto(String nombreBuscado) {
        Producto actual = primero;
        while (actual != null) {
            if (nombreBuscado.equalsIgnoreCase(actual.getNombre())) {
                System.out.println("Producto encontrado: " + actual.getNombre());
                return actual;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado: " + nombreBuscado);
        return null;
    }

        public Producto eliminaProducto(String eliminarPorNombre) {
            if (primero == null) {
                System.out.println("No se encuentra lo indicado");
                return null;
            }
            Producto nodoTemp = primero;
            Producto anteriorTemp = nodoTemp;
            
            while (nodoTemp != null && !eliminarPorNombre.equalsIgnoreCase(nodoTemp.getNombre())) {
                anteriorTemp = nodoTemp;
                nodoTemp = nodoTemp.getSiguiente();
            }
            if (nodoTemp != null) {
                if (anteriorTemp == null) {
                    primero = nodoTemp.getSiguiente();
                } else {
                    anteriorTemp.setSiguiente(nodoTemp.getSiguiente());
                }
                System.out.println("Producto eliminado: " + nodoTemp.getNombre());
            } else {
                System.out.println("No se encontró lo indicado.\n" + eliminarPorNombre);
            }
            return nodoTemp;
        }

        public boolean modificarProducto(String nombre, Producto nuevoProducto) {
    Producto actual = primero;
    while (actual != null) {
        if (actual.getNombre().equalsIgnoreCase(nombre)) {
            actual.setNombre(nuevoProducto.getNombre());
            actual.setPrecio(nuevoProducto.getPrecio());
            actual.setCategoria(nuevoProducto.getCategoria());
            actual.setCantidad(nuevoProducto.getCantidad());
            actual.setFechaVencimiento(nuevoProducto.getfechaVencimiento());
            
            System.out.println("✅ Producto modificado: " + nombre);
            return true;
        }
        actual = actual.getSiguiente();
    }
    System.out.println("❌ Producto no encontrado: " + nombre);
    return false;
}

        public boolean agregarImagen(String nombreProducto, String rutaImagen) {    
        Producto actual = primero;
        while (actual != null) {
            if (actual.getNombre().equalsIgnoreCase(nombreProducto)) {
                actual.agregarImagenes(rutaImagen);
                System.out.println("Imagen agregada a: " + nombreProducto);
                return true;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Producto no encontrado para agregar imagen: " + nombreProducto);
        return false;
    }

    public void generarReporte() {
    if (primero == null) {
        System.out.println("La lista está vacía");
        return;
    }

    System.out.println("\n=== REPORTE DE COSTOS ===");
    double costoTotalAcumulado = 0;
    Producto actual = primero; 
    int i = 1;

    while (actual != null) {
        double costoTotalProducto = actual.calcularCosto();
        costoTotalAcumulado += costoTotalProducto;

        System.out.println(i + ". " + actual.getNombre() + 
                        " - Costo total: " + costoTotalProducto);
        i++;
        actual = actual.getSiguiente();
    }

    System.out.println("\nCOSTO TOTAL ACUMULADO: " + costoTotalAcumulado);
}

    public void mostrarProductos() {
    if (primero == null) {
        System.out.println("La lista está vacía");
        return;
    }
    System.out.println("\n=== LISTA DE PRODUCTOS ===");
    Producto actual = primero; 
    int i = 1;
    while (actual != null) {
        System.out.println(i + ". " + actual.toString());
        i++;
        actual = actual.getSiguiente();
    }

    }

}



    

