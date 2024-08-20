package iftm.edu.br.demo.controller;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import iftm.edu.br.demo.domain.Fabricante;
import iftm.edu.br.demo.repository.FabricanteRepository;

import java.util.*;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
    private FabricanteRepository fabricanteRepository;

    public FabricanteController(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> getAllFabricantes() {
        List<Fabricante> fabricantes = fabricanteRepository.findAll();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getFabricanteById(@PathVariable Integer id) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        return fabricante.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Fabricante>> getFabricantesByNome(@RequestParam String nome) {
        List<Fabricante> fabricantes = fabricanteRepository.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(fabricantes);
    }

    @PostMapping
    public ResponseEntity<Fabricante> createFabricante(@RequestBody Fabricante fabricante) {
        Fabricante novoFabricante = fabricanteRepository.save(fabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> updateFabricante(@PathVariable Integer id, @RequestBody Fabricante fabricante) {
        if (!fabricanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fabricante.setId(id);
        Fabricante fabricanteAtualizado = fabricanteRepository.save(fabricante);
        return ResponseEntity.ok(fabricanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Integer id) {
        if (!fabricanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fabricanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}