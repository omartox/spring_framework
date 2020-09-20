package net.tox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.tox.model.Categoria;
import net.tox.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	//inyeccion de la clase servicio

	@Autowired
	//para seleccionar la implementacion
	//@Qualifier("categoriasServiceJPA")
	private ICategoriasService serviceCategorias;
	
	// @GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Categoria> lista= serviceCategorias.buscarTodas();
		
		model.addAttribute("categorias", lista);
		return "categorias/listCategorias";
	}

	// @GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}

	// @PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes ) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error:"+ error.getDefaultMessage());
			}
			return "categoria/formCategoria";
		}
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro guardado");
		return "redirect:/categorias/index";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
		System.out.println("Borrando Categoria con id: " + idCategoria);
		serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "La Categoria fue eliminada");
		return "redirect:/categorias/index";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") int idCategoria, Model modelo) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		
		System.out.println("Categoria:" + categoria);
		modelo.addAttribute("categoria", categoria);
		
		return "categorias/formCategoria";
	}
	
}
