# Sesión 02 - API de tareas en memoria

API REST de tareas creada con Spring Boot para practicar validación de datos y manejo global de errores, sin base de datos.

## Conceptos practicados

- Arquitectura por capas: Controller, Service y Repository.
- Inversión de Control (IoC) e inyección de dependencias por constructor.
- DTOs con `record`.
- Validación con Bean Validation: `@Valid`, `@NotBlank` y `@Size`.
- Manejo global de excepciones con `@RestControllerAdvice`.
- Respuestas de error consistentes.
- Pruebas de integración con `MockMvc`.
- Almacenamiento temporal con `List<Task>`.

## Tecnologías

- Java 21
- Spring Boot
- Maven
- JUnit 5
- MockMvc

## Requisitos

- JDK 21
- Git
- Postman, opcionalmente

## Ejecución

Desde la carpeta del proyecto:

```bash
./mvnw spring-boot:run
