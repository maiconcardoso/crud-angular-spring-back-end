package com.maicon.crud_spring.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Long id) {
        super("Record not found for id: " + id);
    }
}
