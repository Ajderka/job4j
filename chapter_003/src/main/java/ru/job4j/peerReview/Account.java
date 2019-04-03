package ru.job4j.peerReview;

import java.util.Objects;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.04.2019.
 */
public class Account {

    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.values;
    }

    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Метод осуществляет перевод указанного количества средств на указанный счет.
     *
     * @param destination счет на который переводятся деньги.
     * @param amount      количество средств.
     * @return true если перевод обработан.
     */
    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    @Override
    public String toString() {
        String result;
        result = "Account{" + "values=" + values + ", requisites='" + requisites + "\\" + "}";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return (values == this.values)
                && (requisites != null && requisites.equals(account.requisites));
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, requisites);
    }
}