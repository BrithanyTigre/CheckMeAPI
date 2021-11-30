package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import cat.itb.projecte1.api.checkme_api.model.services.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;
    private final TaskController taskController;


    @GetMapping("/todolists")
    public ResponseEntity<?> listLists() {
        List<TList> res = listService.listLists();
        if (res.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @PostMapping("/todolists")
    public ResponseEntity<?> addList(@RequestBody TList list) {
        TList res = listService.addList(list);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/todolists/{isLlista}")
    public ResponseEntity<?> modifyList(@RequestBody TList list) {
        TList res = listService.modifyList(list);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @DeleteMapping("/todolists/{idLlista}")
    public ResponseEntity<?> deleteList(@PathVariable Long idLlista) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            taskController.deleteTasksByIdList(res);
            res = listService.deleteList(idLlista);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> getListItems(@PathVariable Long idLlista) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.listTasksByList(res);
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems/{idTask}")
    public ResponseEntity<?> getListItem(@PathVariable Long idLlista, @PathVariable Long idTask) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.getTaskInList(idTask, res);
        }
    }

    @PostMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> addTaskInList(@PathVariable Long idLlista, @RequestBody Task task) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.addTask(task);
        }
    }

    @PutMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> modifyTaskInList(@PathVariable Long idLlista, @RequestBody Task task) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.modifyTask(task);
        }
    }

    @DeleteMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> deleteTaskInList(@PathVariable Long idLlista, @PathVariable Long idItem) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.deleteTask(idItem);
        }
    }
}
