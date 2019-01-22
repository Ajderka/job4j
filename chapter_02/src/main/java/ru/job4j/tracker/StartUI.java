package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

/**
 * Class  StartUI.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 13.01.2019.
 */
public class StartUI {

    /**
     * Поле для флага, стоп программы.
     */
    private boolean working = true;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select: ", range));
        } while (this.working && !"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Выход из программы.
     */
    public void stop() {
        this.working = false;
    }

    /**
     * Запуск программы.
     *
     * @param args - массив строк.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}