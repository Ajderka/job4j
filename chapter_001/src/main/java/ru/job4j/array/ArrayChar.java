package ru.job4j.array;

/**
 * Class  Массив заполнен true или false[#91019].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.12.2018.
 */
public class ArrayChar {

    /**
     * ссылка на массив типо char.
     */
    private char[] data;

    /**
     * конструктор принимает строку и преобразует ее в массив data типо char.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * method startWith - Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < prefix.length(); index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}