package org.example.factura;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Cliente extends Persona {
    public Cliente(String nombre, String id, String direccion, String email) {
        super(nombre, id, direccion, email);
    }
}

