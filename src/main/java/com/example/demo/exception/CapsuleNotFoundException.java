package com.example.demo.exception;

public class CapsuleNotFoundException extends CapsuleException {
    CapsuleNotFoundException(int id) {
        super("Capsule with id " + id + " not found");
    }
}
