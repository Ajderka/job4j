package ru.job4j.peerReview;

import ru.job4j.comparator.User;

import java.util.*;

//нет JavaDoc
public class Sorter {

    //нет JavaDoc
    //идентификатор доступа public отсутствует
    Set<User> sort(List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    //нет JavaDoc
    //идентификатор доступа public отсутствует
    //название класса не соответствует стилю CamelCase
    List<User> sortnamelength(List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();//лучше реализовать через compareTo
            }
        };
        list.sort(compar);
        return list;
    }

    //нет JavaDoc
    //идентификатор доступа public отсутствует
    //название класса не соответствует стилю CamelCase
    List<User> sortboth(List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge(); //лучше реализовать через compareTo
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}