package progettoSiw.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/loginAmministratore")
	public String login() {
		return "loginAmministratore";
	}

	@RequestMapping("/loginAmministratore?error")
	public String loginError(Model model) {
		model.addAttribute("error", true);
		return "loginAmministratore";
	}
}
