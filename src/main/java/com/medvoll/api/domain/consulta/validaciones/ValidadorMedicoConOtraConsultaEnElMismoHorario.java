package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.consulta.IConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoConOtraConsultaEnElMismoHorario implements ValidadorDeConsultas {

    @Autowired
    private IConsultaRepository repository;

    public void validar(DatosReservaConsultaDTO datos) {
        var medicoTieneOtraConsultaEnElMismoHorario = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());

        if (medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("El médico ya tiene una consulta reservada para esa fecha y hora");
        }
    }
}
