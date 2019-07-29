package ru.job4j.collectionpro.test;

import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.07.2019.
 */
public class Analise {

    /**
     * Метод возвращает статистику изменений.
     *
     * @param previous начальные данные.
     * @param current  изменненые данные.
     * @return возвращает статистику об изменении коллекции.
     */
    public Info diff(List<User> previous, List<User> current) {

        Info info = new Info();


        for (User previous1 : previous) {
            int deleteMarker = 0;
            for (User user : current) {
                if (previous1.getId() == user.getId()
                        && !previous1.getName().equals(user.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
                if (previous1.getId() == user.getId()) {
                    deleteMarker++;
                    break;
                }
            }
            if (deleteMarker == 0) {
                info.setDeleted(info.getDeleted() + 1);
            }
        }

        for (User user : current) {
            int addMarker = 0;
            for (User previous1 : previous) {
                if (user.getId() == previous1.getId()) {
                    addMarker++;
                    break;
                }
            }
            if (addMarker == 0) {
                info.setAdded(info.getAdded() + 1);
            }
        }
        return info;
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
