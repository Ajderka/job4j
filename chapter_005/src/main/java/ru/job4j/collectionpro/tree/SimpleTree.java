package ru.job4j.collectionpro.tree;

import java.util.Optional;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 18.07.2019.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}