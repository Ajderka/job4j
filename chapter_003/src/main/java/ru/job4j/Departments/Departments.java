package ru.job4j.Departments;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 20.04.2019.
 */
public class Departments {

    /**
     * сортивка списка подразделений по возрастанию
     *
     * @param list
     */
    public void sortNatural(List<String> list) {
        this.check(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * сортивка списка подразделений по убыванию
     *
     * @param list
     */
    public void sortReverse(List<String> list) {
        this.check(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                int size = Math.min(o1.length(), o2.length());
                String first = o1.substring(0, size);
                String second = o2.substring(0, size);
                if (first.compareTo(second) == 0 && o1.length() > o2.length()) {
                    result = 1;
                } else if (first.compareTo(second) == 0 && o1.length() < o2.length()) {
                    result = -1;
                } else {
                    result = o2.compareTo(o1);
                }
                return result;
            }
        });
    }

    /**
     * проверка списка на наличие верхнего уровня подразделений, вставка в случае отсутствия
     *
     * @param list
     */
    public void check(List<String> list) {
        for (int out = 0; out < list.size(); out++) {
            String[] separator = list.get(out).split("\\\\");
            if (separator.length > 1) {
                String tempo = separator[0];
                for (int in = 1; in < separator.length; in++) {
                    if (!list.contains(tempo)) {
                        list.add(tempo);
                    }
                    tempo += "\\" + separator[in];
                }
            }
        }
    }
}
