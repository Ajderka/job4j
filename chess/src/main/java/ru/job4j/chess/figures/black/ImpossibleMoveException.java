package ru.job4j.chess.figures.black;

public class ImpossibleMoveException extends Throwable {
    public ImpossibleMoveException(String s) {
        System.out.println("Ошибочка, " + s);
    }
}
