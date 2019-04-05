package ru.job4j.bank;

import java.util.Objects;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.04.2019.
 */
public class User implements Comparable<User> {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (name != null && name.equals(user.name)) &&
                (passport != null && passport.equals(user.passport));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(User user) {
        int temp = this.name.compareTo(user.name);
        return temp == 0 ? this.passport.compareTo(user.passport) : temp;
    }
}
