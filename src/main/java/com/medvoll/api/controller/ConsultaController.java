package com.medvoll.api.controller;
import com.medvoll.api.domain.consulta.DatosDetallesConsultaDTO;
import com.medvoll.api.domain.consulta.DatosReservaConsultaDTO;
import com.medvoll.api.domain.consulta.ReservaDeConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ReservaDeConsultaService reserva;

    @Transactional
    @PostMapping
    public ResponseEntity agendarConsulta(@RequestBody @Valid DatosReservaConsultaDTO datos) {
        reserva.reservarConsulta(datos);
        return ResponseEntity.ok(new DatosDetallesConsultaDTO(null, null, null, null));
    }
}
