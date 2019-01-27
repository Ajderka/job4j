package ru.job4j.tracker;

import java.util.List;

/**
 * Class  StubInput.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.01.2019.
 */
public class StubInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private String[] answers;

    /**
     * Поле считает количество вызовом метода ask.
     */
    private int position = 0;


    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new UnsupportedOperationException("unsupported operation");
        }
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }
}
