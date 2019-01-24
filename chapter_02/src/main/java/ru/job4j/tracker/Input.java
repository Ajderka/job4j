package ru.job4j.tracker;

import java.util.List;

/**
 * Class  Input.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.01.2019.
 */
public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);
    
}
