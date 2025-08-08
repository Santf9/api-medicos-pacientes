package com.medvoll.api.domain.medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT m FROM Medico m
            WHERE m.activo = 1
            AND
            m.especialidad = :especialidad
            AND m.id NOT IN (
            SELECT c.medico.id FROM Consulta c
            WHERE c.fecha = :fecha
            )
            ORDER BY RAND()
            LIMIT 1
    """)
    Medico elegirMedicoAleatorioDisponibleFecha(Especialidad especialidad, LocalDateTime fecha);
}
