package med.voll.api.medico;

import med.voll.api.direccion.Direccion;

public record DatosRegistroMedico(

String nombre,
String email,
String telefono,
String documento,
Especialidad especialidad,
Direccion direccion
) {
}

/*
* Una clase record incluye los getters y setters de una clase normal en java, recomendado para mapear los datos de una
* entidad y convertirlos a un objeto java
* */