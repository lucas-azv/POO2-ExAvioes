package iftm.edu.br.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import iftm.edu.br.demo.domain.*;;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
    List<Fabricante> findByNomeContainingIgnoreCase(String nome);
}
