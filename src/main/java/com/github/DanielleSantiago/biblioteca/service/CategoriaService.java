package com.github.DanielleSantiago.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.github.DanielleSantiago.biblioteca.domain.Categoria;
import com.github.DanielleSantiago.biblioteca.dtos.CategoriaDTO;
import com.github.DanielleSantiago.biblioteca.repositories.CategoriaRepository;
import com.github.DanielleSantiago.biblioteca.service.exceptions.DataIntegrityViolationException;
import com.github.DanielleSantiago.biblioteca.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.github.DanielleSantiago.biblioteca.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados.");
		}
	}

}
