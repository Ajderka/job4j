package ru.job4j.collectionpro.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 13.07.2019.
 */
public class SimpleHashMap<K, V> {

    /**
     * Размер массива по умолчанию.
     */
    private static final int INITIAL_CAPACITY = 1 << 4;

    /**
     * Коэфициент загруженности, влияет на расширение массива.
     */
    private static final double LOAD_FACTOR = 0.75;

    /**
     * Массив типа Node.
     */
    private Node[] table;

    /**
     * Количество поступивших запросов на добавление.
     */
    private int size;

    /**
     * Количество запросов выше которых идет расширение массива.
     */
    private int threshold;

    /**
     * Счетчик модификаций.
     */
    private int modCount;

    /**
     * Подсчитывает величину порога.
     */
    private void grow() {
        threshold = (int) (LOAD_FACTOR * (double) table.length);
    }

    public int getSize() {
        return size;
    }

    SimpleHashMap() {
        table = new Node[INITIAL_CAPACITY];
        grow();
    }

    int capacity() {
        return table.length;
    }

    /**
     * Вставляет элемент в массив.
     *
     * @param key   ключ элемента.
     * @param value значение элемента.
     * @return true если вставка прошла успешно, false если ячейка была занята.
     */
    boolean insert(K key, V value) {
        boolean valid = false;
        int hash = hash(key);
        int i = (table.length - 1) & hash;
        if (table[i] == null) {
            table[i] = new Node<>(hash, key, value);
            valid = true;
            modCount++;
        }
        if (size++ >= threshold) {
            resize();
        }
        return valid;
    }

    /**
     * Возвращает элемент по ключу.
     *
     * @param key ключ элемента.
     * @return значение элемента.
     */
    public V get(K key) {
        V valid = null;
        for (Node node : table) {
            if (node != null && node.key == key) {
                valid = (V) node.value;
                break;
            }
        }
        return valid;
    }

    /**
     * Расширяет массив если порог был превышен.
     */
    private void resize() {
        Node[] oldTab = table;
        int oldCap = oldTab.length;
        Node[] newTab = new Node[oldCap << 1];
        int newCap = newTab.length;
        int i;
        table = newTab;
        grow();
        for (Node node : oldTab) {
            if (node != null) {
                i = (newCap - 1) & node.hash;
                newTab[i] = node;
                modCount++;
            }
        }
    }

    /**
     * Удаляет элемент по ключу.
     *
     * @param key ключ элемента который должен быть удален.
     * @return true если элемент удален, false если элемент не обнаружен.
     */
    boolean delete(K key) {
        boolean valid = false;
        int i = (table.length - 1) & hash(key);
        if (table[i] != null && table[i].key == key) {
            table[i] = null;
            valid = true;
            size--;
        }
        modCount++;
        return valid;
    }

    /**
     * Метод вычисляющий хэш.
     *
     * @param key ключ который будет хэширован.
     * @return значение хэш.
     */
    private static int hash(Object key) {
        return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >>> 16);
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key)
                    && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }


    public Itr iterator() {
        return new SimpleHashMap.Itr();
    }

    private class Itr implements Iterator<Node> {

        int cursor; // index of next element to return

        int expectedModCount = modCount;

        int position = 0;


        @Override
        public boolean hasNext() {
            checkForModification();
            return cursor != size;
        }

        @Override
        public Node next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node next = null;
            for (int index = position; index < table.length; index++) {
                if (table[index] != null) {
                    next = table[index];
                    position = ++index;
                    cursor++;
                    break;
                }
            }
            return next;
        }

        /**
         * Проверка списка на изменения после инициализации итератора.
         *
         * @throws ConcurrentModificationException если ошибка модификации.
         */
        final void checkForModification() throws ConcurrentModificationException {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
/*
Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
boolean insert(K key, V value);
V get(K key);
boolean delete(K key);

Реализовывать итератор.
Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.

Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 */