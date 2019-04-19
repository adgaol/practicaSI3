package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Controller {
	@RequestMapping("/")
	public String buscador2(Model model) {

		

		return "index";
	}
}
