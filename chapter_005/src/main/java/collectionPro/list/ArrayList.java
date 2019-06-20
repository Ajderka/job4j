package collectionPro.list;

import java.util.*;

public class ArrayList<E> implements Iterable {

    /**
     * Буффер массива в котором хранятся элементы ArrayList.
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
    public ArrayList() {
        this.container = new Object[10];
    }

    /**
     * Создает пустой список с начальной вместимостью указанной в аргументе.
     *
     * @param  initialCapacity начальная вместимость списка.
     * @throws IllegalArgumentException Ошибочный аргумент.
     */
    public ArrayList(int initialCapacity) throws IllegalArgumentException {
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
        return container = Arrays.copyOf(container, container.length * 2);
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
     * @param  index индекс элемента который возвращаем.
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
        if ((newSize = size - 1) > index) {
            System.arraycopy(es, index + 1, es, index, newSize - 1);
        }
        es[newSize] = null;
        return oldValue;
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int cursor; // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() throws NoSuchElementException, ConcurrentModificationException{
            checkForModification();
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = ArrayList.this.container;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void remove() throws IndexOutOfBoundsException, IllegalStateException {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForModification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new IndexOutOfBoundsException();
            }
        }

        /**
         * Проверка списка на изменения после инициализации итератора.
         * @throws ConcurrentModificationException if modified.
         */
        final void checkForModification() throws ConcurrentModificationException{
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}