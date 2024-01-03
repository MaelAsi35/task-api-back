package fr.asi.task.api.mapper;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}
