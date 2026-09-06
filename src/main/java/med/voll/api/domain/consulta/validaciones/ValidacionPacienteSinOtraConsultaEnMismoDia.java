package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionPacienteSinOtraConsultaEnMismoDia implements ValidadorDeConsultas {

    /* El sistema debe validar que un paciente no tenga otra consulta en el mismo dia,
        por regla de negocio de la clinica.
    * */

    // Ahora que usamos una anotacion que spring reconoce (component) entonces ya podemos usar el Autowired
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if(pacienteTieneOtraConsultaEnElDia) {
            throw new ValidacionException("Paciente ya tiene una consulta reservada para ese dia");
        }
    }

}
