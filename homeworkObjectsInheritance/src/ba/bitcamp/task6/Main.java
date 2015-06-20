package ba.bitcamp.task6;

import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {

		Dog d = new Dog("Negro", 1, "American Staffordshire Terrier");
		Cat c = new Cat("Cicko", 2);
		Pet[] p = new Pet[] { d, c };
		System.out.println(d);
		System.out.println(c);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p.toString());
		}

	}
}