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
     * Помещает объект в начало коллекции.
     *
     * @param value значение объекта.
     */
    void push(T value) {
        list.add(value);
    }

    /**
     * Удаляет объект с начала списка.
     *
     * @return T значение объекта который будет удален.
     */
    T poll() {
        return list.removeFirst();
    }

    /**
     * Возвращает значение объекта по индексу.
     *
     * @param index индекс элемента который возвращаем.
     * @return T значение объекта который будет возвращен.
     */
    public T get(int index) {
        return list.get(index);
    }

    boolean isEmpty() {
        return list.getSize() == 0;
    }
}

/*
Используя контейнер на базе связанного списка создать контейнер Stack.

public class SimpleStack<T> {
   public <T> poll()

   public void push(T value);
}

Метод poll() - должен возвращать значение и удалять его из коллекции.
Метод push(T value) - помещает значение в коллекцию.
При реализации стека нужно  использовать коллекции #159, которые вы реализовывали в предыдущих заданиях.

Описание Stack - стек. Описывается LIFO - last input first output.

То есть, последний зашел и первый вышел. Например.

push(1);
push(2);
push(3);

poll() - 3
poll() - 2
poll() - 1
 */