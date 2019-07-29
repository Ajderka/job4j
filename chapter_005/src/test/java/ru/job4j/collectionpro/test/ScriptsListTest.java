package ru.job4j.collectionpro.test;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 29.07.2019.
 */
public class ScriptsListTest {

    private ScriptsList scriptsList;

    @Before
    public void beforeTest() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3));
        map.put(1, list1);
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4));
        map.put(2, list2);
        List<Integer> list3 = new ArrayList<>(Arrays.asList(4, 5));
        map.put(3, list3);
        List<Integer> list4 = new ArrayList<>();
        map.put(4, list4);
        List<Integer> list5 = new ArrayList<>();
        map.put(5, list5);
        scriptsList = new ScriptsList(map, 1);
    }

    @Test
    public void findCommonItemsInTwoMassive() {
        List<Integer> scripts = new ArrayList<>(Arrays.asList(2, 3, 4, 4, 5));
        assertThat(scriptsList.loadScript(), is(scripts));
    }
}