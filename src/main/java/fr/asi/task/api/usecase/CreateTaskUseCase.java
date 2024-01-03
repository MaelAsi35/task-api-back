package fr.asi.task.api.usecase;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import fr.asi.task.api.mapper.TaskMapper;
import fr.asi.task.api.model.Task;
import fr.asi.task.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * Creates a task
     *
     * @param form task attributes
     * @return created task
     */
    public TaskDto execute(TaskFormDto form) {
        Task task = new Task();
        task.setComplete(form.isComplete());
        task.setLabel(form.getLabel());
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }
}
