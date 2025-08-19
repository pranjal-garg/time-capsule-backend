package com.example.demo.exception;

public class CapsuleNotFoundException extends CapsuleException {
    public CapsuleNotFoundException(int id) {
        super("Capsule with id " + id + " not found");
    }
}
