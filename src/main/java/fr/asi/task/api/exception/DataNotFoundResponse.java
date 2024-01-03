package fr.asi.task.api.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

    @Setter
    @Getter
    public class DataNotFoundResponse {

        private String resourceName;
        private Serializable identifier;

        public DataNotFoundResponse() {
        }
}
