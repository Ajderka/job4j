package ru.job4j.collectionpro.test;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 29.07.2019.
 */
class CommonItems {

    /**
     * Метод через множество вычисляет элементы которые повторяются.
     *
     * @param a первый массив.
     * @param b второй массив.
     * @return Integer[] массив повторяющихся элементов.
     */
    Integer[] findCommonItems(Integer[] a, Integer[] b) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(a));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(b));
        s1.retainAll(s2);
        return s1.toArray(new Integer[0]);
    }

    /**
     * Метод через карты вычисляет элементы которые повторяются.
     *
     * @param a первый массив.
     * @param b второй массив.
     * @return Integer[] массив повторяющихся элементов.
     */
    Integer[] findCommonItemsThroughMap(Integer[] a, Integer[] b) {
        int count = 0;
        int countSize = 0;
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapA = new HashMap<>();

        for (Integer integer : a) {
            mapA.put(integer, 0);
        }
        for (Integer integer : b) {
            mapB.put(integer, 0);
        }
        for (Integer key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                mapB.put(key, +1);
                countSize++;
            }
        }
        Integer[] massive = new Integer[countSize];
        for (Integer key : mapB.keySet()) {
            if (mapB.get(key) > 0) {
                massive[count++] = key;
            }
        }
        return massive;
    }
}