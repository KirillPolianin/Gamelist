package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.haagahelia.course.domain.*;

@Controller
public class GameController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("game", new Game());
		return "index";
	}
	
}
