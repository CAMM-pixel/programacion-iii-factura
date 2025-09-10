package org.example.factura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {
    private String nombre;
    private String id;
    private String direccion;
    private String email;
}

