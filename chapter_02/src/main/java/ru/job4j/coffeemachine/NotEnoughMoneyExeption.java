package ru.job4j.coffeemachine;

public class NotEnoughMoneyExeption extends RuntimeException {
    public NotEnoughMoneyExeption(String notMoney) {
        System.out.println("Ошибочка, " + notMoney);
    }
}