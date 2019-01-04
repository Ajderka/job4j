package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Class Tracker - это обертка над массивом.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 1.1.2019.
 */
public class Tracker {
    /**
     * Объект генерирующий случайное число.
     */
    private static final Random RN = new Random();
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод поиска ячейки по Id ячейки.
     *
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                result = this.items[index];
                break;
            }
        }
        return result;
    }

    /**
     * Метод замены ячейки.
     *
     * @param id      - уникальный ключ.
     * @param newItem - новая заявка.
     * @return true если ячейка заменена.
     */
    public boolean replace(String id, Item newItem) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = newItem;
                this.items[index].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаления ячейки.
     *
     * @param id - уникальный ключ.
     * @return true если ячейка удаленаф.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод выдаче заполненных ячеек.
     *
     * @return заполненные ячейки.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод поиска ячейки по имени.
     *
     * @param key - имя.
     * @return найденная ячейка.
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int index = 0; index < position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, this.position);
    }
}
