package com.medvoll.api.direccion;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // Genera automáticamente los métodos getter para los campos de la clase
@NoArgsConstructor
@AllArgsConstructor
@Embeddable // Importa la anotación Embeddable para indicar que esta clase puede ser embebida en otra entidad
public class Direccion {

    private String calle;
    private String numero;
    private String barrio;
    @Column(nullable = false) // Asegura que el campo codigoPostal no puede ser nulo en la base de datos
    private String codigoPostal;
    private String ciudad;
    private String estado;

    public Direccion(DireccionDTO direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.barrio = direccion.barrio();
        this.codigoPostal = direccion.codigoPostal();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
    }
}
