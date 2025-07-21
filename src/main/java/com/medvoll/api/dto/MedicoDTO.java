package com.medvoll.api.dto;

import com.medvoll.api.direccion.Direccion;

public record MedicoDTO(

        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        Direccion direccion
) {
}
