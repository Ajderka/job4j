package ru.job4j.list;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public Map<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(User::getId, user -> user));
    }
}
