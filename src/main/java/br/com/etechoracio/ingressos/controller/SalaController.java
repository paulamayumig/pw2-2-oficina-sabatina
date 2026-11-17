package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Professor;
import br.com.etechoracio.ingressos.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private List<Long> idsExistentes = new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L));
    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Professor> listar() { return salaRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id){
        var sala = salaRepository.findById(id);
        if(sala.isPresent()) {
            return ResponseEntity.ok(sala.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Professor> cadastrar(@RequestBody Professor sala){
        sala = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    } // inserção de sala


    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@RequestBody Professor sala,
                                               @PathVariable Long id) {
        if (!salaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        if (sala.getPreco() <= 0 || sala.getNome() == null) {
            return ResponseEntity.badRequest().build();
        }

        sala.setId(id);
        sala = salaRepository.save(sala);

        return ResponseEntity.ok(sala);
    }// atualizar sala por ID

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
