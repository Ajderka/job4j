package ru.job4j.bank.exception;

public class NoSuchUserAccount extends RuntimeException {

    public NoSuchUserAccount(String massage) {
        super(massage);
    }
}