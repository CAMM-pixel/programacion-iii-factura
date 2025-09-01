package org.example.factura;

public class IVA implements Impuesto {
    @Override
    public double calcular(double subtotal) {
        return subtotal * 0.19;
    }
}

