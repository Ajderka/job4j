package ru.job4j.collectionpro.list;

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

    public E removeFirst() {
        final E remote = this.first.data;
        this.first = this.first.next;
        this.size--;
        this.modCount++;
        return remote;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private Node<E> node = LinkedList.this.first;
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
            E result = node.data;
            node = node.next;
            cursor++;
            return result;
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