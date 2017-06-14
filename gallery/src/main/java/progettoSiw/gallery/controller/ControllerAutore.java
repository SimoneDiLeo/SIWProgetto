package progettoSiw.gallery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import progettoSiw.gallery.model.Autore;
import progettoSiw.gallery.service.AutoreService;

@Controller
public class ControllerAutore {

	@Autowired
	private AutoreService autoreService; 


	@GetMapping("/prendiAllAutore")
	public String tutteOpere(@Valid @ModelAttribute Autore autore, 
			BindingResult bindingResult, Model model) {
		Iterable<Autore> autori=this.autoreService.findAll();
		model.addAttribute("autori",autori);
		return "listaAutori";
	}

	@PostMapping("/autore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore Autore, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "formAutore";
		}
		else {
			model.addAttribute(Autore);
			autoreService.add(Autore); 
		}
		return "vistaAutore";
	}


	@GetMapping("/formRimozioneAutore")
	public String deleteAutore(Model model) {
		model.addAttribute("autori", this.autoreService.findAll());
		return "formRimozioneAutore";
	}
	
	@PostMapping("/rimuoviAutore")
	public String deleteAutore(Long id,Model model) {
		this.autoreService.rimuoviAutore(id);
		model.addAttribute("autori", this.autoreService.findAll());
		return "formRimozioneAutore";
	}
}
