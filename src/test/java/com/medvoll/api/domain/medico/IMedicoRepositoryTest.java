package com.medvoll.api.domain.medico;
import com.medvoll.api.domain.consulta.Consulta;
import com.medvoll.api.domain.direccion.DireccionDTO;
import com.medvoll.api.domain.paciente.Paciente;
import com.medvoll.api.domain.paciente.PacienteDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantener la configuración de la base de datos real
@ActiveProfiles("test") // Usar el perfil de prueba
class IMedicoRepositoryTest {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Deberia devolver null cuando el medico buscado existe pero no esta disponible en esa fecha")
    void elegirMedicoAleatorioDisponibleFechaEscenario1() {
        var lunesSiguienteALas10 = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .withHour(10)
                .withMinute(0)
                .withSecond(0);

        var medico = registrarMedico("medico1", "medico@gmail.com", "12345678", Especialidad.CARDIOLOGIA);
        var paciente = registrarPaciente("paciente1", "paciente@gmail.com", "87654321");
        registrarConsulta(medico, paciente, lunesSiguienteALas10);


        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);
        assertThat(medicoLibre).isNull();
    }

    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha, null));
    }

    private Medico registrarMedico(String nombre, String email, String docuemento, Especialidad especialidad) {
        var medico = new Medico(datosMedico(nombre, email, docuemento, especialidad));
        em.persist(medico);
        return medico;
    }

    private Paciente registrarPaciente(String nombre, String email, String docuemento) {
        var paciente = new Paciente(datosPaciente(nombre, email, docuemento));
        em.persist(paciente);
        return paciente;
    }

    private MedicoDTO datosMedico(String nombre, String email, String documento, Especialidad especialidad) {
        return new MedicoDTO(
                nombre,
                email,
                "12345678",
                documento,
                especialidad,
                datosDireccion()
        );
    }

    private PacienteDTO datosPaciente(String nombre, String email, String documento) {
        return new PacienteDTO(
                nombre,
                email,
                "1234564",
                documento,
                datosDireccion()
        );
    }

    private DireccionDTO datosDireccion() {
        return new DireccionDTO(
                "Calle Falsa",
                "123",
                "Ciudad",
                "5699",
                "1",
                "Estado"
        );
    }
}