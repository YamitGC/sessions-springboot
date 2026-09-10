package com.springboot.sesion02taskapi.exception;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id){
        super("No existe una tarea con el id: " + id);
    }
}
