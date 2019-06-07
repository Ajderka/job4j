package collectionPro;

import java.util.Iterator;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.06.2019.
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
     * количество элементов в двумерном массиве
     */
    private int size;

    /**
     * метод который подсчитывает размер многомерного массива
     */
    private int massiveSize(int[][] massive) {
        int count = 0;
        for (int[] row : massive) {
            count += row.length;
        }
        return count;
    }

    /**
     * конструтктор инициализирующий массив и переменную size
     */
    public IteratorArray(int[][] values) {
        this.values = values;
        this.size = massiveSize(values);
    }

    @Override
    public boolean hasNext() {
        return size > position;
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