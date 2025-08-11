package com.medvoll.api.domain.medico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Mantener la configuración de la base de datos real
@ActiveProfiles("test") // Usar el perfil de prueba
class IMedicoRepositoryTest {

    @Test
    void elegirMedicoAleatorioDisponibleFecha() {
    }
}