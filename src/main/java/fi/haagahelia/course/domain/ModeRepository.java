package fi.haagahelia.course.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ModeRepository extends CrudRepository<Mode, Long>{
	List<Mode> findByName(String name);
}
