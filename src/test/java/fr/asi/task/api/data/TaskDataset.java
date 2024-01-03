package fr.asi.task.api.data;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskFormDto;
import fr.asi.task.api.model.Task;

public class TaskDataset {

    public static Task getTask() {
        Task task = new Task();
        task.setLabel("Label 2");
        task.setComplete(true);
        task.setId(2L);
        return task;
    }

    public static TaskDto getTaskDto() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(1L);
        taskDto.setComplete(false);
        taskDto.setLabel("Label 1");
        return taskDto;
    }

    public static TaskFormDto getTaskFormDto() {
        TaskFormDto taskFormDto = new TaskFormDto();
        taskFormDto.setLabel("Label 1");
        return taskFormDto;
    }


}
