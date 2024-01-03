package fr.asi.task.api.mapper;

import fr.asi.task.api.data.TaskDataset;
import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.model.Task;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskMapperTest {

    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    @Test
    public void toEntity_whenMaps_thenCorrect() {
        TaskDto taskDto = TaskDataset.getTaskDto();
        taskDto.setId(1L);
        taskDto.setComplete(false);
        taskDto.setLabel("Label 1");

        Task task = taskMapper.toEntity(taskDto);

        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getLabel(), task.getLabel());
        assertEquals(taskDto.isComplete(), task.isComplete());
    }

    @Test
    public void toDto_whenMaps_thenCorrect() {
        Task task = TaskDataset.getTask();

        TaskDto taskDto = taskMapper.toDto(task);

        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getLabel(), taskDto.getLabel());
        assertEquals(task.isComplete(), taskDto.isComplete());
    }
}