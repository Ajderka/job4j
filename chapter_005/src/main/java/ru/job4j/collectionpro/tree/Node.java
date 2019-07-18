package ru.job4j.collectionpro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 18.07.2019.
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    Node(final E value) {
        this.value = value;
    }

    /**
     * Добавление ребенка в список дети.
     *
     * @param child
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Возвращает список детей родителя.
     *
     * @return
     */
    List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравниваем nodes.
     *
     * @param that что нужно сравнить.
     * @return true or false.
     */
    boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }
}