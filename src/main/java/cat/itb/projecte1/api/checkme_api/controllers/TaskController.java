package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.entities.Task;
import cat.itb.projecte1.api.checkme_api.model.entities.TasksList;
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

    @GetMapping("/todoitems")
    public List<Task> listTasksByList(@PathVariable TasksList idList) {
        return tasksService.listTasksByList(idList);
    }

    @GetMapping("/todoitems/{id}")
    public ResponseEntity<?> getTaskInList(@PathVariable String id, TasksList list) {
        Task res = tasksService.getTaskInList(id, list);
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

    @PutMapping("/todoitems/{id}")
    public ResponseEntity<?> modifyTask(@RequestBody Task task) {
        Task res = tasksService.modifyTask(task);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(res);
        }
    }

    @DeleteMapping("todoitems/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        Task res = tasksService.deleteTask(id);
        if (res == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
    }
}
