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
import progettoSiw.gallery.model.Opera;
import progettoSiw.gallery.service.OperaService;



@Controller
public class ControllerOpera {
	

    @Autowired
    private OperaService operaService; 
    
	@PostMapping("/opera")
    public String checkOperaInfo(@Valid @ModelAttribute Opera Opera, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
        	model.addAttribute(Opera);
            operaService.add(Opera); 
        }
        return "operaInserita";
    }
	
	@GetMapping("/prendiAllopera")
    public String tutteOpere(@Valid @ModelAttribute Opera opera, 
    									BindingResult bindingResult, Model model) {
		Iterable<Opera> opere=this.operaService.findAll();
    	model.addAttribute("opere",opere);
        return "listaOpere";
    }
	
	@GetMapping("/prendiAutoreOpera")
    public String operaAutore(@Valid @ModelAttribute Opera opera, 
    									BindingResult bindingResult, Model model) {
		
		Autore autore=this.operaService.findAutoreOpera(opera.getId());
		model.addAttribute("autore",autore);
        return "autoreInserito";
    }
	
	
	
	
	
	
	
	
}
