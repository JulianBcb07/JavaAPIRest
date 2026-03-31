package med.voll.api.paciente;

public record DatosListaPaciente(
        String nombre,
        String email,
        String documento_identidad
) {

    public DatosListaPaciente(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumentoIdentidad()
        );
    }

}
