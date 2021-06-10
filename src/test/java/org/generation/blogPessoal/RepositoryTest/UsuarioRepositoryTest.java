package org.generation.blogPessoal.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	public void start() {
		Usuario usuario = new Usuario("Vagner Boaz","VagnerBoaz", "134652");
		if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);

		usuario = new Usuario("Lucas Boaz","LucasBoaz", "134652");
		if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);

		usuario = new Usuario("MarceloBoaz","MarceloBoaz", "134652");
		if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null)
			usuarioRepository.save(usuario);

	}
	
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception {
		
		Usuario usuario = usuarioRepository.findByUsuario("VagnerBoaz").get();
		assertTrue(usuario.getUsuario().equals("VagnerBoaz"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}
