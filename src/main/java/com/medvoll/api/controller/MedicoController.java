package com.medvoll.api.controller;
import com.medvoll.api.medico.Medico;
import com.medvoll.api.medico.MedicoDTO;
import com.medvoll.api.service.IMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired // Inyecta automáticamente la implementación de IMedicoRepository
    private IMedicoRepository repository;

    @Transactional // Marca el metodo como transaccional, lo que significa que todas las operaciones de este metodo se ejecutarán en una transacción uso Flyway
    @PostMapping
    public void registrarMedico(@RequestBody MedicoDTO datos) { // Aquí puedes procesar los datos del médico
        repository.save(new Medico(datos));
    }
}
