package cat.itb.projecte1.api.checkme_api.model.services;

import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import cat.itb.projecte1.api.checkme_api.model.repositories.TasksListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksListService {
    private final TasksListRepository tasksListRepository;

    // list the lists
    public List<TasksList> listLists() {
        return tasksListRepository.findAll();
    }

    // get lists by id
    public TasksList getList(String id) {
        return tasksListRepository.findById(id).orElse(null);
    }

    // add list
    public TasksList addList(TasksList it) {
        return tasksListRepository.save(it);
    }

    // modify list, if exist it changes, id doesn't return null
    public TasksList modifyList(TasksList it) {
        TasksList aux = null;
        if (tasksListRepository.existsById(it.getIdList()))
            aux = tasksListRepository.save(it);
        return aux;
    }

    // delete list, if doesn't exist return null
    public TasksList deleteList(String id) {
        TasksList aux = tasksListRepository.findById(id).orElse(null);
        if (aux != null)
            tasksListRepository.deleteById(id);
        return aux;
    }
}
