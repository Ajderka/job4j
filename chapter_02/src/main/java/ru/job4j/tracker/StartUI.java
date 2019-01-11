package ru.job4j.tracker;


import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String SHOWALL = "1";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FINDBYID = "4";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует поиск заявок по полю name.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по Name :  --------------");
        String name = this.input.ask("Введите поле Name заявки которую нужно найти :");
        System.out.println("------------ Найденная заявка : " + Arrays.toString(this.tracker.findByName(name)) + " --------------");

    }

    /**
     * Метод реализует нахождение заявок по id.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по id :  --------------");
        String id = this.input.ask("Введите id заявки которую нужно найти :");
        System.out.println("------------ Найденная заявка : " + this.tracker.findById(id) + " --------------");

    }

    /**
     * Метод реализует удаление заявок.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки по id :  --------------");
        String id = this.input.ask("Введите id заявки которую нужно удалить :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка была удалена по id :  --------------");
        }
    }

    /**
     * Метод реализует редактирование заявок.
     */
    private void edit() {
        System.out.println("------------ Замена заявки по id  --------------");
        String id = this.input.ask("Введите id заявки которую нужно отредактировать :");
        String name = this.input.ask("Введите имя новой заявки :");
        String description = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, description);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Заявка была заменена :  --------------");
        }
    }

    /**
     * Метод реализует список всех добавленных заявок.
     */
    private void showAll() {
        System.out.println("------------ Все добавленные заявки --------------");

        System.out.println(Arrays.toString(tracker.findAll()));
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println(" 0. Add new Item\n 1. Show all items\n 2. Edit item\n 3. Delete item\n "
                + "4. Find item by Id\n 5. Find items by name\n 6. Exit Program\n Select:");
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}