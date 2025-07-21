package com.medvoll.api.medico;
import com.medvoll.api.direccion.Direccion;
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
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(MedicoDTO datos) {
        this.id = null; // El ID se generará automáticamente al guardar en la base de datos
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }
}
