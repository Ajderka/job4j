package ru.job4j.coffeemachine;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 04.03.2019.
 */
public class CoffeeMachine {
    private final int[] monet = new int[]{10, 5, 2, 1};
    private int[] coins = new int[monet.length];

    /**
     * метод расчета длины будущего выходного массива сдачи.
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
     * метод реализует основную логику кофемашины.
     *
     * @return
     */
    int[] change(int value, int price) {
        int ostatok = value - price;

        if (ostatok < 0) {
            throw new NotEnoughMoneyExeption("Недостаточно денег");
        }

        for (int i = 0; i < this.monet.length && ostatok > 0; i++) {
            coins[i] = ostatok / monet[i];
            ostatok -= monet[i] * coins[i];
        }

        int[] rst = new int[massiveLength()];
        int count = 0;
        for (int temp = 0; temp < monet.length; temp++) {
            for (int j = 0; j < this.coins[temp]; j++) {
                rst[count++] = monet[temp];
            }
        }
        return rst;
    }
}