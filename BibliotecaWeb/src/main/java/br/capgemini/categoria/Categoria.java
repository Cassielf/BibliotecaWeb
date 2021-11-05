package br.capgemini.categoria;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	private Integer codigo;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	@Override
	public String toString() {
		return "Código categoria: "+ codigo +" nome: "+ nome;
	}
	
	

}
