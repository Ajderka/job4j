package ru.job4j.array;

/**
 * Class  Вопросы. Контрольное задание - создать массив сортированный по порядку,состоящий из двух сортированных массивов[#91045].
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 20.12.2018.
 */
public class ArraySort {

    /**
     * method array3 - должен отсортировать массив состоящий из двух сортированных массивов.
     *
     * @param array1 сортированный массив 1.
     * @param array2 сортированный массив 2.
     * @return сортированный массив состоящий из массивов 1 и 2.
     */
    public int[] array3(int[] array1, int[] array2) {
        int index1 = 0, index2 = 0;
        int size1 = array1.length, size2 = array2.length;
        int size3 = size1 + size2;
        int[] array3 = new int[size1 + size2];
        for (int index3 = 0; index3 < size3; index3++) {
            if (index1 > size1 - 1) {
                int tempo = array2[index2];
                array3[index3] = tempo;
                index2++;
            } else if (index2 > size2 - 1) {
                int tempo = array1[index1];
                array3[index3] = tempo;
                index1++;
            } else if (array1[index1] < array2[index2]) {
                int tempo = array1[index1];
                array3[index3] = tempo;
                index1++;
            } else {
                int temp = array2[index2];
                array3[index3] = temp;
                index2++;
            }
        }
        return array3;
    }
}
