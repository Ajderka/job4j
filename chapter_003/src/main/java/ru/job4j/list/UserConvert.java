package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 12.03.2019.
 */
class UserConvert {

    /**
     * Метод принимает в себя список пользователей и конвертирует его в Map с ключом Integer id и соответствующим ему User.
     *
     * @param list входящий список типа User.
     * @return возвращает список Map<Integer, User>.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hm = new HashMap<>();
        for (User i : list) {
            hm.put(i.getId(), i);
        }
        return hm;
    }
}
