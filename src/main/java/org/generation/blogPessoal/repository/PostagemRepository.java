package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>{

	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);//Findall seria equivalente ao SELECT. Containing equivalante ao LIKE e o Ignore Case faz ignorar o Case Sensitive
	
}
