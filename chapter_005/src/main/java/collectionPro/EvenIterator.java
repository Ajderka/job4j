package collectionPro;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.06.2019.
 */
public class EvenIterator implements Iterator {
    private final int[] massive;
    private int count = 0;

    public EvenIterator(final int[] values) {
        this.massive = values;
    }

    @Override
    public boolean hasNext() {
        int countHasNext = count;
        boolean result = false;
        while (countHasNext < massive.length) {
            if (massive[countHasNext] % 2 == 0) {
                result = true;
                break;
            }
            countHasNext++;
        }
        return result;
    }

    @Override
    public Object next() {
        while (count < massive.length && massive[count] % 2 != 0) {
            count++;
        }
        if (count >= massive.length) {
            throw new NoSuchElementException();
        }
        return massive[count++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}