package com.medvoll.api.infra.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.medvoll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") // Clave secreta para firmar el token, definida en application.properties
    private String secret;

    public String generarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret); // Clave secreta para firmar el token
            return JWT.create()
                    .withIssuer("API Vollmed") // Sistema que emite el token
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException e){
            throw new RuntimeException("Error al generar el token JWT", e);
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
