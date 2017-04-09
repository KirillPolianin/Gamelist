package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.GameRepository;
import fi.haagahelia.course.domain.Game;

@SpringBootApplication
public class GamelistApplication {
	private static final Logger log = LoggerFactory.getLogger(GamelistApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GamelistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository repository) {
		return (args) -> {
				log.info("save a couple of games");
				repository.save(new Game("The Witcher 3: Wild Hunt", 2015, "CD Projekt", "Action role-playing", "Single-player", 10));
				repository.save(new Game("Mafia III", 2016, "2K Games", "Action-adventure", "Single-player", 8));
				
				log.info("fetch all games");
				for(Game game : repository.findAll()) {
					log.info(game.toString());
				}
		};
	}
	
}
