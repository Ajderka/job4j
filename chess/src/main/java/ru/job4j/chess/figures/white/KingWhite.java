package ru.job4j.chess.figures.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite implements Figure {
    private final Cell position;

    public KingWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if (isRightTurn(source, dest)) {
            steps = new Cell[]{dest};
        } else {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int stepX = source.x;
        int stepY = source.y;
        stepX += deltaX;
        stepY += deltaY;
        steps[0] = this.findPosition(stepX, stepY);
        return steps;
    }

    private Cell findPosition(int x, int y) {
        Cell[] temp = Cell.values();
        Cell result = null;
        for (Cell cell : temp) {
            if (x == cell.x && y == cell.y) {
                result = cell;
                break;
            }
        }
        return result;
    }

    private boolean isRightTurn(Cell source, Cell dest) {
        boolean result = false;
        if (source.y == dest.y && (Math.abs(dest.x - source.x) == 1)
                || source.x == dest.x && (Math.abs(dest.y - source.y) == 1)) {
            result = true;
        }
        if ((Math.abs(dest.x - source.x) == 1) && (Math.abs(dest.y - source.y) == 1)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
