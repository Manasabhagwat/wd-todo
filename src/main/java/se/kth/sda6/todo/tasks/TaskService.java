package se.kth.sda6.todo.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private static List<Task> taskList = new ArrayList<>();
    static {
        taskList.add(new Task(1L, "name 1", "2020.01.01"));
        taskList.add(new Task(2L, "name 2", "2020.01.02"));
    }

    // Get a list of all the tasks
    public List<Task> getAll() {
        return taskList;
    }

    // Get a specific task by it's id
    public Optional<Task> getById(Long id) {
        return taskList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }
}
