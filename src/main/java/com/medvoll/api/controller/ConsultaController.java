package com.medvoll.api.controller;
import com.medvoll.api.domain.consulta.DatosCancelamientoConsultaDTO;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.consulta.ReservaDeConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")

public class ConsultaController {

    @Autowired
    private ReservaDeConsultaService reserva;

    @Transactional
    @PostMapping
    public ResponseEntity agendarConsulta(@RequestBody @Valid DatosReservaConsultaDTO datos) {

        var detallesConsulta = reserva.reservarConsulta(datos);

        return ResponseEntity.ok(detallesConsulta);
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DatosCancelamientoConsultaDTO datos) {
        reserva.cancelarConsulta(datos);
        return ResponseEntity.noContent().build();
    }
}
