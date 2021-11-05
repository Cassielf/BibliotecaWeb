package br.capgemini.categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	private List<Categoria> lista = new ArrayList<Categoria>();
	
	//a anotacao abaixo faz a injecao do objeto sem precisar instanciar
	@Autowired
	private CategoriaDAO categoriaDAO;	

	//@modelAttribute serve para fazer a ligação do model para a view e assim mandar a lista de categorias para o html
	@ModelAttribute("categorias")
	public List<Categoria> getLista (){
		return this.categoriaDAO.findAll(Sort.by("nome"));
	}
	
	
	@ModelAttribute("enum_situacao")
	public Situacao[] getEnumSituacao() {
		return Situacao.values();
	}
	
	
	@GetMapping("/listarCategorias")
	public String listarCategorias() {
		return "listar_categorias";
	}
	
	@GetMapping("/categoria")
	public String exibirCategoria(Categoria categoria) {
		return "cadastrar_categoria";
	}
	
	@PostMapping("/salvarCategoriaObj")
	public String cadastrarCategoria(Categoria categoria) {
		this.lista.add(categoria);
		System.out.println(categoria);
		this.categoriaDAO.save(categoria);
		return "index";
	}
	
	@GetMapping("/exibirCategoria")
	public String exibirCategoria(Integer codigo, Model model) {
		Optional<Categoria> cat = this.categoriaDAO.findById(codigo);
		model.addAttribute("categoria",cat);
		return"cadastrar_categoria";
		
	}
	
	@GetMapping("/excluirCategoria")
	public String excluirCategoria(Integer codigo) {
		this.categoriaDAO.deleteById(codigo);
		return "redirect:/listarCategorias";

	}
	
	
}
