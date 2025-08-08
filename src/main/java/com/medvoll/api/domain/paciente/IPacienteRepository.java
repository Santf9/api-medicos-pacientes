package com.medvoll.api.domain.paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllByActivoTrue(Pageable paginacion);

    boolean findActivoById(Long idPaciente);
}
