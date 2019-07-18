package ru.job4j.collectionpro.tree;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 18.07.2019.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Первый элемент.
     */
    private Node<E> root;

    /**
     * Счетчик изменений.
     */
    private int modCount;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод добавляет в список children, child.
     * Parent класс содержит в себе список children.
     * Если не найден родительски класс, то вернет false.
     * Если запись уже существует вернет false.
     *
     * @param parent родительский узел.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean valid = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> result = findBy(parent);
            valid = result.isPresent();
            if (valid) {
                result.get().add(new Node<>(child));
                modCount++;
            }
        }
        return valid;
    }

    /**
     * Возвращает найденный узел по значению.
     *
     * @param value значение.
     * @return Node<E> найденный узел.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Возвращает итератор для элементов в этом списке,
     * в правильной последовательности.
     *
     * @return an iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Tree.Itr();
    }

    private class Itr implements Iterator<E> {

        /**
         * Счетчик изменений в контейнере.
         */
        private int expectedModCount = modCount;

        /**
         * Контейнер всех элементов в дереве.
         */
        private Queue<Node<E>> data = new LinkedList<>();

        public Itr() {
            data.offer(root);
        }

        @Override
        public boolean hasNext() {
            checkForModifications();
            return !data.isEmpty();
        }

        @Override
        public E next() throws NoSuchElementException {
            checkForModifications();
            Node<E> el;
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                el = data.poll();
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
            }
            return el.getValue();
        }

        /**
         * Проверяет контейнер на изменения после инициализации итератора.
         *
         * @throws ConcurrentModificationException
         */
        private void checkForModifications() throws ConcurrentModificationException {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
