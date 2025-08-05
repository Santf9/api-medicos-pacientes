package com.medvoll.api.controller;
import com.medvoll.api.domain.usuario.AutenticacionDTO;
import com.medvoll.api.domain.usuario.Usuario;
import com.medvoll.api.infra.security.DatosTokenJWT;
import com.medvoll.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService; // Servicio para generar el token JWT

    @Autowired
    private AuthenticationManager autenticationManager; // Autenticación de Spring Security

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid AutenticacionDTO datos) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var autenticacion = autenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));

    }
}
