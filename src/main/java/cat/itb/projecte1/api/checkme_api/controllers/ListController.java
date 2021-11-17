package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import cat.itb.projecte1.api.checkme_api.model.services.ListService;
import cat.itb.projecte1.api.checkme_api.model.services.TaskService;
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
    private final TaskService taskService;

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
    public ResponseEntity<?> deleteList(@PathVariable String idLlista) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            taskService.deleteTasksByList(res);
            res = listService.deleteList(idLlista);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> deleteAllTasksInList(@PathVariable String idLlista) {
        TList res = listService.getList(idLlista);
        if (res == null){
            return ResponseEntity.notFound().build();
        } else {
            return taskController.deleteTasksByIdList(res);
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> getListItems(@PathVariable String idLlista) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.listTasksByList(res);
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems/{idTask}")
    public ResponseEntity<?> getListItem(@PathVariable String idLlista, @PathVariable String idTask) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.getTaskInList(idTask, res);
        }
    }

    @PostMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> addTaskInList(@PathVariable String idLlista, @RequestBody Task task) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.addTask(task);
        }
    }

    @PutMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> modifyTaskInList(@PathVariable String idLlista, @RequestBody Task task) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.modifyTask(task);
        }
    }

    @DeleteMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> deleteTaskInList(@PathVariable String idLlista, @PathVariable String idItem) {
        TList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return taskController.deleteTask(idItem);
        }
    }
}
