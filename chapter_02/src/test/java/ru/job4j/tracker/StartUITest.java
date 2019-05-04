package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 13.01.2019.
 */
public class StartUITest {

    // создаем поле трекер
    private final Tracker tracker = new Tracker();
    // поле ссылки на стандартный вывод в консоль
    private final PrintStream stdout = System.out;
    // поле - буфер для хранения данных вывода
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    // реализации паттерна стратегия для вывода данных с помощью Consumer
    private final Consumer<String> output = new Consumer<String>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    // Метод возвращает Итем по порядковому индексу
    private Item getItemByIndex(int index) {
        return this.tracker.findAll().get(index);
    }

    // Строка Меню для проверки вывода в консоль
    private final StringBuilder menu = new StringBuilder()
            .append("0 : Add new Item")
            .append(System.lineSeparator())
            .append("1 : Show all items")
            .append(System.lineSeparator())
            .append("2 : Edit item")
            .append(System.lineSeparator())
            .append("3 : Delete item")
            .append(System.lineSeparator())
            .append("4 : Find item by Id")
            .append(System.lineSeparator())
            .append("5 : Find items by name")
            .append(System.lineSeparator())
            .append("6 - Exit program.")
            .append(System.lineSeparator());

    @Before
    // Метод реализует замену стандартного вывода в консоль на вывод в память.
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    //Метод реализует обратный выход в консоль
    public void backOutput() {
        System.setOut(this.stdout);
    }

    // метод реализует иммитацию ввода пользователя и запуск программы
    private void inputAndStart(String[] input) {
        new StartUI(new StubInput(input), this.tracker, output).init();
    }

    // Метод добавляет в итемы в хранилище через цикл
    private void addTasks(int number) {
        for (int index = 0; index < number; index++) {
            this.tracker.add(new Item("test name " + index, "desc " + index));
        }
    }

    /**
     * Test проверяющий добавление ячейки в массив.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        inputAndStart(new String[]{"0", "test name", "desc", "y"});
        assertThat(getItemByIndex(0).getName(), is("test name"));
    }

    /**
     * Test проверяющий замену ячейки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = this.tracker.add(new Item("name1", "desc1"));
        inputAndStart(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        assertThat(getItemByIndex(0).getName(), is("test replace"));
    }

    /**
     * Test проверяющий удаление ячейки.
     */
    @Test
    public void whenDeleteItemThenTrackerShowItem() {
        addTasks(3);
        String target = getItemByIndex(0).getId();
        inputAndStart(new String[]{"3", target, "y"});
        boolean rslt = true;
        for (Item item : this.tracker.findAll()) {
            if (item.getId().equals(target)) {
                rslt = false;
            }
        }
        assertThat(rslt, is(true));
    }

    /**
     * Test показывающий все элементы массива.
     */
    @Test
    public void whenTrackerContainsOneShowAllShowOne() {
        Item first = this.tracker.add(new Item("name1", "desc1"));
        inputAndStart(new String[]{"1", "n", "6", "y"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ All items here --------------")
                                .append(System.lineSeparator())
                                .append("[ Id: " + first.getId() + "\n")
                                .append(" Name : " + first.getName() + "\n")
                                .append(" Description : " + first.getDescription() + "\n")
                                .append(" Create : " + first.getCreate() + "]")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    /**
     * Test проверяющий поиск ячейки по Id.
     */
    @Test
    public void whenTrackerContainsThreeFindByIdShowOne() {
        addTasks(3);
        inputAndStart(new String[]{"4", getItemByIndex(0).getId(), "y"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Find item by id--------------")
                                .append(System.lineSeparator())
                                .append("------------ Found Item : \n")
                                .append(" Id: " + getItemByIndex(0).getId() + "\n")
                                .append(" Name : " + getItemByIndex(0).getName() + "\n")
                                .append(" Description : " + getItemByIndex(0).getDescription() + "\n")
                                .append(" Create : " + getItemByIndex(0).getCreate())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }


    /**
     * Test проверяющий поиск ячейки по имени.
     */
    @Test
    public void whenTrackerContainsThreeFindByNameShowTwoAndMenu() {
        addTasks(3);
        Item third = this.tracker.add(new Item("name2", "desc22"));
        inputAndStart(new String[]{"5", "name2", "y"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Find task by Name --------------")
                                .append(System.lineSeparator())
                                .append("------------ Found Item : \n")
                                .append("[ Id: " + third.getId() + "\n")
                                .append(" Name : " + third.getName() + "\n")
                                .append(" Description : " + third.getDescription() + "\n")
                                .append(" Create : " + third.getCreate() + "]")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
