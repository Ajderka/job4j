package ru.job4j.collectionpro.list;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 26.06.2019.
 */
public class SimpleQueue<T> {

    private LinkedList<T> list = new LinkedList<>();

    /**
     * Помещает объект в конец коллекции.
     *
     * @param value значение объекта.
     */
    public void push(T value) {
        list.addLast(value);
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

/*
Нужно реализовать очередь.

public class SimpleQueue<T> {
   public <T> poll()

   public void push(T value);
}

Метод poll() - должен возвращать значение и удалять его из коллекции.
Метод push(T value) - помещает значение в коллекцию.

Внутри очереди нужно использовать Стеки из задания 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack

Описание Queue - очередь. Описывается FIFO - first input first output.

То есть, первый зашел и первый вышел. Например.

push(1);
push(2);
push(3);

poll() - 1
poll() - 2
poll() - 3

Это задание является тестовым заданием на собеседованиях.
 */