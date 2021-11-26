package com.github.DanielleSantiago.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.DanielleSantiago.biblioteca.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
