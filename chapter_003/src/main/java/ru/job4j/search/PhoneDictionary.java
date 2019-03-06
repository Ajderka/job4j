package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 06.03.2019.
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<Person>();
        for (Person value : persons) {
            if (value.getName() != null && value.getName().contains(key)) {
                result.add(value);
            }
        }
        return result;
    }
}