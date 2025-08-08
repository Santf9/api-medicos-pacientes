package com.medvoll.api.domain.paciente;

public record ListaPacienteDTO(

        Long id,
        String nombre,
        String email,
        String documento
) {
    public ListaPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
    }
}
