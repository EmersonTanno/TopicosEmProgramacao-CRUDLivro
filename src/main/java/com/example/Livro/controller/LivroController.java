package com.example.Livro.controller;

import com.example.Livro.model.Livro;
import com.example.Livro.model.StatusReserva;
import com.example.Livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Optional<Livro> livro = livroService.buscarPorId(id);
        return livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.status(201).body(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        try {
            Livro livro = livroService.atualizarLivro(id, livroAtualizado);
            return ResponseEntity.ok(livro);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        livroService.deletarLivro(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Livro> atualizarStatus(@PathVariable Long id, @RequestParam StatusReserva status) {
        try {
            Livro livro = livroService.atualizarStatus(id, status);
            return ResponseEntity.ok(livro);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
