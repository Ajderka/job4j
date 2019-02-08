package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

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
    public Cell[] way(Cell source, Cell dest) {

        int size = sizeTurn(source, dest);
        Cell[] steps = new Cell[size];
        int column = 8;
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);

        for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[(source.x + deltaX * (index + 1)) * column + (source.y + deltaY * (index + 1))];
        }
        return steps;
    }

    private int sizeTurn(Cell source, Cell dest) {
        int size = -1;
        if (dest.x != source.x && dest.y == source.y) {
            size = Math.abs(dest.x - source.x);
        }
        if (dest.y != source.y && dest.x == source.x) {
            size = Math.abs(dest.y - source.y);
        }
        return size;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
