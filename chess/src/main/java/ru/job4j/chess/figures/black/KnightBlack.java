package ru.job4j.chess.figures.black;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (isTurnRight(source, dest)) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }
        return steps;
    }

    private boolean isTurnRight(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2) {
            result = true;
        }
        if (Math.abs(dest.y - source.y) == 1 && Math.abs(dest.x - source.x) == 2) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
