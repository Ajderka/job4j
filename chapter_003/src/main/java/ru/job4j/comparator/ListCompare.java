package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int size = left.length();
        if (left.length() < right.length()) {
            size = right.length();
        }

        char[] leftMassive = toCharArray(size, left);
        char[] rightMassive = toCharArray(size, right);

        int result = 0;
        for (int i = 0; i < size; i++) {
            if (Character.compare(leftMassive[i], rightMassive[i]) < 0) {
                result = -1;
                break;
            } else if (Character.compare(leftMassive[i], rightMassive[i]) > 0) {
                result = 1;
                break;
            }
        }
        if(result == 0) {
            result = Math.abs(left.length() - right.length());
        }
        return result;
    }

    private char[] toCharArray(int massiveSize, String str) {
        char[] massive = new char[massiveSize];
        for (int index = 0; index < str.length(); index++) {
            massive[index] = str.charAt(index);
        }
        return massive;
    }
}