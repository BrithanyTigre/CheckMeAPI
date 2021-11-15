package cat.itb.projecte1.api.checkme_api.model.services;

import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import cat.itb.projecte1.api.checkme_api.model.repositories.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ListRepository listRepository;

    // list the lists
    public List<TasksList> listLists() {
        return listRepository.findAll();
    }

    // get lists by id
    public TasksList getList(String id) {
        return listRepository.findById(id).orElse(null);
    }

    // add list
    public TasksList addList(TasksList it) {
        return listRepository.save(it);
    }

    // modify list, if exist it changes, id doesn't return null
    public TasksList modifyList(TasksList it) {
        TasksList aux = null;
        if (listRepository.existsById(it.getIdList()))
            aux = listRepository.save(it);
        return aux;
    }

    // delete list, if doesn't exist return null
    public TasksList deleteList(String id) {
        TasksList aux = listRepository.findById(id).orElse(null);
        if (aux != null)
            listRepository.deleteById(id);
        return aux;
    }
}