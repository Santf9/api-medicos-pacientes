package com.medvoll.api.direccion;

public record DireccionDTO(

        String calle,
        String numero,
        String barrio,
        String codigoPostal,
        String ciudad,
        String estado
) {
}
