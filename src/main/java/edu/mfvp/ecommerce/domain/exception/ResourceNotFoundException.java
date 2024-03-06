package edu.mfvp.ecommerce.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found. Id " + id);
    }
}
