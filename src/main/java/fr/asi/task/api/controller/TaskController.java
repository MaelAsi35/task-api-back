package fr.asi.task.api.controller;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import fr.asi.task.api.dto.TaskSearchDto;
import fr.asi.task.api.usecase.CreateTaskUseCase;
import fr.asi.task.api.usecase.GetTaskUseCase;
import fr.asi.task.api.usecase.SearchTaskUseCase;
import fr.asi.task.api.usecase.UpdateTaskUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private GetTaskUseCase getTaskUseCase;
    @Autowired
    private SearchTaskUseCase searchTaskUseCase;
    @Autowired
    private CreateTaskUseCase createTaskUseCase;
    @Autowired
    private UpdateTaskUseCase updateTaskUseCase;

    @GetMapping
    public Page<TaskDto> search(Pageable page, TaskSearchDto searchTaskDto) {
        return searchTaskUseCase.execute(page, searchTaskDto);
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        return getTaskUseCase.execute(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto create(@RequestBody @Valid TaskFormDto form) {
        return createTaskUseCase.execute(form);
    }

    @PutMapping("/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody @Valid TaskFormDto form) {
        return updateTaskUseCase.execute(id, form);
    }
}