package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionFueraHorarioConsultas implements ValidadorDeConsultas {

    /* El sistemas debo evitar que pacientes agenden una consulta fuera del horaio laboral.
        7 hrs - 19 hrs. El sistema debe emitir una excepción cuando se intente agendar antes de las
        7 hrs o después de las 19 hrs.
     */

    public void validar(DatosReservaConsulta datos) {

        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeApertura = fechaConsulta.getHour() < 7;
        var horarioDespuesDeCierreClinica = fechaConsulta.getHour() > 18;
        if(domingo || horarioAntesDeApertura || horarioDespuesDeCierreClinica) {
            throw new ValidacionException("Horario seleccionado fuera de horario laboral");
        }
    }

}
