package com.medvoll.api.medico;

public record ListaMedicoDTO(

        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    // Constructor que permite crear un objeto ListaMedicoDTO a partir de un objeto Medico
    public ListaMedicoDTO(Medico medico) {
        this(medico.getNombre(), medico.getEmail(), medico.getDocumento(), medico.getEspecialidad());
    }
}
