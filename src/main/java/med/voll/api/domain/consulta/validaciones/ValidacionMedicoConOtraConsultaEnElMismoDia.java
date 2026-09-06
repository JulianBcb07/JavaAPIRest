package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionMedicoConOtraConsultaEnElMismoDia implements ValidadorDeConsultas {

    /* Validacion que alerta que indica que no se puede reservar una consulta con un médico que
    ya tiene otra consulta reservada en la misma fecha y hora.
    */

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {

        var MedicoConOtraConsulta = consultaRepository.existsByMedicoIdAndFecha(datos.idMedico(),datos.fecha());

        if(MedicoConOtraConsulta) {
            throw new ValidacionException("No se puede reservar la consulta porque el medico tiene otra consulta");
        }
    }


}
