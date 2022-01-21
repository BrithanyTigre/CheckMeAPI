package cat.itb.projecte1.api.checkme_api.model.services;

import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import cat.itb.projecte1.api.checkme_api.model.repositories.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListService {
    private final ListRepository listRepository;

    // list the lists
    public List<TList> listLists() {
        return listRepository.findAll();
    }

    // get lists by id
    public TList getList(Long id) {
        return listRepository.findById(id).orElse(null);
    }

    // add list
    public TList addList(TList it) {
        return listRepository.save(it);
    }

    // modify list, if exist it changes, id doesn't return null
    public TList modifyList(TList it) {
        TList aux = null;
        if (listRepository.existsById(it.getIdList()))
            aux = listRepository.save(it);
        return aux;
    }

    // delete list, if doesn't exist return null
    public TList deleteList(Long id) {
        TList aux = listRepository.findById(id).orElse(null);
        if (aux != null)
            listRepository.deleteById(id);
        return aux;
    }
}
