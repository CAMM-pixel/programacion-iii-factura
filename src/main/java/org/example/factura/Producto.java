package org.example.factura;

public class Producto {
    private String id;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto() {}

    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor a 0");
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Cantidad: " + cantidad + ", Precio: $" + precio + ")";
    }
}
