package com.medvoll.api.domain.paciente;

import com.medvoll.api.domain.direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Genera automáticamente los métodos getter para los campos de la clase
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // Genera automáticamente el metodo equals y hashCode basándose en el campo id
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Embedded
    private Direccion direccion;

    public Paciente(PacienteDTO datos) {
        this.id = null; // El ID se generará automáticamente al guardar en la base de datos
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarDatos(@Valid ActualizarPacienteDTO datos) {
        if(datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if(datos.telefono() != null) {
            this.telefono = datos.telefono();
        }
        if(datos.direccion() != null) {
            this.direccion.actualizarDireccion(datos.direccion());
        }
    }

    public void eliminar() {
        this.activo = false; // Cambia el estado a inactivo en lugar de eliminar físicamente
    }
}
