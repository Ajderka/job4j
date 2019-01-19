package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    private Tracker tracker;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void preRun() {
        tracker = new Tracker();
        tracker.add(new Item("test name 1", "desc1"));
        tracker.add(new Item("test name 2", "desc2"));
        tracker.add(new Item("test name 3", "desc3"));
        tracker.add(new Item("test name 4", "desc4"));
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Test проверяющий добавление ячейки в массив.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Test показывающий все элементы массива.
     */
    @Test
    public void whenShowAllItem() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name 1"));
        assertThat(tracker.findAll()[1].getName(), is("test name 2"));
        assertThat(tracker.findAll()[2].getName(), is("test name 3"));
        assertThat(tracker.findAll()[3].getName(), is("test name 4"));
    }

    /**
     * Test проверяющий замену ячейки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", tracker.findAll()[0].getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    /**
     * Test проверяющий удаление ячейки.
     */
    @Test
    public void whenDeleteItemThenTrackerShowItem() {
        Input input = new StubInput(new String[]{"3", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name 2"));
    }

    /**
     * Test проверяющий поиск ячейки по Id.
     */
    @Test
    public void whenFindItemByIdThenTrackerHasShowItem() {
        Input input = new StubInput(new String[]{"4", tracker.findAll()[2].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2].getName(), is("test name 3"));
    }

    /**
     * Test проверяющий поиск ячейки по имени.
     */
    @Test
    public void whenFindItemByNameThenTrackerHasShowItem() {
        Input input = new StubInput(new String[]{"5", tracker.findAll()[2].getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2].getName(), is("test name 3"));
    }
}
