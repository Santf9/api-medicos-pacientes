package com.medvoll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DireccionDTO(

        @NotBlank String calle,
        String numero,
        @NotBlank String barrio,
        @NotBlank @Pattern(regexp = "\\d{4}") String codigo_postal,
        @NotBlank String ciudad,
        @NotBlank String estado
) {
}
