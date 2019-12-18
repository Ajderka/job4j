package model;

public enum Months {

    ЯНВ(1),
    ФЕВ(2),
    МАР(3),
    АПР(4),
    МАЙ(5),
    ИЮН(6),
    ИЮЛ(7),
    АВГ(8),
    СЕН(9),
    ОКТ(10),
    НОЯ(11),
    ДЕК(12);

    public int number;

    Months(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Months{" +
                "number=" + number +
                '}';
    }
}
