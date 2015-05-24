package at.aumand.stackoverflow.question30420466;

public class FruitFactory {
	public Fruit create(final String fruitInfo) {
		final FruitInfo info = parseFruitInfo(fruitInfo);
		if (info.getWeight() > 10) {
			return new BigFruit(info);
		}
		return new SmallFruit(info);
	}

	private FruitInfo parseFruitInfo(final String fruitInfo) {
		// very basic "parsing", error checks omited.
		final int indexOfColon = fruitInfo.indexOf(":");
		final String name = fruitInfo.substring(0, indexOfColon - 1);
		final String weight = fruitInfo.substring(indexOfColon + 1);
		return new FruitInfo(name, Integer.valueOf(weight).intValue());
	}
}
