package se.kth.sda6.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Get a list of all the tasks
    @RequestMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    // Get a specific task by it's id
    @RequestMapping("/tasks/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Create a task

}
