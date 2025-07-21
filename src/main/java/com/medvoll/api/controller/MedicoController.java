package com.medvoll.api.controller;
import com.medvoll.api.medico.MedicoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico(@RequestBody MedicoDTO datos) { // Aquí puedes procesar los datos del médico
        System.out.println(datos);
    }
}
