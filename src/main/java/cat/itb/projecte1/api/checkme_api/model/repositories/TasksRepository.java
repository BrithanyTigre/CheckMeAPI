package cat.itb.projecte1.api.checkme_api.model.repositories;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, String>{
    List<Task> findAllByIdList(TList idList);
    Task findTaskByIdTaskAndIdList(String idItem, TList idList);
    void deleteAllByIdList(TList idList);
//    @Query(value = "SELECT * from Task where idTask = ?1 and idList = ?2", nativeQuery = true)
//    Task findByIdTaskAndIdList(String idTask, TasksList idList);
}
