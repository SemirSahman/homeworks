package ba.bitcamp.homework.weekeend5;
import java.util.Arrays;

public class Protagonist extends Character {

	private Goal goal;
	private Character[] friendCharacters;
	private Character enemy;

	public Protagonist(String name, String gender, Boolean isCapable, Goal goal) {
		super(name, gender, isCapable);
		this.goal = goal;

	}

	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	public Character getEnemy() {
		return enemy;
	}

	public void addFriendCharacter(Character c) {
		int i = 0;
		try {
			friendCharacters[i] = c;
			i++;
		} catch (Exception e) {
			if (i > 4) {
				System.out
						.println("You have added max number of friend characters");
			}
		}

	}

	public void attainGoal() {
		int chance = 0;
		try {
			if (super.getIsAlive() == true) {
				if (super.getIsCapable() == true) {
					chance += 40;
				}
				for (int i = 1; i < this.friendCharacters.length; i++) {
					if (this.friendCharacters[i].getIsCapable() == true) {
						chance += 20;
					}
				}
				if (enemy.getIsCapable() == true) {
					chance -= 30;
				}
				if (goal.getLevel() == Goal.HARD) {
					chance -= 20;
				}
				if (goal.getLevel() == Goal.IMPOSSIBLE) {
					chance -= 100;
				}
				if (chance < 0) {
					chance = 0;
				} else if (chance > 100) {
					chance = 100;
				}

			} else {
				System.out.println("Your character is not alive");
			}

			// Based on the calculated odds method decide whether a character
			// succeeded or not
			if (chance >= 50) {
				System.out.println(" Succes in " + goal.getName());
				for (int i = 0; i < friendCharacters.length; i++) {
					if (friendCharacters[i].getIsCapable() == false) {
						friendCharacters[i].turnCapable();
						System.out.println("Capable become "
								+ friendCharacters[i].getName());
						break;
					} else {
						System.out.println("All assistants are capable");
					}
				}
			} else {
				System.out.println(" Failed in " + goal.getName());
				for (int i = 0; i < friendCharacters.length; i++) {
					if (friendCharacters[i].getIsCapable() == false) {
						friendCharacters[i].turnCapable();
						System.out.println("Capable became "
								+ friendCharacters[i].getName());
					} else {
						friendCharacters[i].killCharacter();
						System.out.println("Killed character is "
								+ friendCharacters[i].getName());
						break;
					}
				}
			}
		} catch (NullPointerException e) {

		}
	}

	@Override
	public String toString() {
		return "Protagonist [goal=" + goal + ", friendCharacters="
				+ Arrays.toString(friendCharacters) + ", enemy=" + enemy + "]";
	}

}
