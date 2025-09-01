package org.example.factura;

public class Exento implements Impuesto {
    @Override
    public double calcular(double subtotal) {
        return 0;
    }
}
