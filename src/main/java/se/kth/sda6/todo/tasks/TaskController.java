package se.kth.sda6.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Get a list of all the tasks
    @GetMapping("")
    public List<Task> getAll(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) Long projectId) {
        if (sort == null) {
            sort = "name";
        }

        if (projectId == null) {
            return taskService.getAll(sort);
        } else {
            return taskService.getAllByProjectId(projectId);
        }
    }

    // Get a specific task by it's id
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Create a task
    @PostMapping("")
    public Task create(@RequestBody Task newTask) {
        return taskService.create(newTask);
    }

    @PutMapping("")
    public Task update(@RequestBody Task updatedTask) {
        return taskService.update(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
