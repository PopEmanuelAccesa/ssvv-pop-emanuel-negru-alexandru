package org.example.src.validation;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}