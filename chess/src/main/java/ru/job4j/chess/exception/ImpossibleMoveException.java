package ru.job4j.chess.exception;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String s) {
        System.out.println("Недопустимый ход фигуры, " + s);
    }
}
