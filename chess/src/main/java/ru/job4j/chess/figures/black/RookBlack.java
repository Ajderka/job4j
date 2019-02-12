package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int size = dest.y == source.y ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[size];
        int column = 8;
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        if (!straightLine(source, dest)) {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * column + (source.y + deltaY * (index + 1))];
        }
        return steps;
    }

    private boolean straightLine(Cell source, Cell dest) {
        boolean temp = false;
        if ((dest.x - source.x != 0 && dest.y - source.y == 0) || (dest.y - source.y != 0 && dest.x - source.x == 0)) {
            temp = true;
        }
        return temp;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
