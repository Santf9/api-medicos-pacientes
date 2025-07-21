package com.medvoll.api.medico;
import com.medvoll.api.direccion.DireccionDTO;

public record MedicoDTO(

        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DireccionDTO direccion
) {
}
