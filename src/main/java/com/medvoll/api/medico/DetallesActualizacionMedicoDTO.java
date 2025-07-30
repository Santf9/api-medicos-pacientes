package com.medvoll.api.medico;
import com.medvoll.api.direccion.Direccion;

public record DetallesActualizacionMedicoDTO(

        Long id,
        String nombre,
        String telefono,
        String email,
        String documento,
        Especialidad especialidad,
        Direccion direccion
) {
    public DetallesActualizacionMedicoDTO (Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getTelefono(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad(),
                medico.getDireccion()
        );
    }
}
