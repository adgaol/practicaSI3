package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ControllerPrincipal {
	@RequestMapping("/uihuihuhuihih")
	public String buscador2(Model model) {

		

		return "index.php";
	}
}
