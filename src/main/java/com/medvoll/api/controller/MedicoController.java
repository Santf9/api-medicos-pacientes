package com.medvoll.api.controller;
import com.medvoll.api.medico.Medico;
import com.medvoll.api.medico.MedicoDTO;
import com.medvoll.api.medico.ListaMedicoDTO;
import com.medvoll.api.service.IMedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<ListaMedicoDTO> listarMedicos() {
        return repository.findAll().stream().map(ListaMedicoDTO::new)
                .toList();

    }
}
