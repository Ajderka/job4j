package ru.job4j.array;

/**
 * Class  6.5. Создать программу для сортировки массива методом перестановки.[#91021]
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 12.12.2018.
 */
public class BubbleSort {

    /**
     * method sort - должен сортировать массив целых чисел, используя алгоритм сортировки пузырьком.
     *
     * @param array массив не сортированный.
     * @return сортированный массив.
     */
    public int[] sort(int[] array) {
        boolean simple = true;
        int x = array.length;
        while (simple) {
            simple = false;
            int y = 0;
            for (int index = 0; index < x - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;
                    simple = true;
                }
            }
            x--;
        }
        return array;
    }
}
