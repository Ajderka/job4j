package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.exception.ImpossibleMoveException;

public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaY = Math.abs(source.y - dest.y);
        int deltaX = Math.abs(source.x - dest.x);
        int size = deltaX >= deltaY ? deltaX : deltaY;
        Cell[] steps = new Cell[size];
        if (deltaX != deltaY && source.x != dest.x && source.y != dest.y || ((source.x == dest.x) && (source.y == dest.y))) {
            throw new ImpossibleMoveException(this.getClass().getSimpleName());
        }
        deltaX = Integer.compare(dest.x, source.x);
        deltaY = Integer.compare(dest.y, source.y);
        int stepX = source.x;
        int stepY = source.y;
        for (int i = 0; i < steps.length; i++) {
            stepX += deltaX;
            stepY += deltaY;
            steps[i] = this.findPosition(stepX, stepY);
        }
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

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }
}
