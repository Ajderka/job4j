package ru.job4j.bank;

import java.util.*;

// в классе отсутствуют JavaDoc
public class Convert {

    //Этот конструктор не нужен, он вызывается по дефолту.
    public Convert() {
    }

    //Converts array to list - коментарии нужно занести в форму JavaDoc
    //Цыклы удобнее реализовать через foreach
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }

    //нет JavaDoc
    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        /*вместо тернарнгого условия можно воспользоваться функцией
           Math.ceil */
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);

        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {  //Цыклы удобнее реализовать через foreach
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}