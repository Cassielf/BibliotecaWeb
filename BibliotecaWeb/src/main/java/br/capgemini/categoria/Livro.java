package br.capgemini.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String titulo;
	private String autores;
	//Anotacoes de relacionamento=> deve seguir o MER!!
	//1(classe)-1(atributo) | 1(livro) - N(categorias) | N(livros) - 1(categoria) | N(livros) - N(categorias)| qual usar?
	@ManyToOne
	private Categoria categoria;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
