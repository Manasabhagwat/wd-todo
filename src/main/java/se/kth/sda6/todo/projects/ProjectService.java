package se.kth.sda6.todo.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Optional<Project> getById(Long id) {
        return repository.findById(id);
    }

    public Project create(Project newProject) {
        return repository.save(newProject);
    }

    public Project update(Project updatedProject) {
        return repository.save(updatedProject);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
