package com.medvoll.api.domain.medico;
import com.medvoll.api.domain.direccion.DireccionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ActualizarMedicoDTO(

        @NotNull Long id,
        String nombre,
        String telefono,
        @Valid DireccionDTO direccion
) {
}
