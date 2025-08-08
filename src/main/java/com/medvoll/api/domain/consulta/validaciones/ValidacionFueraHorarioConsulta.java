package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import java.time.DayOfWeek;

public class ValidacionFueraHorarioConsulta {

    public void validar(DatosReservaConsultaDTO datos) {
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesApertura = fechaConsulta.getHour() < 7;
        var horarioDespuesCierre = fechaConsulta.getHour() >= 18;

        if(domingo || horarioAntesApertura || horarioDespuesCierre) {
            throw new ValidacionException("La consulta debe ser agendada en un día hábil y en horario de 7 a 18 hs");
        }
    }
}
