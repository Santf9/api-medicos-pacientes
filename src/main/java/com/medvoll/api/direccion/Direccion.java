package com.medvoll.api.direccion;
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
    private String codigo_postal;
    private String ciudad;
    private String estado;

    public Direccion(DireccionDTO direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.barrio = direccion.barrio();
        this.codigo_postal = direccion.codigo_postal();
        this.ciudad = direccion.ciudad();
        this.estado = direccion.estado();
    }

    public void actualizarDireccion(DireccionDTO datos) {
        if (datos.calle() != null) {
            this.calle = datos.calle();
        }
        if (datos.numero() != null) {
            this.numero = datos.numero();
        }
        if (datos.barrio() != null) {
            this.barrio = datos.barrio();
        }
        if (datos.codigo_postal() != null) {
            this.codigo_postal = datos.codigo_postal();
        }
        if (datos.ciudad() != null) {
            this.ciudad = datos.ciudad();
        }
        if (datos.estado() != null) {
            this.estado = datos.estado();
        }
    }
}
