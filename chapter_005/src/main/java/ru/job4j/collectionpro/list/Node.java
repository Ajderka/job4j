package ru.job4j.collectionpro.list;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 1.07.2019.
 */
class Node<E> {

    private E value;
    Node<E> next;

    Node(E value) {
        this.value = value;
    }

    /**
     * Метод поиска наличия цикличности.
     *
     * @param first элемент с которого будет начат анализ циклиности.
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        Node slow = first;
        Node fast = first;

        if (first != null) {
            while (true) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == null || fast.next == null) {
                    break;
                }
                if (slow == fast) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}

/*
Node first = new Node(1);
Node two = new Node(2);
Node third = new Node(3);
Node four = new Node(4);

first.next = two;
two.next = third;
third.next = four;
four.next = first;

Написать алгоритм определяющий, что список содержит замыкания.

boolean hasCycle(Node first);

Обратите внимание, что список может быть замкнут и в середине. К примеру, 3-й узел будет ссылаться на 2-й узел. Определение зацикленности необходимо реализовать путем прохода по узлам, без использования коллекций.
 */