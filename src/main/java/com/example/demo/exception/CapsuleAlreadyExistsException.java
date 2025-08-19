package com.example.demo.exception;

public class CapsuleAlreadyExistsException extends CapsuleException {
    public CapsuleAlreadyExistsException(int id) {
        super("Capsule with id " + id + " already exists");
    }
}