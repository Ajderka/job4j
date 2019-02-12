package ru.job4j.chess.exception;

public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String wow) {
        System.out.println("Ошибочка, " + wow);
    }
}
