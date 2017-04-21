package fi.haagahelia.course;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Genre;
import fi.haagahelia.course.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GenreRepositoryTest {

	@Autowired
	private GenreRepository repository;
	
	@Test
	public void findByNameShouldReturnGenre() {
		List<Genre> genres = repository.findByName("Action-adventure");
		
		assertThat(genres).hasSize(1);
	}
	
	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Shooter");
		repository.save(genre);
		
		assertThat(genre.getGenreId()).isNotNull();
	}
	
	@Test
	public void deleteGenre() {
		List<Genre> genres = repository.findByName("Action-adventure");
		repository.delete(genres.get(0).getGenreId());
		
		assertFalse(repository.exists(genres.get(0).getGenreId()));
	}

}
