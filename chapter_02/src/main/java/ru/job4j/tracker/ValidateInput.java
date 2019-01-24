package ru.job4j.tracker;

import java.util.List;

/**
 * Class  ValidateInput.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 25.01.2019.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Метод реализует возможность ошибки пользователя в текстовое сообщение.
     */
    @Override
    public int ask(String questions, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(questions, range);
                invalid = false;
            } catch (MenuOutExceptoin moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valuable data again");
            }
        } while (invalid);
        return value;
    }
}
