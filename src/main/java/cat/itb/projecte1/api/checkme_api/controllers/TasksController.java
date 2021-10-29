package cat.itb.projecte1.api.checkme_api.controllers;

import cat.itb.projecte1.api.checkme_api.model.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TasksController {
    private final TasksService tasksService;


}
