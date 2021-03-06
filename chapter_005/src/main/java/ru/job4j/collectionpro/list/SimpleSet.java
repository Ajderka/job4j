package ru.job4j.collectionpro.list;

import java.util.Iterator;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.07.2019.
 */
public class SimpleSet<E> implements Iterable<E> {

    private SimpleList<E> container;

    SimpleSet() {
        container = new SimpleList<>();
    }

    /**
     * Метод возвращает количество элементов в множестве.
     *
     * @return число элементов в множестве.
     */
    public int size() {
        return this.container.getSize();
    }


    /**
     * Метод добавляет элементы в множество.
     * Если такой елемент уже есть в множестве, он не добавиться.
     *
     * @param e то что мы добавляем.
     */
    public void add(E e) {
        if (!checkForRepetitions(e)) {
            this.container.add(e);
        }
    }

    /**
     * Метод проверки на повторения.
     *
     * @param element чей дубликат мы ищем.
     */
    private boolean checkForRepetitions(E element) {
        boolean repeat = false;
        for (int i = 0; i < size(); i++) {
            if ((element == this.container.get(i)) || (element != null && element.equals(this.container.get(i)))) {
                repeat = true;
                break;
            }
        }
        return repeat;
    }

    @Override
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}

/*
Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать void add(E e) и реализовывать Iterable<E>.
Коллекция не должна хранить дубликаты.
Set - внутри для хранения данных использует обычные массивы.


Код будет идентичным, как и в SimpleList(Это код из задания реализации списка на массиве).
как можно за счет композиции сократить количества кода?
Здесь нужно использовать SimpleList в реализации SimpleSet.
 */
