package br.com.etechoracio.ingressos.repository;

import br.com.etechoracio.ingressos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Aluno, Long> {
}
