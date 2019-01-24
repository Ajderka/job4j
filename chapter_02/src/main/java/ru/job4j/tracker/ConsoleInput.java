package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * Class  ConsoleInput.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.01.2019.
 */
public class ConsoleInput implements Input {

    /**
     * Поле создаем экземпляр сканера.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Переопределяем метод ask.
     */
    public String ask(String questions) {
        System.out.println(questions);
        return scanner.nextLine();
    }

    /**
     * Перегружаем метод ask.
     */
    @Override
    public int ask(String questions, List<Integer> range) {
        int key = Integer.valueOf(this.ask(questions));
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
            throw new MenuOutExceptoin("Out of menu range");
        }
    }
}
