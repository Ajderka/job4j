package ru.job4j.lambda;

import org.junit.Test;


import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 18.05.2019.
 */
public class StudentTest {

    @Test
    public void returnListOfStudentsWhoHaveAHigherScoreOfBound() {

        List<Student> students = List.of(
                new Student("Бельчиков Сергей", 78),
                new Student("Бессараб Екатерина", 68),
                new Student(null, 0),
                new Student("Бобина Ирина", 81),
                new Student("Бурыгина Анастасия", 79),
                new Student(null, 0),
                new Student("Вечерко Ирина", 76),
                new Student("Галазыка Михаил", 77),
                new Student(null, 0),
                new Student("Гундар Антон", 53),
                new Student("Гундер Марьян", 67),
                new Student(null, 0),
                new Student("Гуржий Павел", 44),
                new Student(null, 0),
                new Student("Козловский Сергей", 45),
                new Student(null, 0),
                new Student("Костенко Анастасия", 56),
                new Student("Кучерова Алена", 87)
        );

        List<Student> expected = List.of(
                new Student("Кучерова Алена", 87),
                new Student("Бобина Ирина", 81),
                new Student("Бурыгина Анастасия", 79),
                new Student("Бельчиков Сергей", 78),
                new Student("Галазыка Михаил", 77),
                new Student("Вечерко Ирина", 76),
                new Student("Бессараб Екатерина", 68),
                new Student("Гундер Марьян", 67)
        );
        assertThat(Student.levelOf(students, 60), is(expected));
    }

}
