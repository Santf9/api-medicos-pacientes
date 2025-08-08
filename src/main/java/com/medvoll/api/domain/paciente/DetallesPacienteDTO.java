package com.medvoll.api.domain.paciente;
import com.medvoll.api.domain.direccion.Direccion;

public record DetallesPacienteDTO(

        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        Direccion direccion
) {

    public DetallesPacienteDTO(Paciente paciente) {
        this(paciente.getId(), 
             paciente.getNombre(), 
             paciente.getEmail(), 
             paciente.getTelefono(), 
             paciente.getDocumento(), 
             paciente.getDireccion());
    }
}
