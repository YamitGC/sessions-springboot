package com.springboot.sesion01taskapi.service;

import com.springboot.sesion01taskapi.model.Task;
import com.springboot.sesion01taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
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

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> completeTask(Long id) {
        return taskRepository.markAsCompleted(id);
    }

    public boolean deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }
}

