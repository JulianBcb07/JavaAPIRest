package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionNoReservarPacientesInactivos implements ValidadorDeConsultas {

    /* El sistema no debe permitir que pacientes inactivos puedan agendar una consulta.
        Por el contrario, mostrará una excepción para alertar al usuario.
     */

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosReservaConsulta datos) {

        var pacienteEstaActivo = pacienteRepository.findActivoById(datos.idPaciente());
        if(!pacienteEstaActivo) {
            throw new ValidacionException("Consuilta no puede ser reservado con paciente inactivo");
        }

    }

}
