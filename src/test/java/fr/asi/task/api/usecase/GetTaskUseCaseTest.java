package fr.asi.task.api.usecase;

import fr.asi.task.api.data.TaskDataset;
import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.exception.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetTaskUseCaseTest {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Autowired
    private GetTaskUseCase getTaskUseCase;

    @Test
    public void shouldThrowNotFoundException() {
        assertThrows(DataNotFoundException.class, () -> getTaskUseCase.execute(-1L));
    }


    @Test
    public void shouldGetTask() {
        TaskDto createdTask = createTaskUseCase.execute(TaskDataset.getTaskFormDto());

        TaskDto result = getTaskUseCase.execute(createdTask.getId());

        assertEquals("Label 1", result.getLabel());
        assertNotNull(result.getId());
        assertFalse(result.isComplete());
    }
}