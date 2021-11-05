package br.capgemini.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private LivroDAO livroDAO;
	
	@GetMapping("/cadLivros")
	public String exibirCadastroLivros(Livro livro, Model model) {
		model.addAttribute("lista_categ", 
				this.categoriaDAO.findAll(Sort.by("nome")));
		
		model.addAttribute("lista_livros", this.livroDAO.findAll());
		
		return "cadastrar_livro";
	}

	@PostMapping("/salvarLivro")
	public String salvarLivro(Livro livro) {
		 livroDAO.save(livro);
		 return "index";
	}
	
	@GetMapping("/exibirLivro")
	public String exibirLivro(Integer codigo, Model model) {
		Optional<Livro> liv = this.livroDAO.findById(codigo);
		model.addAttribute("livro",liv);
		
		model.addAttribute("lista_categ", 
				this.categoriaDAO.findAll(Sort.by("nome")));
		
		model.addAttribute("lista_livros", this.livroDAO.findAll());
		
		return "cadastrar_livro";
	}
	
	
	@GetMapping("/excluirLivro")
	public String excluirLivro(Integer codigo, Model model) {
		this.livroDAO.deleteById(codigo);
		return "redirect:/cadLivros";
	}
	
}
