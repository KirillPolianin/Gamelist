package fi.haagahelia.course;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Mode;
import fi.haagahelia.course.domain.ModeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ModeRepositoryTest {

	@Autowired
	private ModeRepository repository;
	
	@Test
	public void findByNameShouldReturnMode() {
		List<Mode> modes = repository.findByName("Single-player");
		
		assertThat(modes).hasSize(1);
	}
	
	@Test
	public void createNewMode() {
		Mode mode = new Mode("Ultra-player");
		repository.save(mode);
		
		assertThat(mode.getModeId()).isNotNull();
	}
	
	@Test
	public void deleteMode() {
		List<Mode> modes = repository.findByName("Single-player");
		repository.delete(modes.get(0).getModeId());
		
		assertFalse(repository.exists(modes.get(0).getModeId()));
	}

}
