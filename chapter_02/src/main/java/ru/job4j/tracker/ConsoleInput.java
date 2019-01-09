package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class  Item.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 3.01.2019.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String questions) {
        System.out.println(questions);
        return scanner.nextLine();
    }
}
