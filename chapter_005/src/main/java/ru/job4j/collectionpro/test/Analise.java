package ru.job4j.collectionpro.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.07.2019.
 */
public class Analise {

    private Info info = new Info();

    /**
     * Метод возвращает статистику изменений.
     *
     * @param previous начальные данные.
     * @param current  изменненые данные.
     * @return возвращает статистику об изменении коллекции.
     */

    Info diffMap(List<User> previous, List<User> current) {

        Map<Integer, String> mapPrevious = new HashMap<>();
        Map<Integer, String> mapCurrent = new HashMap<>();

        for (User userPrevious : previous) {
            mapPrevious.put(userPrevious.getId(), userPrevious.getName());
        }
        for (User userCurrent : current) {
            mapCurrent.put(userCurrent.getId(), userCurrent.getName());
        }

        for (Integer key : mapPrevious.keySet()) {
            if (mapCurrent.containsKey(key) && !mapPrevious.get(key).equals(mapCurrent.get(key))) {
                this.info.setChanged(this.info.getChanged() + 1);
            } else if (!mapCurrent.containsKey(key)) {
                this.info.setDeleted(this.info.getDeleted() + 1);
            }
        }
        for (Integer key : mapCurrent.keySet()) {
            if (!mapPrevious.containsKey(key)) {
                this.info.setAdded(this.info.getAdded() + 1);
            }
        }
        return this.info;
    }


    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }
    }
}
