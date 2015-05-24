package at.aumand.stackoverflow.question30420466;

public class Fruit {
	private final FruitInfo info;

	public Fruit(final FruitInfo info) {
		this.info = info;
	}

	public FruitInfo getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[info=" + info + "]";
	}
}
