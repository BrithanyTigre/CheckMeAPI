package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
import cat.itb.projecte1.api.checkme_api.model.services.TaskService;
import cat.itb.projecte1.api.checkme_api.model.services.TasksListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TasksListController {
    private final TasksListService listService;
    private final TaskController taskService;

    @GetMapping("/todolists")
    public List<TasksList> listLists() {
        return listService.listLists();
    }

    @PostMapping("/todolists")
    public ResponseEntity<?> addList(@RequestBody TasksList list) {
        TasksList res = listService.addList(list);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/todolists/{isLlista}")
    public ResponseEntity<?> modifyList(@RequestBody TasksList list) {
        TasksList res = listService.modifyList(list);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @DeleteMapping("/todolists/{idLlista}")
    public ResponseEntity<?> deleteList(@PathVariable String idLlista) {
        TasksList res = listService.deleteList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> getListItems(@PathVariable String idLlista) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.listTasksByList(res));
        }
    }

    @GetMapping("/todolists/{idLlista}/todoitems/{idTask}")
    public ResponseEntity<?> getListItem(@PathVariable String idLlista, @PathVariable String idTask) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.getTaskInList(idTask, res));
        }
    }

    @PostMapping("/todolists/{idLlista}/todoitems")
    public ResponseEntity<?> addTaskInList(@PathVariable String idLlista, @RequestBody Task task) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.addTask(task));
        }
    }

    @PutMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> modifyTaskInList(@PathVariable String idLlista, @RequestBody Task task) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.modifyTask(task));
        }
    }

    @DeleteMapping("/todolists/{idLlista}/todoitems/{idItem}")
    public ResponseEntity<?> deleteTaskInList(@PathVariable String idLlista, @PathVariable String idItem) {
        TasksList res = listService.getList(idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(taskService.deleteTask(idItem));
        }
    }
}
