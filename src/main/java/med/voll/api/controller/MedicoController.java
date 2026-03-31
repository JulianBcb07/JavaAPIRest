package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListaMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // ayuda a crear la instancia con el repository
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {
        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nombre"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListaMedico::new);
    }

}
