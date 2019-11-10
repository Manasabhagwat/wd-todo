package se.kth.sda6.todo.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static Long idCounter = 1L;
    private static List<Task> taskList = new ArrayList<>();
    static {
        add(new Task(null, "name 1", "2020.01.01"));
        add(new Task(null, "name 2", "2020.01.02"));
    }

    // Get a list of all the tasks
    public List<Task> getAll(String sort) {
        return taskList.stream()
                .sorted(Comparator.comparing(sort.equals("name") ? Task::getName : Task::getDate))
                .collect(Collectors.toList());
    }

    // Get a specific task by it's id
    public Optional<Task> getById(Long id) {
        return taskList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Task create(Task newTask) {
        add(newTask);
        return newTask;
    }

    static private boolean add(Task newTask) {
        newTask.setId(idCounter);
        idCounter++;
        return taskList.add(newTask);
    }

    public void delete(Long id) {
        taskList = taskList.stream()
                .filter(t -> !t.getId().equals(id))
                .collect(Collectors.toList());
    }
}
