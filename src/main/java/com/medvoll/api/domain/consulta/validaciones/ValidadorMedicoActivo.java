package com.medvoll.api.domain.consulta.validaciones;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.medico.IMedicoRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private IMedicoRepository repository;

    public void validar(DatosReservaConsultaDTO datos) {
        // Elección del medico opcional
        if(datos.idMedico() == null) {
            return; // No hay médico seleccionado, no se valida
        }

        var MedicoEstaActivo = repository.findActivoById(datos.idMedico());
        if(!MedicoEstaActivo) {
            throw new ValidacionException("La consulta no puede ser reservada con un médico inactivo");
        }

    }
}
