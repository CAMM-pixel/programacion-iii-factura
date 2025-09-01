package org.example.factura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<LineaFactura> lineas = new ArrayList<>();
    private Impuesto impuesto;

    public Factura(String numero, LocalDate fecha, Cliente cliente, List<LineaFactura> lineas, Impuesto impuesto) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineas = lineas;
        this.impuesto = impuesto;
    }

    public double calcularTotal() {
        double subtotal = lineas.stream().mapToDouble(LineaFactura::getSubtotal).sum();
        return subtotal + impuesto.calcular(subtotal);
    }
    public double calcularSubtotal() {
        return lineas.stream().mapToDouble(LineaFactura::getSubtotal).sum();
    }
    public Impuesto getImpuesto() {
        return impuesto;
    }

}

