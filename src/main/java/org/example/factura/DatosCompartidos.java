package org.example.factura;

import java.util.ArrayList;
import java.util.List;

public class DatosCompartidos {
    private static Cliente clienteActual;
    private static final List<Producto> productos = new ArrayList<>();

    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public static List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public static void limpiarProductos() {
        productos.clear();
    }
}