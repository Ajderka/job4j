package ru.job4j.coffeemachine;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version $Id$
 * @since 04.03.2019.
 */
public class CoffeeMachineTest {

    @Test
    public void putOnCoffeeMachineFiftyRub() {
        CoffeeMachine coffee = new CoffeeMachine(50, 35);
        int[] result = coffee.coffeeMachine();
        int[] expect = new int[]{10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void putOnCoffeeMachineOneHundredRub() {
        CoffeeMachine coffee = new CoffeeMachine(100, 35);
        int[] result = coffee.coffeeMachine();
        int[] expect = new int[]{10, 10, 10, 10, 10, 10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void putOnCoffeeMachineOneHundredTwentyThreeRub() {
        CoffeeMachine coffee = new CoffeeMachine(123, 37);
        int[] result = coffee.coffeeMachine();
        int[] expect = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 5, 1};
        assertThat(result, is(expect));
    }
}
