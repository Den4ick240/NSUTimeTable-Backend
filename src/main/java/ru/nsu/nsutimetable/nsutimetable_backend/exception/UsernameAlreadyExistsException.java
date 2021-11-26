package ru.nsu.nsutimetable.nsutimetable_backend.exception;

public class UsernameAlreadyExistsException extends TableException {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
