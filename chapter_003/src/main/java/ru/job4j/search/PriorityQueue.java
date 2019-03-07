package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 07.03.2019.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод проверяет приоритет введенного Task и того который уже есть в LinkedList(если есть),
     * в случае если у введенного Task приоритет ниже чем у того который в LinkedList,
     * то index увеличивается на 1, и по тому же алгоритму проверяет вторую ячейку в LinkedList.
     * Если приоритет окажется выше, то в ту же ячейку (index) запишется.
     *
     * @param task задача.
     */
    public void put(Task task) {
        int index = 0;
        for (Task newTask : tasks) {
            if (newTask != null && newTask.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Возвращает элемент из головы очереди и удаляет его. Если очередь пуста,
     * возвращает пустое значение null.
     *
     * @return Task задача.
     */
    public Task take() {
        return this.tasks.poll();
    }
}