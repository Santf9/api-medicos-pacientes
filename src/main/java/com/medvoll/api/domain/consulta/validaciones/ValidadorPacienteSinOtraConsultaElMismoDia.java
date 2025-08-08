package com.medvoll.api.domain.consulta.validaciones;

import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.consulta.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSinOtraConsultaElMismoDia implements ValidadorDeConsultas {

     @Autowired
     private IConsultaRepository repository;

    public void validar(DatosReservaConsultaDTO datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var tieneOtraConsulta = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);

        if (tieneOtraConsulta) {
            throw new ValidacionException("El paciente ya tiene una consulta reservada para el mismo día");
        }


        }
}
