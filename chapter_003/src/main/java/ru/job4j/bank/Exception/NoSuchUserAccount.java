package ru.job4j.bank.Exception;

public class NoSuchUserAccount extends RuntimeException {

    public NoSuchUserAccount(String massage) {
        super(massage);
    }
}
