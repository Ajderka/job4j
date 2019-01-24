package ru.job4j.tracker;

/**
 * Class  MenuOutExceptoin.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 25.01.2019.
 */
public class MenuOutExceptoin extends RuntimeException {

    public MenuOutExceptoin(String msg) {
        super(msg);
    }
}
