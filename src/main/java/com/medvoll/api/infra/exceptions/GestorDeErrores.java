package com.medvoll.api.infra.exceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Esta anotación indica que esta clase manejará excepciones de controladores REST
public class GestorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex) {
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(datosErrorValidacion::new).toList());
    }

    // DTO para representar los errores de validación
    public record datosErrorValidacion(String campo, String mensaje){
        public datosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}
