package org.example.factura;

import javafx.beans.property.*;

public class Producto {
    private final StringProperty id;
    private final StringProperty nombre;
    private final IntegerProperty cantidad;
    private final DoubleProperty precio;
    private final StringProperty descripcion;

    public Producto(String id, String nombre, int cantidad, double precio, String descripcion) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.precio = new SimpleDoubleProperty(precio);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public String getId() { return id.get(); }
    public String getNombre() { return nombre.get(); }
    public int getCantidad() { return cantidad.get(); }
    public double getPrecio() { return precio.get(); }
    public String getDescripcion() { return descripcion.get(); }

    public void setId(String id) { this.id.set(id); }
    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public void setCantidad(int cantidad) { this.cantidad.set(cantidad); }
    public void setPrecio(double precio) { this.precio.set(precio); }
    public void setDescripcion(String descripcion) { this.descripcion.set(descripcion); }

    // Properties (para TableView y bindings)
    public StringProperty idProperty() { return id; }
    public StringProperty nombreProperty() { return nombre; }
    public IntegerProperty cantidadProperty() { return cantidad; }
    public DoubleProperty precioProperty() { return precio; }
    public StringProperty descripcionProperty() { return descripcion; }

    @Override
    public String toString() {
        return nombre.get() + " (" + id.get() + ") - $" + precio.get() + " x" + cantidad.get() + "Descripción: " + descripcion.get();
    }
}
