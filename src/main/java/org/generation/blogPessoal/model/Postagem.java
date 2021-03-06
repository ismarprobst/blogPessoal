package org.generation.blogPessoal.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity // indica que a classe sera uma entidade do JPA Hibernate
@Table(name = "postagem") // indica que essa entidade, dentro do banco de dados ira virar uma tabela.
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //ira gerar o valor, o identity identifica a PK
	private long id;
	
	@NotNull //n permite valor nulo
	@Size (min = 5, max = 100) // define o tamanho que ira aceitar
	private String titulo;
	
	@NotNull
	@Size(min = 10,max = 500)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP) // informa ao hibernate que e um dado de tempo. Argumento indica o tipo
	private Date date = new java.sql.Date(System.currentTimeMillis()); // Assim q passar um metodo por essa classe, ele captura o exato momento que isso ocorre
	
	@ManyToOne //Anotacao que faz a ligacao com model Tema. Informa que sao varias POSTAGENS para um TEMA
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
