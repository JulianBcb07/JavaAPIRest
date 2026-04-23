package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;
import org.apache.logging.log4j.message.Message;

public record DatosRegistroMedico(

@NotBlank String nombre,
@NotBlank @Email String email,
@NotBlank String telefono,
@NotBlank @Pattern(regexp = "\\d{7,9}") String documento,
@NotNull Especialidad especialidad,
@NotNull @Valid DatosDireccion direccion
) {
}

/*
* Una clase record incluye los getters y setters de una clase normal en java, recomendado para mapear los datos de una
* entidad y convertirlos a un objeto java
* */