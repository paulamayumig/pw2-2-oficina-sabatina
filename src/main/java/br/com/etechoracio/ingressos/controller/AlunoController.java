package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Aluno;
import br.com.etechoracio.ingressos.repository.AlunoRepository;
import br.com.etechoracio.ingressos.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno>  listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        var aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            return ResponseEntity.ok(aluno.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno){
        aluno = alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }


    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno novoAluno){
        var aluno = alunoRepository.findById(id);
        if (aluno.isPresent()){
            novoAluno.setId(aluno.get().getId());

            novoAluno =alunoRepository.save(novoAluno);
        }
        return novoAluno;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
