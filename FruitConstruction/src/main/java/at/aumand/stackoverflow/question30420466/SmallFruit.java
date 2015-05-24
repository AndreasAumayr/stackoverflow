package at.aumand.stackoverflow.question30420466;

public class SmallFruit extends Fruit {
	public SmallFruit(final FruitInfo info) {
		super(info);
	}

	@Override
	public String toString() {
		return "SmallFruit [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
