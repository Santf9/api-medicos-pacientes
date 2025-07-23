package com.medvoll.api.medico;
import com.medvoll.api.direccion.DireccionDTO;
import jakarta.validation.constraints.NotNull;

public record ActualizarMedicoDTO(

        @NotNull Long id,
        String nombre,
        String telefono,
        DireccionDTO direccion
) {
}
