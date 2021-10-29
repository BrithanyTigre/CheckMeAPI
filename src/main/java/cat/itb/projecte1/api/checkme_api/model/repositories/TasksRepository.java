package cat.itb.projecte1.api.checkme_api.model.repositories;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, String>{
}
