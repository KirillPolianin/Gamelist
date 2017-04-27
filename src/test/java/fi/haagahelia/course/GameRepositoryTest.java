package fi.haagahelia.course;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Game;
import fi.haagahelia.course.domain.GameRepository;
import fi.haagahelia.course.domain.GenreRepository;
import fi.haagahelia.course.domain.ModeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GameRepositoryTest {

	@Autowired
	private GameRepository repository;
	
	@Autowired
	private ModeRepository mRepository;
	
	@Autowired
	private GenreRepository gRepository;
	
	@Test
	public void findByTitleShouldReturnGame() {
		List<Game> games = repository.findByTitle("Mafia III");
		
		assertThat(games).hasSize(1);
		assertThat(games.get(0).getYear()).isEqualTo(2016);
	}
	
	@Test
	public void createNewGame() {
		Game game = new Game("Grand Theft Auto V", 2013, "Rockstar Games", gRepository.findByName("Action-adventure").get(0), mRepository.findByName("Single-player & Multiplayer").get(0), 10, "Really good game!");
		repository.save(game);
		
		assertThat(game.getId()).isNotNull();
	}
	
	@Test
	public void deleteGame() {
		List<Game> games = repository.findByTitle("Mafia III");
		repository.delete(games.get(0).getId());
		
		assertFalse(repository.exists(games.get(0).getId()));
	}

}
