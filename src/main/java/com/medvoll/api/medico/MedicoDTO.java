package com.medvoll.api.medico;
import com.medvoll.api.direccion.DireccionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(

        @NotBlank
        String nombre,
        @NotBlank @Email
        String email,
        @NotBlank String telefono,
        @NotBlank @Pattern(regexp = "\\d{7,9}")
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull @Valid
        DireccionDTO direccion
) {
}
