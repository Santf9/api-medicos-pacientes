package com.medvoll.api.infra.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Esta anotación habilita la configuración de seguridad e indica que esta clase realizará cambios
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter; // Inyecta el filtro de seguridad personalizado

    @Bean // Anotación para indicar que el metodo devuelve un bean que será administrado por Spring Security
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()) // Deshabilita la protección CSRF (Cross-Site Request Forgery)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la política de sesión como sin estado
                .authorizeHttpRequests(req -> req
                        .requestMatchers(HttpMethod.POST,"/login").permitAll() // Permite el acceso a los endpoints de usuarios sin autenticación
                        .anyRequest().authenticated()) // Requiere autenticación para cualquier otra solicitud
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Añade el filtro de seguridad personalizado antes de los filtros de autenticación)
                .build(); // Construye el filtro de seguridad

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager(); // Obtiene el administrador de autenticación de la configuración proporcionada
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Crea un codificador de contraseñas utilizando BCrypt, que es un algoritmo de hashing seguro
    }
}
