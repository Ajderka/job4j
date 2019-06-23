package ru.job4j.collectionpro.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 11.06.2019.
 */
public class IteratorOfIterators {

    /**
     * Метод принимающий несколько итераторов и возвращающий итератор итераторов.
     *
     * @param it несколько итераторов, которые будут совмещены в один.
     * @return Итератор значений взятых последовательно из других итераторов.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            public Iterator<Integer> iterator = (new ArrayList<Integer>().iterator());

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !iterator.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}