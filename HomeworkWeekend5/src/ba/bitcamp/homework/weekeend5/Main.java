package ba.bitcamp.homework.weekeend5;
public class Main {

	public static void main(String[] args) {

		Character c1 = new Character("Braconac1", "male", false);
		Character c2 = new Character("Braconac2", "male", true);
		Character c3 = new Character("Braconac3", "male", true);
		Character c4 = new Character("Braconac4", "female", false);
		Character c5 = new Character("Braconac5", "male", false);

		Event e = new Event(Event.DEFEAT);
		System.out.println(e.toString());

		Goal g = new Goal("Battle", Goal.EASY, e, c1);
		System.out.println(g);

		Protagonist p = new Protagonist("Vrhovni Braconac", "male", true, g);

		p.setEnemy(c4);

		p.addFriendCharacter(c1);
		p.addFriendCharacter(c2);

		p.attainGoal();

	}
}
