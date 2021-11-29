package cat.itb.projecte1.api.checkme_api.model.services;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import cat.itb.projecte1.api.checkme_api.model.repositories.ListRepository;
import cat.itb.projecte1.api.checkme_api.model.repositories.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TasksRepository tasksRepository;

    // list tasks by List
    public List<Task> listTasksByList(TList idList){
        return tasksRepository.findAllByIdList(idList);
    }

    // get a task by in a list by ID List and ID Task
    public Task getTaskInList(Long id, TList list) {
        return tasksRepository.findTaskByIdTaskAndIdList(id, list);
    }

    // add task
    public Task addTask(Task it){
        return tasksRepository.save(it);
    }

    // modify if task is done, if esxits changes the boolean, if doesn't returns null
    public Task modifyTask(Long id, TList idList){
        Task aux = tasksRepository.findTaskByIdTaskAndIdList(id, idList);
        if (aux != null) {
            aux.setDone(!aux.isDone());
            tasksRepository.save(aux);
        }
        return aux;
    }

    // delete task, if doesn't exist return null
    public Task deleteTask(Long id){
        Task aux = tasksRepository.findById(id).orElse(null);
        if (aux != null)
            tasksRepository.deleteById(id);
        return aux;
    }

    // delete tasks by ID List
    public List<Task> deleteTasksByIdList(TList idList) {
        List<Task> aux = listTasksByList(idList);
        if (aux.size() != 0)
            tasksRepository.deleteTasksByIdList(idList);
        return aux;

    }
}
