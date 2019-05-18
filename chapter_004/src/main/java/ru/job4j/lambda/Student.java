package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 17.05.2019.
 */
public class Student implements Comparator<Student> {
    private String name;

    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    /**
     * Метод возвращает список студентов у которых балл аттестата больше bound.
     *
     * @param students список студентов.
     * @param bound балл атестата.
     *
     * @return список студентов.
     */
    List<Student> levelOf(List<Student> students, int bound){
        return students.stream()
                .sorted()
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        int result = 0;
        if (o1.getScope() > o2.getScope()) {
            result = 1;
        }
        else if (o1.getScope() < o2.getScope()) {
            result = -1;
        }
        return result;
    }
}
