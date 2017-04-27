package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.*;

@SpringBootApplication
public class GamelistApplication {
	private static final Logger log = LoggerFactory.getLogger(GamelistApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GamelistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository repository, ModeRepository mRepository, GenreRepository gRepository, UserRepository uRepository) {
		return (args) -> {
				log.info("save a couple of games");
				mRepository.save(new Mode("Single-player"));
				mRepository.save(new Mode("Multiplayer"));
				mRepository.save(new Mode("Single-player & Multiplayer"));
				mRepository.save(new Mode("Other"));
				
				
				gRepository.save(new Genre("Action"));
				gRepository.save(new Genre("Action-adventure"));
				gRepository.save(new Genre("Action role-playing"));
				gRepository.save(new Genre("MMO"));
				gRepository.save(new Genre("Role-playing"));
				gRepository.save(new Genre("Simulation"));
				gRepository.save(new Genre("Strategy"));
				gRepository.save(new Genre("Vehicle simulation"));
				gRepository.save(new Genre("Other"));
				
				repository.save(new Game("The Witcher 3: Wild Hunt", 2015, "CD Projekt", gRepository.findByName("Action role-playing").get(0), mRepository.findByName("Single-player").get(0), 10, "The Witcher® 3: Wild Hunt is a story-driven, next-generation open world role-playing game, set in a visually stunning fantasy universe, full of meaningful choices and impactful consequences."));
				repository.save(new Game("Mafia III", 2016, "2K Games", gRepository.findByName("Action-adventure").get(0), mRepository.findByName("Single-player").get(0), 8, "Mafia III is an action-adventure game played in a third-person perspective, in which players assume control of Lincoln Clay, a Vietnam War veteran on a quest to seek revenge for his adopted family, who are murdered by local mobs."));
				
				//Create users: admin/admin user/user
				User user1 = new User("user", "$2a$04$0PlVXAirwljrXF25dNrtOei8DAxHstJ1EC1zMPogDiWy0QfJboW2a", "USER");
				User user2 = new User("admin", "$2a$04$ocb9ABQ1MkyUTyGKBcGev.BcL1J1yAsPqIzHXe5FN8Ce9L2bravf6", "ADMIN");
				uRepository.save(user1);
				uRepository.save(user2);
				
				log.info("fetch all games");
				for(Game game : repository.findAll()) {
					log.info(game.toString());
				}
		};
	}
	
}
