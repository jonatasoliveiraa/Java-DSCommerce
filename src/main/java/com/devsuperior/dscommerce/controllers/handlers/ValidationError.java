package com.devsuperior.dscommerce.controllers.handlers;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError {

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessage(fieldName, message));
    }
}
