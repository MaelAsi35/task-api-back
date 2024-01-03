package fr.asi.task.api.usecase;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import fr.asi.task.api.exception.DataNotFoundException;
import fr.asi.task.api.mapper.TaskMapper;
import fr.asi.task.api.model.Task;
import fr.asi.task.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * Updates a task
     *
     * @param id   task's id
     * @param form task's attributes to update
     * @return updated task
     */
    public TaskDto execute(Long id, TaskFormDto form) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new DataNotFoundException(Task.class, id));
        task.setComplete(form.isComplete());
        task.setLabel(form.getLabel());
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }
}
