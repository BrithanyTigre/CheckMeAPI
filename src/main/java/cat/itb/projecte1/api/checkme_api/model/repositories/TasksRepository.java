package cat.itb.projecte1.api.checkme_api.model.repositories;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, String>{
    List<Task> findAllByIdList(TasksList idList);
//    Task findByIdTaskAndIdList(String idItem, TasksList idList);
    @Query(value = "SELECT * from Task where idTask = ?1 and idList = ?2", nativeQuery = true)
    Task findByIdTaskAndIdList(String idTask, TasksList idList);
}
