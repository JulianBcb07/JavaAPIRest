package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas {

/* Regla de negocio:
    El sistema debe permitir agendar una consultar con al menos 30 minutos de anticipación,
    de lo contrario el sistema mandará una excepción.
 */

    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if(diferenciaEnMinutos < 30) {
            throw new ValidacionException("Horario seleccionado menor a 30 minutos de anticipacion");
        }
    }


}
