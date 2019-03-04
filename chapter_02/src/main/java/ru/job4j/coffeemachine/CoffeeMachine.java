package ru.job4j.coffeemachine;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 04.03.2019.
 */
public class CoffeeMachine {
    private int value;
    private int price;


    public CoffeeMachine(int value, int price) {
        this.value = value;
        this.price = price;
    }

    private final int[] monet = new int[]{10, 5, 2, 1};
    private int[] coins = new int[monet.length];

    /**
     * метод расчета длины будущего выходного массива сдачи
     *
     * @return
     */
    private int massiveLength() {
        int count = 0;
        for (int x : this.coins) {
            count += x;
        }
        return count;
    }

    /**
     * метод подсчта количества монет и их наменалов для формирвания массива с сдачей
     * массив monet - наменалы монет
     * массив coins - кол-во монет по каждому наменалу монеты
     */
    private void numberOfCoins() throws NotEnoughMoneyExeption {
        int change = this.value - this.price;
        if (change < 0) {
            throw new NotEnoughMoneyExeption("Недостаточно денег");
        }
        for (int i = 0; i < this.monet.length && change > 0; i++) {
            coins[i] = change / monet[i];
            change -= monet[i] * coins[i];
        }
    }

    /**
     * метод заполнения резуьтирующего массива с набором монет по каждому наменалу
     *
     * @return
     */
    int[] coffeeMachine() {
        this.numberOfCoins();
        int count = 0;
        int[] rst = new int[massiveLength()];

        for (int i = 0; i < monet.length; i++) {
            for (int j = 0; j < this.coins[i]; j++) {
                rst[count++] = monet[i];
            }
        }
        return rst;
    }
}