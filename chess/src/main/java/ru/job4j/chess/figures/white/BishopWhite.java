package ru.job4j.chess.figures.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {

        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) < 0 ? -1 : 1;
        int deltaY = (dest.y - source.y) < 0 ? -1 : 1;
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))];
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean temp = false;
        if ((Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) && ((source.x != dest.x) && (source.y != dest.y))) {
            temp = true;
        }
        return temp;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
