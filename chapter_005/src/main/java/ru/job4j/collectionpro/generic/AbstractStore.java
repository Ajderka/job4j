package ru.job4j.collectionpro.generic;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.06.2019.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> store;

    public AbstractStore(int size) {
        store = new SimpleArray<>(size);
    }

    /**
     * Метод добавляющий значение в массив.
     * Если массив полный выбросит исключение.
     *
     * @param model объект который нужно добавить.
     */
    @Override
    public void add(T model) {
        store.add(model);
    }

    /**
     * Метод заменяет указанную ячейку.
     * Если индекс выходит за границы массива то выбрасывает исключение.
     *
     * @param id    элемента который нужно заменить.
     * @param model элемент который будет на месте замененного.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int index = 0; index < store.getSize(); index++) {
            if (id.equals(getIdByIndex(index))) {
                store.set(index, model);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет объект по id.
     *
     * @param id элемента который будет удален.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < store.getSize(); index++) {
            if (id.equals(getIdByIndex(index))) {
                store.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет элемент в массиве по id.
     *
     * @param id элемента который будет найден.
     */
    @Override
    public T findById(String id) {
        T result = null;
        for (int index = 0; index < store.getSize(); index++) {
            if (id.equals(getIdByIndex(index))) {
                result = store.get(index);
                break;
            }
        }
        return result;
    }

    /**
     * Метод предоставляет объект по индексу.
     * Выбрасывает исключение если индекс выходит за границы массива.
     *
     * @param index позиция в массиве.
     * @return T объект по запросу.
     */
    public T getIndex(int index) {
        return store.get(index);
    }

    /**
     * Метод предоставляет Id объекта по индексу.
     * Выбрасывает исключение если индекс выходит за границы массива.
     *
     * @param index позиция в массиве.
     * @return String Id объекта.
     */
    public String getIdByIndex(int index) {
        return store.get(index).getId();
    }
}