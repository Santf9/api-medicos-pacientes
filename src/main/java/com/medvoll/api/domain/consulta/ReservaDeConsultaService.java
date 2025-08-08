package com.medvoll.api.domain.consulta;
import com.medvoll.api.domain.ValidacionException;
import com.medvoll.api.domain.consulta.validaciones.ValidadorDeConsultas;
import com.medvoll.api.domain.medico.IMedicoRepository;
import com.medvoll.api.domain.medico.Medico;
import com.medvoll.api.domain.paciente.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaDeConsultaService {

    @Autowired
    private IConsultaRepository consultaRepository;

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    public void reservarConsulta(DatosReservaConsultaDTO datosReserva) {

        if (!pacienteRepository.existsById(datosReserva.idPaciente())) {
            throw new ValidacionException("ID de paciente no existe");
        }

        if (datosReserva.idMedico() != null && !medicoRepository.existsById(datosReserva.idMedico())) {
            throw new ValidacionException("ID de médico no existe");
        }

        var medico = elegirMedico(datosReserva);

        if (medico == null) {
            throw new ValidacionException("No existe un médico disponible en ese horario");
        }

        var paciente = pacienteRepository.findById(datosReserva.idPaciente()).get();

        var consulta = new Consulta(null, medico, paciente, datosReserva.fecha(), null);
        consultaRepository.save(consulta);

        // Validaciones
        validadores.forEach(v -> v.validar(datosReserva));
    }

    private Medico elegirMedico(DatosReservaConsultaDTO datosReserva) {
        if (datosReserva.idMedico() != null) {
            return medicoRepository.getReferenceById(datosReserva.idMedico());
        }
        if (datosReserva.especialidad() == null) {
            throw new ValidacionException("Debe especificar una especialidad o un médico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleFecha(datosReserva.especialidad(), datosReserva.fecha());

    }

    public void cancelarConsulta(DatosCancelamientoConsultaDTO datosCancelacion) {
        if (!consultaRepository.existsById(datosCancelacion.idConsulta())) {
            throw new ValidacionException("ID de consulta no existe");
        }

        var consulta = consultaRepository.getReferenceById(datosCancelacion.idConsulta());
        consulta.cancelar(datosCancelacion.motivo());

    }
}
