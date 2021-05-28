package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long>{ //Tema e a entity que o Jparepository vai mapear, e o Long eh o tipo de dado do seu ID

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
