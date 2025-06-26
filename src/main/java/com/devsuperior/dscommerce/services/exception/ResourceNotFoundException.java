package com.devsuperior.dscommerce.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Resource not found Id " + id);
    }
}
