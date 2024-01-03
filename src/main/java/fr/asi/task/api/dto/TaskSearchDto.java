package fr.asi.task.api.dto;

import lombok.Data;

@Data
public class TaskSearchDto {
    
    private Boolean complete;

    private String label;
}
