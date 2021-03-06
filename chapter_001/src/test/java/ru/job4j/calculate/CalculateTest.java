package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @since 01.12.2018.
 * @version 1.
 */
public class CalculateTest {

	/**
	 * Test echo.
	 */
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Ayder Khayredinov";
		String expect = "Echo, echo, echo : Ayder Khayredinov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}