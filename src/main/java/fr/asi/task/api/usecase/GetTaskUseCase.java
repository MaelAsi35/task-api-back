package fr.asi.task.api.usecase;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.exception.DataNotFoundException;
import fr.asi.task.api.mapper.TaskMapper;
import fr.asi.task.api.model.Task;
import fr.asi.task.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTaskUseCase {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * Gets a task by its id
     *
     * @param id task's id
     * @return the task found, else throw not found exception
     */
    public TaskDto execute(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new DataNotFoundException(Task.class, id));
        return taskMapper.toDto(task);
    }
}
