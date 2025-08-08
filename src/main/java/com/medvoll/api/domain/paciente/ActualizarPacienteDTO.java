package com.medvoll.api.domain.paciente;

import com.medvoll.api.domain.direccion.DireccionDTO;
import jakarta.validation.constraints.NotNull;

public record ActualizarPacienteDTO(

        @NotNull Long id,
        String nombre,
        String telefono,
        DireccionDTO direccion
) {
}
