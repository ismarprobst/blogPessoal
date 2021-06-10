package org.generation.blogPessoal.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class usuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Usuario usuario;
	//private Usuario usuarioUpd;
	
	@BeforeAll
	public void start() {
		
		usuario = new Usuario ("Maria","maria777","44455182");
		
		//usuarioUpd = new Usuario ("Maria Joaquina","maria777","12345Batata");
	}
	
	@Test
	public void deveCadastrarUsuarios() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario> (usuario);
		
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		
	}
	
	
	// O teste do método de logar ainda está em criacao.
	@Test
	public void deveLogarUsuarios() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario> (usuario);
		
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("maria777", "44455182").exchange("/usuarios/logar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		/*ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode()); */
		
	}
	
	
}
