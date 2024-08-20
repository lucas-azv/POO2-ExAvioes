package iftm.edu.br.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import iftm.edu.br.demo.domain.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Integer> {
    List<Aviao> findByNomeContainingIgnoreCase(String nome);
}
