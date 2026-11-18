package br.com.etechoracio.ingressos.repository;

import br.com.etechoracio.ingressos.entity.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OficinaRepository extends JpaRepository<Oficina, Long> {
}
