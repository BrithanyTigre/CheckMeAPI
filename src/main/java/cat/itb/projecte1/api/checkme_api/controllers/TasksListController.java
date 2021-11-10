package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import cat.itb.projecte1.api.checkme_api.model.services.TasksListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TasksListController {
    private final TasksListService listService;

    @GetMapping("/todolists")
    public List<TasksList> listLists() {
        return listService.listLists();
    }

    @GetMapping("/todolists/{idLlista}")
    public ResponseEntity<?> getList(@PathVariable String idLlista) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

}
