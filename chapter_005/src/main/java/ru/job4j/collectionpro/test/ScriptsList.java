package ru.job4j.collectionpro.test;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 29.07.2019.
 */
class ScriptsList {

    private Map<Integer, List<Integer>> map;
    private List<Integer> listScripts = new ArrayList<>();
    private int numberScript;

    ScriptsList(Map<Integer, List<Integer>> map, int numberScript) {
        this.map = map;
        this.numberScript = numberScript;
    }

    /**
     * Метод возвращает скрипты которые нужно вызвать.
     *
     * @return список скриптов.
     */
    List<Integer> loadScript() {
        return recursion(new ArrayList<>(new ArrayList<>(Collections.singletonList(numberScript))));
    }

    /**
     * Логика основанная на рекурсии.
     *
     * @param list список скриатов.
     * @return список скриптов.
     */
    private List<Integer> recursion(List<Integer> list) {
        if (!list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            list.forEach(number ->
            {
                map.get(number).forEach(numberKey ->
                {
                    temp.add(numberKey);
                    listScripts.add(numberKey);
                });
            });
            recursion(temp);
        }
        return listScripts;
    }
}
/*
Задача список скриптов с указанием их зависимосей.
1 - [2, 3], 2 - [4], 3 - [4, 5], 4 - [], 5 - []
Необходим написать метод, который возвращает список всех скриптов, которые нужно для загрузки входящего скрипта.
Например, чтобы выполнить скрипт 1. нужно выполнить скрипт (2, 3), которые в свою очередь зависят от 4 и 5 скрипта.
List load(Map<Integer, List ds, Integer scriptId)
 */