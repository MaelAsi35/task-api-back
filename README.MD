# TaskAPI

This project is a simple task management application.

SpringBoot version: 3.2.1
JDK 17

there are 4 available endpoints :

- search
- getById
- create
- update

You can get them with Swagger, accessible at http://localhost:8080/swagger-ui/index.html#/

A task is declared like this:

    private Long id;

    private String label;

    private boolean complete = false;

To run the project, launch the springboot application class: TaskApiApplication

the server will be available at http://localhost:8080

Before that you must run a mvn [clean, install] to build mappers
