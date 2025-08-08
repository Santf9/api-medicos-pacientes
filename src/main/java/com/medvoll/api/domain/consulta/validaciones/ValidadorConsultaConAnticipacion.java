package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorConsultaConAnticipacion {

    public void validar(DatosReservaConsultaDTO datos) {
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();

        if(diferenciaEnMinutos < 30) {
            throw new ValidacionException("Las consultas deben reservarse con al menos 30 minutos de anticipación");
        }

    }
}
