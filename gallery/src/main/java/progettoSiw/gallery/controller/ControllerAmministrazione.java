<<<<<<< HEAD
package progettoSiw.gallery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import progettoSiw.gallery.model.Autore;
import progettoSiw.gallery.service.AutoreService;
import progettoSiw.gallery.service.OperaService;


@Controller
public class ControllerAmministrazione {

	@Autowired
	private AutoreService autoreService;
	

	@GetMapping("/formAutore")
    public String formAutore(Model model) {
		return "formAutore";
    }
	
	@GetMapping("/formOpera")
    public String formOpera( Model model) {
		Iterable<Autore> autori=this.autoreService.findAll();
    	model.addAttribute("autori",autori);
        return "formOpera";
    }
	
	@GetMapping("/formRimozione")
    public String formRimozione(Model model) {
		//TODO reindirizzamento e modello da mettere a disp
		Iterable<Autore> autori=this.autoreService.findAll();
    	model.addAttribute("autori",autori);
        return "listaAutori";
    }
}
=======
package progettoSiw.gallery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import progettoSiw.gallery.model.Autore;
import progettoSiw.gallery.model.Opera;
import progettoSiw.gallery.service.AutoreService;


@Controller
public class ControllerAmministrazione {

	@Autowired
	private AutoreService autoreService;
	

	@GetMapping("/formAutore")
    public String formAutore(Autore autore) {
		return "formAutore";
    }
	
	@GetMapping("/formOpera")
    public String formOpera(Opera opera,Model model) {
		Iterable<Autore> autori=this.autoreService.findAll();
    	model.addAttribute("autori",autori);
        return "formOpera";
    }
	
	@GetMapping("/formRimozione")
    public String formRimozione(Model model) {
		//TODO reindirizzamento e modello da mettere a disp
		Iterable<Autore> autori=this.autoreService.findAll();
    	model.addAttribute("autori",autori);
        return "listaAutori";
    }
}
>>>>>>> refs/remotes/origin/master
