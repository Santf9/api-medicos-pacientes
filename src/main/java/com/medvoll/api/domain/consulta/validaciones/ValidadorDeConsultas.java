package com.medvoll.api.domain.consulta.validaciones;

import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;

public interface ValidadorDeConsultas {
    void validar(DatosReservaConsultaDTO datos);
}
