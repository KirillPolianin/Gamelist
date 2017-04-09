package fi.haagahelia.course.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.haagahelia.course.domain.*;

@Controller
public class GameController {
	@Autowired
	private GameRepository repository;
	@Autowired
	private ModeRepository mRepository;
	@Autowired
	private GenreRepository gRepository;
	
	@RequestMapping(value = "/gamelist", method = RequestMethod.GET)
	public String hello(Model model) {
		List<Game> games = (List<Game>) repository.findAll();
		model.addAttribute("games", games);
		return "gamelist";
	}
	
	@RequestMapping(value = "/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("modes", mRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		return "addgame";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Game game) {
		repository.save(game);
		return "redirect:gamelist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.delete(gameId);
		return "redirect:../gamelist";
	}
	
}
