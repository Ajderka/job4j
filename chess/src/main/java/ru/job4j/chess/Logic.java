package ru.job4j.chess;

import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Class Logic.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 18.02.2019.
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        this.figures[this.index++] = figure;
    }

    /**
     * Method move - определяет возможность хода фигуры.
     *
     * @return true если фигура найдена и ей ничего не мешает.
     */
    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, OccupiedWayException, ImpossibleMoveException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена");
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

    public Integer findBy(Cell cell) {
        return IntStream.range(0, this.figures.length)
                .filter(i -> this.figures[i] != null && this.figures[i].position().equals(cell)).boxed()
                .findFirst().orElse(-1);
    }
}