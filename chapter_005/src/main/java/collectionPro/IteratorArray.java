package collectionPro;

import java.util.Iterator;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 08.06.2019.
 */
public class IteratorArray implements Iterator {

    private final int[][] values; //двумерный массив

    /**
     * позиция текущего элемента для выдачи
     */
    private int position = 0;

    /**
     * строка текущего элемента
     */
    private int row = 0;

    /**
     * столбец текущего элемента
     */
    private int col = 0;

    /**
     * конструтктор инициализирующий массив и переменную size
     */
    public IteratorArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (int[] row : values) {
            count += row.length;
        }
        return count > position;
    }

    @Override
    public Object next() {
        int cell = values[row][col];
        position++;
        col++;
        while (row < values.length && col == values[row].length) {
            col = 0;
            row++;
        }
        return cell;
    }
}