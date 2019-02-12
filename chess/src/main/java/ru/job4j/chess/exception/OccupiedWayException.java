package ru.job4j.chess.exception;

public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String s) {
        System.out.println("Ошибочка, " + s);
    }
}
