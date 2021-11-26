package com.github.DanielleSantiago.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.DanielleSantiago.biblioteca.domain.Categoria;
import com.github.DanielleSantiago.biblioteca.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> objOptional = repository.findById(id);
		return objOptional.orElse(null);
	}
}
