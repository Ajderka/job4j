package collectionPro.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 22.06.2019.
 */
public class LinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    public int getSize() {
        return size;
    }

    /**
     * Добавляет элемент в начало списка.
     *
     * @param data элемент который будет добавлен в список.
     */
    public void addFirst(E data) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, data, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param data элемент который будет добавлен в список.
     */
    public void addLast(E data) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, data, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Возращает элемент под указанной позицией в списке.
     *
     * @param index индекс элемента который возвращаем.
     * @return элемент в указанной позицией в этом списке.
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Ошибочный индекс");
        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node prev, E data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private Node<E> last;
        private Node<E> next;
        private int cursor;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            checkForModification();
            return cursor < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            checkForModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            last = next;
            next = next.next;
            cursor++;
            return last.data;
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        final void checkForModification() throws ConcurrentModificationException {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

/*
Необходимо создать динамический контейнер с методами:

1) add(E value);

2) E get(int index);

3) реализовать интерфейс Iterable<E>.

Внутри контейнер должен базироваться на связанном списке(Node<E> node).
Использовать стандартные коллекции JDK (ArrayList, LinkedList и т.д.) запрещено. Контейнер должен быть динамическим,
т.е. увеличиваться по мере добавления элементов.

Итератор должен реализовывать fail-fast поведение, т.е. если с момента создания итератора коллекция подверглась
структурному изменению, итератор должен кидать ConcurrentModificationException.
Это достигается через введение счетчика изменений - modCount. Каждая операция, которая структурно модифицирует коллекцию
должна инкрементировать этот счетчик. В свою очередь итератор запоминает значение этого счетчика на момент своего создания
(expectedModCount), а затем на каждой итерации сравнивает сохраненное значение, с текущим значением поля modCount,
если они отличаются, то генерируется исключение.
 */