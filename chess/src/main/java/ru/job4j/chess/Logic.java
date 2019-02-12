package ru.job4j.chess;

import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest)  {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигурой топчитесь на месте");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (!this.isFree(steps)) {
            throw new OccupiedWayException("На пути фигуры припятствие");
        }
        if (steps.length > 0) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }


    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
