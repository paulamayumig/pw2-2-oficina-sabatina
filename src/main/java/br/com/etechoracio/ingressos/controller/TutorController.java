package br.com.etechoracio.ingressos.controller;


import br.com.etechoracio.ingressos.entity.Tutor;
import br.com.etechoracio.ingressos.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tutor")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping
    public List<Tutor>  listar() {
        return tutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id){
        var tutor = tutorRepository.findById(id);
        if (tutor.isPresent()){
            return ResponseEntity.ok(tutor.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tutor> cadastrar(@RequestBody Tutor tutor){
        tutor = tutorRepository.save(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutor);
    }


    @PutMapping("/{id}")
    public Tutor atualizar(@PathVariable Long id, @RequestBody Tutor novoTutor){
        var oficina = tutorRepository.findById(id);
        if (oficina.isPresent()){
            novoTutor.setId(oficina.get().getId());

            novoTutor =tutorRepository.save(novoTutor);
        }
        return novoTutor;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(tutorRepository.existsById(id)) {
            tutorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
