package com.medvoll.api.controller;
import com.medvoll.api.domain.medico.*;
import com.medvoll.api.service.IMedicoRepository;
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
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired // Inyecta automáticamente la implementación de IMedicoRepository
    private IMedicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrarMedico(@RequestBody @Valid MedicoDTO datos, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(datos);
        repository.save(medico);

        // Construye la URI para el nuevo recurso
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        // Devuelve un 201 Created con los detalles del médico registrado
        return ResponseEntity.created(uri).body(new DetallesActualizacionMedicoDTO(medico));
    }

    // Metodo para obtener un médico por paginación
    @GetMapping
    public ResponseEntity<Page<ListaMedicoDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion).map(ListaMedicoDTO::new); // Page no acepta stream pero si reconoce map

        return ResponseEntity.ok(page);
    }

    @Transactional // Asegura que la transacción se maneje correctamente en metodo PUT
    @PutMapping
    public ResponseEntity actualizarMedico(@RequestBody @Valid ActualizarMedicoDTO datos) {
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarDatos(datos);
        // No es necesario llamar a repository.save(medico) porque getReferenceById ya está gestionando la entidad

        return ResponseEntity.ok(new DetallesActualizacionMedicoDTO(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.eliminar(); // Asumiendo que tienes un metodo eliminar en la entidad Médico

        return  ResponseEntity.noContent().build(); // Devuelve un 204 No Content
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DetallesActualizacionMedicoDTO(medico));
    }
}
