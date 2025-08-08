package com.medvoll.api.controller;

import com.medvoll.api.domain.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired // Inyecta automáticamente la implementación de IPacienteRepository
    private IPacienteRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrarPaciente(@RequestBody @Valid PacienteDTO datos, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(datos);
        repository.save(paciente);

        // Construye la URI para el nuevo recurso
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        // Devuelve un 201 Created con los detalles del paciente registrado
        return ResponseEntity.created(uri).body(new DetallesPacienteDTO(paciente));
    }

    // Metodo para obtener pacientes por paginación
    @GetMapping
    public ResponseEntity<Page<ListaPacienteDTO>> listarPacientes(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion).map(ListaPacienteDTO::new);

        return ResponseEntity.ok(page);
    }

    @Transactional // Asegura que la transacción se maneje correctamente en método PUT
    @PutMapping
    public ResponseEntity actualizarPaciente(@RequestBody @Valid ActualizarPacienteDTO datos) {
        var paciente = repository.getReferenceById(datos.id());
        paciente.actualizarDatos(datos);
        // No es necesario llamar a repository.save(paciente) porque getReferenceById ya está gestionando la entidad

        return ResponseEntity.ok(new DetallesPacienteDTO(paciente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.eliminar(); // Eliminación lógica cambiando el estado a inactivo

        return ResponseEntity.noContent().build(); // Devuelve un 204 No Content
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarPaciente(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetallesPacienteDTO(paciente));
    }
}
