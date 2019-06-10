package collectionPro;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 08.06.2019.
 */
public class IteratorArray implements Iterator {

    private final int[][] values; //двумерный массив

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
        boolean result = false;
        if (values.length > row && values[row].length - 1 >= col) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("В массиве больше нет элементов");
        }
        int cell = values[row][col];
        if (values[row].length - 1 > col) {
            col++;
        } else {
            row++;
            col = 0;
        }
        return cell;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
