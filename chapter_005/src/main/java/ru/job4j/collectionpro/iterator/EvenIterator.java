package ru.job4j.collectionpro.iterator;

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
        boolean result = false;
        while (count < massive.length) {
            if (massive[count] % 2 == 0) {
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return massive[count++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}