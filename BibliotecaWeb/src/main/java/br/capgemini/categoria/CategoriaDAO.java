package br.capgemini.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

//qual a classe que será persistida, e qual o tipo da chave primaria dessa classe
//todas as modificacoes que serao gravadas em banco será mapeada e deve ter uma classe correspondente DAO
public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

	

}
