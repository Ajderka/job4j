package ru.job4j.array;

/**
 * Class  6.2. Перевернуть массив.[#91024].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 10.12.2018.
 */
public class Turn {

    /**
     * Method back - переворачивает массив задом на перед.
     *
     * @param array - вводим массив типа int.
     * @return выводим перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index <= array.length / 2 - 1; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}