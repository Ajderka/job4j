package ru.job4j.bank.Exception;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String massage) {
        super(massage);
    }
}
