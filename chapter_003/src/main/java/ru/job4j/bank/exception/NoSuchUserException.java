package ru.job4j.bank.exception;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String massage) {
        super(massage);
    }
}
