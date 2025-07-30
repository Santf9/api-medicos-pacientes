package com.medvoll.api.controller;
import com.medvoll.api.medico.*;
import com.medvoll.api.service.IMedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired // Inyecta automáticamente la implementación de IMedicoRepository
    private IMedicoRepository repository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicoDTO datos) { // Aquí puedes procesar los datos del médico
        repository.save(new Medico(datos));
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
}
