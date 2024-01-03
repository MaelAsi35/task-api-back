package fr.asi.task.api.usecase;

import fr.asi.task.api.data.TaskDataset;
import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SearchTaskUseCaseTest {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @Autowired
    private SearchTaskUseCase searchTaskUseCase;


    @Test
    public void shouldSearchTask() {
        List<TaskDto> taskDtos = IntStream.range(0, 4).mapToObj(operand -> createTaskUseCase.execute(TaskDataset.getTaskFormDto())).toList();

        TaskSearchDto taskSearchDto = new TaskSearchDto();

        Pageable pageable = PageRequest.of(0, 5);
        Page<TaskDto> result = searchTaskUseCase.execute(pageable, taskSearchDto);

        assertNotNull(result);
        assertEquals(4, result.getTotalElements());
        assertEquals(1, result.getTotalPages());
        assertEquals(taskDtos, result.getContent());
    }
}