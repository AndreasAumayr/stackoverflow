package at.aumand.stackoverflow.question30420466;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FruitFactoryTest {

	@Test
	public void shouldCreateASmallFruit() {
		// given
		final String fruitInfoString = "apple:9";
		final FruitFactory factory = new FruitFactory();

		// when
		final Fruit fruit = factory.create(fruitInfoString);

		// then
		assertTrue(fruit instanceof SmallFruit);
		assertEquals(9, fruit.getInfo().getWeight());
	}

	@Test
	public void shouldCreateABigFruit() {
		// given
		final String fruitInfoString = "apple:11";
		final FruitFactory factory = new FruitFactory();

		// when
		final Fruit fruit = factory.create(fruitInfoString);

		// then
		assertTrue(fruit instanceof BigFruit);
		assertEquals(11, fruit.getInfo().getWeight());
	}
}
