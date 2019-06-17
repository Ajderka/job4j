package collectionPro.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 14.06.2019.
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] massive;
    private int count = 0;

    public SimpleArray(int size) {
        this.massive = new Object[size];
    }

    public int getSize() {
        return massive.length;
    }

    /**
     * Метод добавляющий значение в массив.
     * Если массив полный выбросит исключение.
     *
     * @param model объект который нужно добавить.
     */
    public void add(T model) throws IndexOutOfBoundsException {
        if (massive.length <= count) {
            throw new IndexOutOfBoundsException("Массив переполнен");
        }
        this.massive[count++] = model;
    }

    /**
     * Метод заменяет указанную ячейку.
     * Если индекс выходит за границы массива то выбрасывает исключение.
     *
     * @param index индекс который нужно заменить.
     * @param model элемент который будет на месте замененного.
     */
    public void set(int index, T model) throws IndexOutOfBoundsException {
        if (count <= index) {
            throw new IndexOutOfBoundsException("Нет такого элемента в массиве");
        }
        this.massive[index] = model;
    }

    /**
     * Метод предоставляет объект по индексу.
     * Выбрасывает исключение если индекс выходит за границы массива.
     *
     * @param position позиция в массиве.
     * @return T объект по запросу.
     */
    public T get(int position) throws IndexOutOfBoundsException {
        if (count <= position) {
            throw new IndexOutOfBoundsException("Нет такого элемента в массиве");
        }
        return (T) this.massive[position];
    }

    /**
     * Метод удаляет объект по индексу.
     * Выбрасывает исключение если идекс выходит за границы массива.
     *
     * @param cell индекс элемента который будет удален.
     */
    public void remove(int cell) throws IndexOutOfBoundsException {
        if (massive.length <= cell) {
            throw new IndexOutOfBoundsException("Нет такого элемента в массиве");
        }
        if (massive.length - cell >= 0) {
            System.arraycopy(this.massive, cell, this.massive, cell - 1, massive.length - cell);
            massive[massive.length - 1] = null;
        }
    }

    /**
     * Возвращает итератор для элементов в этом списке в правильной последовательности.
     *
     * @return итератор.
     */
    @Override
    public Iterator iterator() {
        return new CustomIterator<T>(massive);
    }

    public class CustomIterator<E> implements Iterator<E> {

        int indexPosition = 0;
        private Object[] internalArray;

        public CustomIterator(Object[] array) {
            this.internalArray = array;
        }

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (count > indexPosition) {
                result = true;
            }
            return result;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("В массиве больше нет элементов");
            }
            return (E) internalArray[indexPosition++];
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}