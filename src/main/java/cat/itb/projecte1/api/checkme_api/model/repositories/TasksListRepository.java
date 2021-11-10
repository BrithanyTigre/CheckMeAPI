package cat.itb.projecte1.api.checkme_api.model.repositories;

import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksListRepository extends JpaRepository<TasksList, String> {
}
