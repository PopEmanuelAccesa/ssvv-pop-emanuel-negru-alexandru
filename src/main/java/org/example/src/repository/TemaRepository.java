package org.example.src.repository;
import org.example.src.domain.*;
import org.example.src.validation.Validator;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

