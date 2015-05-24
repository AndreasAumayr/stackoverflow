package at.aumand.stackoverflow.question30420466;

public final class FruitInfo {
	private final String name;
	private final int weight;

	public FruitInfo(final String name, final int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "FruitInfo [name=" + name + ", weight=" + weight + "]";
	}
}
