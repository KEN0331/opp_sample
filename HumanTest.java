/**
 * test code for Human.
 */
public class HumanTest {
	public static void main(String[] args) {
		testInit();
		testEat();
		testEatSome();
	}

	private static void testInit() {
		new Human(1, "TEST");
		new Human(10000, "TEST");

		try {
			Human human = new Human(0, "TEST");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("hp min is 1")) throw new IllegalArgumentException();
		}
		try {
			Human human = new Human(10001, "TEST");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("hp max is 10000")) throw new IllegalArgumentException();
		}
		try {
			Human human = new Human(1, null);
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
		try {
			Human human = new Human(1, "");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
		try {
			Human human = new Human(1, "      　");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			if (!e.getMessage().equals("name is empty")) throw new IllegalArgumentException();
		}
	}

	private static void testEat() {
		Human human = new Human(100, "TEST");
		if (human.getHp() != 100) throw new IllegalArgumentException();

		// food to eat
		Taiyaki taiyaki = new Taiyaki();

		human.eat(taiyaki);
		if (human.getHp() != (100 + Taiyaki.PREFARENCE_KAIHUKUVALUE)) throw new IllegalArgumentException();
	}

	private static void testEatSome() {
		Human human = new Human(100, "TEST");
		if (human.getHp() != 100) throw new IllegalArgumentException();

		// food to eat
		Taiyaki taiyaki = new Taiyaki();
		Medamayaki medamayaki = new Medamayaki();
		Food foods[] = {taiyaki, medamayaki};

		human.eatSome(foods);
		if (human.getHp() != (100 + Taiyaki.PREFARENCE_KAIHUKUVALUE + Medamayaki.PREFARENCE_KAIHUKUVALUE)) throw new IllegalArgumentException();
	}
}
