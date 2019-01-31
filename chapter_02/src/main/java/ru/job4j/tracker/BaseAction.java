package ru.job4j.tracker;

/**
 * Class  StartUI.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 01.02.2019.
 */
public abstract class BaseAction implements UserAction {

    /**
     * @param хранит пункт меню .
     */
    private final int key;

    /**
     * @param хранит описание пункта меню .
     */
    private final String action;

    /**
     * Конструктор.
     *
     * @param key    пункт меню.
     * @param action описание пункта меню.
     */
    protected BaseAction(final int key, final String action) {
        this.key = key;
        this.action = action;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.action);
    }
}