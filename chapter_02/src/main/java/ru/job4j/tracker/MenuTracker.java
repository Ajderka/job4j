package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class  MenuTracker.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 25.01.2019.
 */
public class MenuTracker {

    /**
     * @param хранит ссылку на объект .
     */
    private Input input;

    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;

    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(ui, 6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    /**
     * Class реализует добавление заявок.
     */
    class AddItem extends BaseAction {

        public AddItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ New Item with Id : " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDescription());
        }
    }

    /**
     * Class реализует список всех добавленных заявок.
     */
    class ShowItems extends BaseAction {

        public ShowItems(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ All items here --------------");
            System.out.println(tracker.findAll());
        }
    }

    /**
     * Метод реализует редактирование заявок.
     */
    class UpdateItem extends BaseAction {

        public UpdateItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Edit item by id--------------");
            String id = input.ask("Please, provide item id:");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                output.accept("------------ Item was changed :  --------------");
            }
        }
    }

    /**
     * Class реализует удаление заявок.
     */
    class DeleteItem extends BaseAction {

        public DeleteItem(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Delete item by id--------------");
            String id = input.ask("Please, provide item id:");
            if (tracker.delete(id)) {
                output.accept("------------ Item was Delete :  --------------");
            }
        }
    }

    /**
     * Class реализует нахождение заявок по id.
     */
    class FindItemById extends BaseAction {

        public FindItemById(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Find item by id--------------");
            String id = input.ask("Please, provide item id:");
            output.accept("------------ Found Item : \n" + tracker.findById(id));
        }
    }

    /**
     * Class реализует поиск заявок по полю name.
     */
    class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String action) {
            super(key, action);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Find item by id--------------");
            String name = input.ask("Please, provide item name:");
            output.accept("------------ Found Item : \n" + tracker.findByName(name));
        }
    }

    /**
     * Class реализует выход из программы.
     */
    class ExitProgram implements UserAction {

        private final StartUI ui;
        int key;
        String action;

        public ExitProgram(StartUI ui, int key, String action) {
            this.ui = ui;
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Good Bie");
            this.ui.stop();
        }

        @Override
        public String info() {
            return String.format("%s - %s", this.key(), "Exit program.");
        }
    }
}
