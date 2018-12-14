package ru.job4j.array;

import java.util.Arrays;

/**
 * Class  6.8. Удаление дубликатов в массиве.[#91022]
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 14.12.2018.
 */
public class ArrayDuplicate {

    /**
     * method remove - delete duplicate files in array.
     *
     * @param array - входящий массив типа String.
     * @return array without duplicate files.
     */
    public String[] remove(String[] array) {
        int size = array.length;
        for (int out = 0; out < size; out++) {
            for (int in = out + 1; in < size - 1; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[size - 1];
                    size--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
