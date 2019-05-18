package ru.job4j.lambda;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 17.05.2019.
 */
public class Student implements Comparable<Student> {

    private String name;
    private Integer scope;

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
     * @param bound    балл атестата.
     * @return список студентов.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted()
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scope=" + scope +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return scope == student.scope &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    @Override
    public int compareTo(Student o) {
        return o.scope.compareTo(this.scope);
    }
}
