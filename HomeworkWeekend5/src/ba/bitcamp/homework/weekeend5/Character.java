package ba.bitcamp.homework.weekeend5;
public class Character extends StoryElement {

	private String gender;
	private Boolean isAlive;
	private Boolean isCapable;

	public void killCharacter() {
		this.isAlive = false;
	}

	public void turnCapable() {
		isCapable = true;
	}

	public Character(String name, String gender, Boolean isCapable) {
		super(name);
		this.gender = gender;
		this.isAlive = true;
		this.isCapable = isCapable;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsCapable() {
		return isCapable;
	}

	public void setIsCapable(Boolean isCapable) {
		this.isCapable = isCapable;
	}

	@Override
	public String toString() {
		return "Character [gender=" + gender + ", isAlive=" + isAlive
				+ ", isCapable=" + isCapable + "]";
	}

}
