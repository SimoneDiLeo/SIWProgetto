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
import progettoSiw.gallery.service.AutoreService;
import progettoSiw.gallery.service.OperaService;



@Controller
public class ControllerOpera {
	

    @Autowired
    private OperaService operaService; 
    @Autowired
	private AutoreService autoreService;
    
  @PostMapping("/opera")
    public String checkOperaInfo(@Valid @ModelAttribute Opera Opera, 
    									BindingResult bindingResult, Model model,Long id) {
    	
	  if (bindingResult.hasErrors()) {
        	Iterable<Autore> autori=this.autoreService.findAll();
        	model.addAttribute("autori",autori);
            return "formOpera";
        }
        else {
        	Autore findbyId = this.autoreService.findbyId(id);
			Opera.setAutore(findbyId);
        	findbyId.getOpere().add(Opera);
        	model.addAttribute(Opera);
            operaService.add(Opera); 
        }
        return "vistaOpera";
    }
	
	@GetMapping("/prendiAllopera")
    public String tutteOpere(@Valid @ModelAttribute Opera opera, 
    									BindingResult bindingResult, Model model) {
		Iterable<Opera> opere=this.operaService.findAll();
    	model.addAttribute("opere",opere);
        return "listaOpere";
    }
	
	
	@GetMapping("/formRimozioneOpera")
	public String deleteAutore(Model model) {
		model.addAttribute("opere", this.operaService.findAll());
		return "formRimozioneOpera";
	}	
	
	@PostMapping("/rimuoviOpera")
	public String deleteAutore(Long id,Model model) {
		this.operaService.rimuoviOpera(id);
		model.addAttribute("opere", this.operaService.findAll());
		return "formRimozioneOpera";
	}
	
}
