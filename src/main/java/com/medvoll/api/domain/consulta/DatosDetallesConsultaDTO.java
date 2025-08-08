package com.medvoll.api.domain.consulta;

import java.time.LocalDateTime;

public record DatosDetallesConsultaDTO(

    Long idConsulta,
    Long idMedico,
    Long idPaciente,
    LocalDateTime fecha
) {
}
