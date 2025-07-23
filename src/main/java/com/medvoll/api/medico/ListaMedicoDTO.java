package com.medvoll.api.medico;

public record ListaMedicoDTO(

        Long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    // Constructor que permite crear un objeto ListaMedicoDTO a partir de un objeto Médico
    public ListaMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEmail(), medico.getDocumento(), medico.getEspecialidad());
    }
}
