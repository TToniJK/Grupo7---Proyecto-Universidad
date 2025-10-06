package Proyecto.src;

public class NodoProducto {

    // Variables
    private Producto producto;
    private NodoProducto siguiente;

    // Constructor
    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }

    // Getters
    public Producto getProducto() { return producto; }
    public NodoProducto getSiguiente() { return siguiente; }   
    

    public void setProducto(Producto producto) { this.producto = producto; } 
    public void setSiguiente(NodoProducto siguiente) { this.siguiente = siguiente; }

}
