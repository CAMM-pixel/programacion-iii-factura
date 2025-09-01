package org.example.factura;

import javafx.beans.property.*;

public class LineaFactura {
    private final Producto producto;
    private final IntegerProperty cantidad;
    private final DoubleProperty subtotal;

    public LineaFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.subtotal = new SimpleDoubleProperty(producto.getPrecio() * cantidad);
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal.get();
    }

    public DoubleProperty subtotalProperty() {
        return subtotal;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + getCantidad() + " = $" + getSubtotal();
    }
}
