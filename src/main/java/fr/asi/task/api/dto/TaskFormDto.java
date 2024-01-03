package fr.asi.task.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskFormDto {
    @NotNull
    private String label;

    private boolean complete;
}
