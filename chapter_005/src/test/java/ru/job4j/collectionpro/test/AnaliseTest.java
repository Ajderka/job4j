package ru.job4j.collectionpro.test;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 30.07.2019.
 */
public class AnaliseTest {

    private Analise analise = new Analise();

    @Test
    public void wasAddedUserThenCallStatistic() {
        List<Analise.User> userPrevious = Arrays.asList(
                new Analise.User(1, "Valya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha")
        );
        List<Analise.User> userCurrent = Arrays.asList(
                new Analise.User(1, "Valya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha"),
                new Analise.User(4, "Valya"),
                new Analise.User(5, "Petya")
        );
        Analise.Info info = analise.diffMap(userPrevious, userCurrent);
        assertThat(info.getAdded(), is(2));
    }

    @Test
    public void wasChangeUserThenCallStatistic() {
        List<Analise.User> userPrevious = Arrays.asList(
                new Analise.User(1, "Valya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha")
        );
        List<Analise.User> userCurrent = Arrays.asList(
                new Analise.User(1, "Olya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha")
        );
        Analise.Info info = analise.diffMap(userPrevious, userCurrent);
        assertThat(info.getChanged(), is(1));
    }

    @Test
    public void wasDeleteUserThenCallStatistic() {
        List<Analise.User> userPrevious = Arrays.asList(
                new Analise.User(1, "Valya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha"),
                new Analise.User(4, "Valya"),
                new Analise.User(5, "Petya")
        );
        List<Analise.User> userCurrent = Arrays.asList(
                new Analise.User(1, "Valya"),
                new Analise.User(2, "Petya"),
                new Analise.User(3, "Sasha")
        );
        Analise.Info info = analise.diffMap(userPrevious, userCurrent);
        assertThat(info.getDeleted(), is(2));
    }
}