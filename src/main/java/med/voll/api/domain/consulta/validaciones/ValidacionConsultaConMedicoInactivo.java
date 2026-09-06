package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Anotacion que spring reconoce: un componente generico que necesitamos que spring cargue
@Component
public class ValidacionConsultaConMedicoInactivo implements ValidadorDeConsultas {

    /* El sistema debe evitar que se creen consultas con un médico que ya no está activo.
        Cuando esto suceda, el sistema debe enviar una excepción para alertar al usuario.
     */

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosReservaConsulta datos) {

        // eleccion del medico opcional
        if(datos.idMedico() == null) {
            return;
        }

        var medicoEstaActivo = medicoRepository.findActivoById(datos.idMedico());
        if(!medicoEstaActivo) {
            throw new ValidacionException("Consulta no puede ser reservada con medico inactivo");
        }

    }

}
