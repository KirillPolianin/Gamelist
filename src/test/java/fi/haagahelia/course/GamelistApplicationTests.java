package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.web.GameController;
import fi.haagahelia.course.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamelistApplicationTests {

	@Autowired
	private GameController gameController;
	
	@Autowired
	private UserController userController;
	
	@Test
	public void gameContextLoads() throws Exception {
		assertThat(gameController).isNotNull();
	}
	
	@Test
	public void userContextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}
}
