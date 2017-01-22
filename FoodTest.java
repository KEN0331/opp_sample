/**
 * test code for Food.
 */
public class FoodTest {
	public static void main(String[] args) {
		testInit();
		testGetKaihukuValue();
	}

	private static void testInit() {
		new Food(1, "TEST");
		new Food(1000, "TEST");

		try {
			Food food = new Food(0, "TEST");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("kaihukuValue min is 1")) throw new IllegalArgumentException();
		}
		try {
			Food food = new Food(1001, "TEST");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("kaihukuValue max is 1000")) throw new IllegalArgumentException();
		}
		try {
			Food food = new Food(1, null);
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
		try {
			Food food = new Food(1, "");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
		try {
			Food food = new Food(1, "      　");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
	}

	private static void testGetKaihukuValue() {
		Food food = new Food(1, "TEST");
		if (food.getKaihukuValue() != 1) throw new IllegalArgumentException();
	}
}
