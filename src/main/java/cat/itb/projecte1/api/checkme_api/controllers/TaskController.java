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
public class TaskController {
    private final TaskService tasksService;

    @GetMapping ("/todoitems")
    public ResponseEntity<?> listTasksByList(@PathVariable TList idList) {
        List<Task> res = tasksService.listTasksByList(idList);
        if (res.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @GetMapping("/todoitems/{idItem}")
    public ResponseEntity<?> getTaskInList(@PathVariable String idItem, TList list) {
        Task res = tasksService.getTaskInList(idItem, list);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @PostMapping("/todoitems")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        Task res = tasksService.addTask(task);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/todoitems/{idItem}")
    public ResponseEntity<?> modifyTask(@PathVariable String idItem, @PathVariable TList idLlista) {
        Task res = tasksService.modifyTask(idItem, idLlista);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @DeleteMapping("/todoitems/{idItem}")
    public ResponseEntity<?> deleteTask(@PathVariable String idItem) {
        Task res = tasksService.deleteTask(idItem);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTasksByIdList(@PathVariable TList idList) {
        List<Task> res = tasksService.deleteTasksByIdList(idList);
        if (res.size() == 0) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }
}
