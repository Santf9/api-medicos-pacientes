package com.medvoll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsultaDTO(
    @NotNull
    Long idConsulta,
    @NotNull
    MotivoCancelamiento motivo
) {
}
