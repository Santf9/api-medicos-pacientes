package com.medvoll.api.domain.consulta;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosReservaConsultaDTO(

    Long idMedico,
    @NotNull Long idPaciente,
    @NotNull @Future LocalDateTime fecha

) {
}
