package se.kth.sda6.todo.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return projectService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping("")
    public Project create(@RequestBody Project newProject) {
        return projectService.create(newProject);
    }

    @PutMapping("")
    public Project update(@RequestBody Project updatedProject) {
        return projectService.update(updatedProject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}
