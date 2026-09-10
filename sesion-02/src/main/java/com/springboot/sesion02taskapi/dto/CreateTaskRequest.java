package com.springboot.sesion02taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(

        @NotBlank(message = "El título es obligatorio")
        @Size(max = 100, message = "El titulo no puede superar los 100 caracteres")
        String title

) {
}
