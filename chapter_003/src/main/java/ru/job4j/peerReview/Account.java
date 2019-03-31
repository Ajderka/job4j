package ru.job4j.peerReview;


//нет JavaDoc
public class Account {
    // отсутствует модификатор доступа private.
    double values;
    String reqs; //я бы поменял название переменной на requisites.

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }

    public String getReqs() {
        return this.reqs;
    }

    //нет JavaDoc
    //отутствует идентификатор доступа public
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    //отсутствует @Override
    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    //отсутствует @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    //отсутствует @Override
    public int hashCode() {
        return this.reqs.hashCode();
    }
}