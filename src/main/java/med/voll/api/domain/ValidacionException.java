package med.voll.api.domain;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {

        // Se pasa el parametro mensaje al padre que esta heredando (RuntimeException)
        super(mensaje);

    }
}
