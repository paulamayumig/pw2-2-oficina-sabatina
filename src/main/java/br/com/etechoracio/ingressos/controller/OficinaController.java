package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Oficina;
import br.com.etechoracio.ingressos.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/oficinas")
public class
OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping
    public ResponseEntity<List<Oficina>>  listar() {
        return ResponseEntity.ok(oficinaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> buscarPorId(@PathVariable Long id){
        var oficina = oficinaRepository.findById(id);
        if (oficina.isPresent()){
            return ResponseEntity.ok(oficina.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Oficina> cadastrar(@RequestBody Oficina oficina){
       oficina.setTotalInscritos(0);
       oficina.setLotada(false);

       oficina = oficinaRepository.save(oficina);

       return ResponseEntity.status(HttpStatus.CREATED).body(oficina);
    }


    @PutMapping("/{id}")
    public Oficina atualizar(@PathVariable Long id, @RequestBody Oficina novaOficina){
        var oficina = oficinaRepository.findById(id);
        if (oficina.isPresent()){
            novaOficina.setId(oficina.get().getId());

            novaOficina =oficinaRepository.save(novaOficina);
        }
        return novaOficina;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(oficinaRepository.existsById(id)) {
            oficinaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
