package com.medvoll.api.controller;
import com.medvoll.api.medico.Medico;
import com.medvoll.api.medico.MedicoDTO;
import com.medvoll.api.medico.ListaMedicoDTO;
import com.medvoll.api.service.IMedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Page<ListaMedicoDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(ListaMedicoDTO::new); // Page no acepta stream pero si reconoce map

    }
}
