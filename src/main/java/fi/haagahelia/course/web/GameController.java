package fi.haagahelia.course.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//Show login page
	@RequestMapping(value="/login")
	public String login() {	
		return "login";
	}
	
	//Show all games
	@RequestMapping(value = "/gamelist", method = RequestMethod.GET)
	public String showGames(Model model) {
		List<Game> games = (List<Game>) repository.findAll();
		model.addAttribute("games", games);
		return "gamelist";
	}
	
	//RESTful service to get all games
	@RequestMapping(value="/games", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest() {
		return (List<Game>) repository.findAll();
	}
	
	//RESTful service to get game by id
	@RequestMapping(value="/game/{id}", method = RequestMethod.GET)
	public @ResponseBody Game findGameRest(@PathVariable("id") Long gameId) {
		return repository.findOne(gameId);
	}
	
	//Add new game
	@RequestMapping(value = "/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("modes", mRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		return "addgame";
	}
	
	//Save added game
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Game game) {
		repository.save(game);
		return "redirect:gamelist";
	}
	//Delete game
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.delete(gameId);
		return "redirect:../gamelist";
	}
	//Edit game record
	@RequestMapping(value = "/edit/{id}")
	public String editGame(@PathVariable("id") Long gameId, Model model) {
		model.addAttribute("game", repository.findOne(gameId));
		model.addAttribute("modes", mRepository.findAll());
		model.addAttribute("genres", gRepository.findAll());
		return "editgame";
	}
	
}
