package ru.job4j.collectionpro.list;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 20.06.2019.
 */
public class SimpleList<E> {

    /**
     * Буффер массива в котором хранятся элементы SimpleList.
     */
    private Object[] container;

    /**
     * Поле указывающее количество заполненных элементов в массиве.
     */
    private int size;

    /**
     * Поле являющееся счетчиком структурных изменений в коллекции.
     */
    private int modCount;

    /**
     * Создает список с начальной вместимостью десять.
     */
    public SimpleList() {
        this.container = new Object[10];
    }

    public int getSize() {
        return size;
    }

    public int getSizeContainer() {
        return container.length;
    }

    /**
     * Создает пустой список с начальной вместимостью указанной в аргументе.
     *
     * @param initialCapacity начальная вместимость списка.
     * @throws IllegalArgumentException Ошибочный аргумент.
     */
    public SimpleList(int initialCapacity) throws IllegalArgumentException {
        if (initialCapacity >= 0) {
            this.container = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Ошибочный аргумент" + initialCapacity);
        }
    }

    /**
     * Увеличение емкости списка в два раза.
     */
    private Object[] grow() {
        container = Arrays.copyOf(container, container.length * 2);
        return container;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param value элемент который будет добавлен в список.
     * @return true.
     */
    public boolean add(E value) {
        modCount++;
        if (size == container.length) {
            container = grow();
        }
        container[size] = value;
        size++;
        return true;
    }

    /**
     * Возращает элемент под указанной позицией в списке.
     *
     * @param index индекс элемента который возвращаем.
     * @return элемент в указанной позицией в этом списке.
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) container[index];
    }

    /**
     * Удаляет элемент указанной позиции.
     * Сдвигает элементы на один левее удаленного элемента.
     *
     * @param index индекс элемента который будет удален.
     * @return элемент который удален из списка.
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = container;
        final int newSize;
        E oldValue = (E) es[index];

        modCount++;
        newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(es, index + 1, es, index, newSize - 1);
        }
        size = newSize;
        es[size] = null;
        return oldValue;
    }

    public Iterator<E> iterator() {
        return new SimpleList.Itr();
    }

    private class Itr implements Iterator<E> {

        int cursor; // index of next element to return
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            checkForModification();
            return cursor != size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) container[cursor++];
        }

        @Override
        public void remove() throws IllegalStateException {
            if (cursor - 1 < 0) {
                throw new IllegalStateException();
            }
            checkForModification();
            SimpleList.this.remove(--cursor);
            expectedModCount = modCount;
        }

        /**
         * Проверка списка на изменения после инициализации итератора.
         *
         * @throws ConcurrentModificationException if modified.
         */
        final void checkForModification() throws ConcurrentModificationException {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}