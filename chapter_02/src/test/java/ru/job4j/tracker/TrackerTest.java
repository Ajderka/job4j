package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.01.2019.
 */
public class TrackerTest {

    /**
     * Test проверяющий добавление ячейки в массив.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        assertThat(tracker.add(item), is(item));
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test проверяющий поиск ячейки по имени.
     */
    @Test
    public void whenFindByNameThenTrackerShowFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 1231L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1232L);
        tracker.add(item2);
        assertThat(tracker.findByName(item1.getName())[0], is(item1));
    }

    /**
     * Test проверяющий ячейки которые были добавлены, показывает их.
     */
    @Test
    public void whenFindAllThenTrackerShowAllFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 1231L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1232L);
        tracker.add(item2);
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item1));
        assertThat(tracker.findAll()[2], is(item2));
    }

    /**
     * Test проверяющий поиск ячейки по Id.
     */
    @Test
    public void whenFindByIdThenTrackerShowFoundItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 1231L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1232L);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    /**
     * Test проверяющий удаление ячейки.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNotSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 1231L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1232L);
        tracker.add(item2);
        assertThat(tracker.delete(item1.getId()), is(true));
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item2));
    }

    /**
     * Test проверяющий замену ячейки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()), is(next));
        assertThat(tracker.replace(previous.getId(), next), is(true));
    }
}
