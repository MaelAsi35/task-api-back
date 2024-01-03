package fr.asi.task.api.usecase;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateUseCaseTest {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Test
    public void shouldSaveTask() {
        TaskFormDto taskFormDto = new TaskFormDto();
        taskFormDto.setLabel("Label 1");

        TaskDto result = createTaskUseCase.execute(taskFormDto);

        assertEquals("Label 1", result.getLabel());
        assertNotNull(result.getId());
        assertFalse(result.isComplete());
    }
}
