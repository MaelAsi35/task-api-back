package fr.asi.task.api.controller;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import fr.asi.task.api.dto.TaskSearchDto;
import fr.asi.task.api.usecase.CreateTaskUseCase;
import fr.asi.task.api.usecase.GetTaskUseCase;
import fr.asi.task.api.usecase.SearchTaskUseCase;
import fr.asi.task.api.usecase.UpdateTaskUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@Tag(name = "Task", description = "The Task API")
public class TaskController {
    @Autowired
    private GetTaskUseCase getTaskUseCase;
    @Autowired
    private SearchTaskUseCase searchTaskUseCase;
    @Autowired
    private CreateTaskUseCase createTaskUseCase;
    @Autowired
    private UpdateTaskUseCase updateTaskUseCase;

    @Operation(
            summary = "Search tasks",
            description = "fetches tasks with given filters from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping
    public Page<TaskDto> search(Pageable page, TaskSearchDto searchTaskDto) {
        return searchTaskUseCase.execute(page, searchTaskDto);
    }

    @Operation(
            summary = "Fetch a task",
            description = "fetch a task by its id from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Data not found")
    })
    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        return getTaskUseCase.execute(id);
    }

    @Operation(
            summary = "Create a task",
            description = "Create and save a task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully created")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto create(@RequestBody @Valid TaskFormDto form) {
        return createTaskUseCase.execute(form);
    }

    @Operation(
            summary = "Update a task",
            description = "Update a task with its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody @Valid TaskFormDto form) {
        return updateTaskUseCase.execute(id, form);
    }
}