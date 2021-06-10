package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Preencher com o nome.")
	@Size(min = 2, max = 100)
	private String nome;
	
	@NotNull(message = "Preencher com um nome de usuario valido de 5 a 100 caracteres.")
	@Size(min = 5, max = 100)
	private String usuario;
	
	@NotNull(message = "Preencher com uma senha de 5 a 100 caracteres.")
	@Size(min = 5, max = 100)
	private String senha;

	// Criados construtores para fazer testes JUnit
	public Usuario() {}
	
	public Usuario(String nome, String usuario, String senha) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
