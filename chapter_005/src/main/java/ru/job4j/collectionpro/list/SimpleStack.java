package ru.job4j.collectionpro.list;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 24.06.2019.
 */
public class SimpleStack<T> {

    /**
     * Создаем объект класса, на методы которого будем ссылаться.
     */
    private LinkedList<T> list = new LinkedList<>();

    /**
     * Помещает объект в коллекцию.
     *
     * @param value значение объекта.
     */
    public void push(T value) {
        list.addFirst(value);
    }

    /**
     * Удаляет объект с начала списка.
     *
     * @return T значение объекта который будет удален.
     */
    public T poll() {
        return (T) list.removeFirst();
    }

    /**
     * Возвращает значение объекта по индексу.
     *
     * @param index индекс элемента который возвращаем.
     * @return T значение объекта который будет возвращен.
     */
    public T get(int index) {
        return (T) list.get(index);
    }
}