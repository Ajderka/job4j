package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * Class Пазлы. Тестовое задание.[#91044]
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 24.12.2018.
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
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

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Method isWin - определяет комбинацию пазлов при которой, игрокодерживает победу.
     *
     * @return true если комбинация выиграшная, false если игра продолжается.
     */
    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        int numberOfCoincidencesR = 0;
        int numberOfCoincidencesC = 0;
        for (int convertRow = 0; convertRow != table.length; convertRow++) {
            for (int convertCell = 0; convertCell != table.length - 1; convertCell++) {
                if (table[convertRow][convertCell] != 0 && table[convertRow][convertCell] == table[convertRow][convertCell + 1]) {
                    numberOfCoincidencesR += 1;
                }
                if (numberOfCoincidencesR == table.length - 1) {
                    result = true;
                    break;
                }
                if (table[convertCell][convertRow] != 0 && table[convertCell][convertRow] == table[convertCell + 1][convertRow]) {
                    numberOfCoincidencesC += 1;
                }
                if (numberOfCoincidencesC == table.length - 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
