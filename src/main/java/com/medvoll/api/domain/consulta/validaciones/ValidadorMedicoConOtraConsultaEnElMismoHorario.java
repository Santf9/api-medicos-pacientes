package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.consulta.IConsultaRepository;

public class ValidadorMedicoConOtraConsultaEnElMismoHorario {

    private IConsultaRepository repository;

    public void validar(DatosReservaConsultaDTO datos) {
        var medicoTieneOtraConsultaEnElMismoHorario = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());

        if (medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("El médico ya tiene una consulta reservada para el mismo horario");
        }
    }
}
