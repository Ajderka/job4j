package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int curciut = array.length - 1; curciut == 0; curciut--) {
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;

                }
            }
        }
        return array;
    }
}
