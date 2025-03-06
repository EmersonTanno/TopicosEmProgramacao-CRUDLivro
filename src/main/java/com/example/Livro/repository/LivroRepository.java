package com.example.Livro.repository;

import com.example.Livro.model.Livro;
import com.example.Livro.model.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByStatusReserva(StatusReserva statusReserva);
}
