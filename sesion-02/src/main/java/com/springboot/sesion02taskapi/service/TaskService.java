package com.springboot.sesion02taskapi.service;

import com.springboot.sesion02taskapi.exception.TaskNotFoundException;
import com.springboot.sesion02taskapi.model.Task;
import com.springboot.sesion02taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        Task task = new Task(null, title.trim(), false);

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task completeTask(Long id) {
        return taskRepository.markAsCompleted(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void deleteTask(Long id) {
        boolean wasDeleted = taskRepository.deleteById(id);

        if (!wasDeleted) {
            throw new TaskNotFoundException(id);
        }
    }

}
