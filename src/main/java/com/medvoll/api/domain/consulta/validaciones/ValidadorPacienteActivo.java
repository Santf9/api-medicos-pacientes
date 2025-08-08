package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.paciente.IPacienteRepository;

public class ValidadorPacienteActivo {

    private IPacienteRepository repository;

    public void validar(DatosReservaConsultaDTO datos) {
        var pacienteEstaActivo = repository.findActivoById(datos.idPaciente());
        if(!pacienteEstaActivo) {
            throw new ValidacionException("La consulta no puede ser reservada con paciente inactivo");
        }

    }
}
