package com.medvoll.api.domain.usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Genera automáticamente los métodos getter para los campos de la clase
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // Genera automáticamente el metodo equals y hashCode basándose en el campo id

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String contrasena;

}
