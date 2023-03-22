package org.example.src.repository;

import org.example.src.domain.*;
import org.example.src.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

