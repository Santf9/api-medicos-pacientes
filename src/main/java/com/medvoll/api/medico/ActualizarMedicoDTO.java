package com.medvoll.api.medico;
import com.medvoll.api.direccion.DireccionDTO;

public record ActualizarMedicoDTO(

        Long id,
        String nombre,
        String telefono,
        DireccionDTO direccion
) {
}
