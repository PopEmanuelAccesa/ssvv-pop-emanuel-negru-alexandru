package org.example.src.repository;
import org.example.src.domain.*;
import org.example.src.validation.Validator;


public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}
