package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private final List<Item> items = new ArrayList<>();

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
        this.items.add(this.position++, item);
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
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
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
        for (int index = 0; index < this.items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                this.items.set(index, newItem);
                this.items.get(index).setId(id);
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
        for (int index = 0; index < this.items.size(); index++) {
            if (this.items.get(index) != null && this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод поиска ячейки по имени.
     *
     * @param key - имя.
     * @return найденная ячейка.
     */
    public List<Item> findByName(String key) {
        List<Item> listOfNames = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                listOfNames.add(item);
            }
        }
        return listOfNames;
    }
}
