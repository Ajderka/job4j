package ru.job4j.tracker;

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
    public String ask(String question) {
        return answers[position++];
    }
}
