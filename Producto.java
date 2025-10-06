package Proyecto.src;


import java.util.ArrayList;
import java.util.Date;

public class Producto {

    //Variables
    private String nombre;
    private double precio;
    private String categoria;
    private Date fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;
    private Producto producto;
    private Producto siguiente;


    //Constructor
    public Producto(String nombre,double precio
    ,String categoria,Date fechaVencimiento
    ,int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.categoria = categoria;
        listaImagenes = new ArrayList<>();
        siguiente = null;
    }

    //Getters
    public String getNombre() {return nombre;}
    public int getCantidad() {return cantidad;}
    public double getPrecio() {return precio;}
    public String getCategoria() {return categoria;}
    public Date getfechaVencimiento() {return fechaVencimiento;}
    public Producto getSiguiente() {return siguiente;}

    //Setters
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public void setFechaVencimiento(Date fechaVencimiento) {this.fechaVencimiento = fechaVencimiento;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setSiguiente(Producto siguiente) {this.siguiente = siguiente;}
    
    //Metodos
    public ArrayList<String> listaImagenes() {return listaImagenes;}
    public void agregarImagenes(String rutaImagen) {
        listaImagenes.add(rutaImagen);
    }
    public double calcularCosto() {
        return precio * cantidad;
    }
    
    @Override
    public String toString() {

        return """
        Nombre : """ + nombre +
        "\nPrecio: " + precio +
        "\nCantidad disponible: " + cantidad +
        "\nCategoria: " + categoria +
        "\nFecha de vencimiento:" + fechaVencimiento + "\n"; 
    }

}
