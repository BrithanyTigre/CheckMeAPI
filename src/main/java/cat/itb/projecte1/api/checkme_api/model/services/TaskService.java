package cat.itb.projecte1.api.checkme_api.model.services;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import cat.itb.projecte1.api.checkme_api.model.repositories.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TasksRepository tasksRepository;

    public List<Task> listTasks() {
        return tasksRepository.findAll();
    }

    // list tasks
    public List<Task> listTasksByList(TasksList idList){
        return tasksRepository.findAllByIdTasksList(idList);
    }

    // get task by id
    public Task getTask(String id){
        return tasksRepository.findById(id).orElse(null);
    }

    public Task getTaskInList(String id, TasksList list) {
        return tasksRepository.findByIdTaskAndIdTasksList(id, list);
    }

    // add task
    public Task addTask(Task it){
        return tasksRepository.save(it);
    }

    // modify task, if exist it changes, if doesn't return null
    public Task modifyTask(Task it){
        Task aux = null;
        if (tasksRepository.existsById(it.getIdTask()))
            aux = tasksRepository.save(it);
        return aux;
    }

    // delete task, if doesn't exist return null
    public Task deleteTask(String id){
        Task aux = tasksRepository.findById(id).orElse(null);
        if (aux != null)
            tasksRepository.deleteById(id);
        return aux;
    }
}
