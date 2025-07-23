package com.medvoll.api.medico;
import com.medvoll.api.direccion.Direccion;
import com.medvoll.api.direccion.DireccionDTO;
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
@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(MedicoDTO datos) {
        this.id = null; // El ID se generará automáticamente al guardar en la base de datos
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarDatos(@Valid ActualizarMedicoDTO datos) {
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
