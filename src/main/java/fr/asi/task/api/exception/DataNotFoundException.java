package fr.asi.task.api.exception;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DataNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_MESSAGE = "Resource %s not found for key %s";

    private final DataNotFoundResponse detail;

    public DataNotFoundException(Class<?> entity, Serializable key) {
        super(String.format(NOT_FOUND_MESSAGE, entity.getSimpleName(), key));
        detail = new DataNotFoundResponse();
        detail.setResourceName(entity.getSimpleName());
        detail.setIdentifier(key);
    }

}
