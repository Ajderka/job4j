package ru.job4j.collectionpro.list;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 24.06.2019.
 */
public class SimpleStack<T> extends LinkedList {

    public void push(T value) {
        addFirst(value);
    }

    public T poll() {
        T result = (T) removeFirst();
        return result;
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