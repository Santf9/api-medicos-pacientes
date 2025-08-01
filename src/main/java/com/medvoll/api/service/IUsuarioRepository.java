package com.medvoll.api.service;

import com.medvoll.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
