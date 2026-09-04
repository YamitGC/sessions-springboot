package com.springboot.sesion01taskapi.repository;

import com.springboot.sesion01taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    // CREATE
    public Task save(Task task) {
        task.setId(nextId);
        nextId++;

        tasks.add(task);
        return task;
    }

    // READ: todas las tareas
    public List<Task> findAll() {
        return tasks;
    }

    // READ: una tarea por ID
    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    // UPDATE: cambiar estado a completada
    public Optional<Task> markAsCompleted(Long id) {
        Optional<Task> taskOptional = findById(id);

        taskOptional.ifPresent(task -> task.setCompleted(true));

        return taskOptional;
    }

    // DELETE
    public boolean deleteById(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}
