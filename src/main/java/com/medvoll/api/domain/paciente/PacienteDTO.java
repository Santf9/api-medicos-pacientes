package com.medvoll.api.domain.paciente;

import com.medvoll.api.domain.direccion.DireccionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(

        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String telefono,
        @NotBlank @Pattern(regexp = "\\d{7,14}") String documento,
        @NotNull @Valid DireccionDTO direccion
) {
}
