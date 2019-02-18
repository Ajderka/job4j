package ru.job4j.chess.figures.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        boolean ifTurn = false;
        if ((dest.x - source.x != 0 && dest.y - source.y == 0) || (dest.y - source.y != 0 && dest.x - source.x == 0)) {
            ifTurn = true;
            int size = dest.y == source.y ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
            steps = new Cell[size];
            int column = 8;
            int deltaX = Integer.compare(dest.x, source.x);
            int deltaY = Integer.compare(dest.y, source.y);
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * column + (source.y + deltaY * (index + 1))];
            }
        }
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            ifTurn = true;
            int size = Math.abs(dest.x - source.x);
            steps = new Cell[size];
            int deltaX = (dest.x - source.x) < 0 ? -1 : 1;
            int deltaY = (dest.y - source.y) < 0 ? -1 : 1;
            for (int index = 0; index < size; index++) {
                steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * 8 + (source.y + deltaY * (index + 1))];
            }
        }
        if (!ifTurn) {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
