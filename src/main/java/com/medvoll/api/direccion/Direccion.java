package com.medvoll.api.direccion;

public record Direccion(

        String calle,
        String numero,
        String barrio,
        String codigoPostal,
        String ciudad,
        String estado
) {
}
