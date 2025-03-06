package com.example.Livro.service;

import com.example.Livro.model.Livro;
import com.example.Livro.model.StatusReserva;
import com.example.Livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setQuantidadePaginas(livroAtualizado.getQuantidadePaginas());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public Livro atualizarStatus(Long id, StatusReserva status) {
        return livroRepository.findById(id).map(livro -> {
            livro.setStatusReserva(status);
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
    }

    public List<Livro> buscarPorStatus(StatusReserva statusReserva) {
        return livroRepository.findByStatusReserva(statusReserva);
    }

}
