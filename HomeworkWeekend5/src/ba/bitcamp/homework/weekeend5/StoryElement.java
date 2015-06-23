package ba.bitcamp.homework.weekeend5;
public abstract class StoryElement {

	private String name;

	public StoryElement(String name) {
		super();
		this.name = name;
	}

	public StoryElement() {
		super();
		this.name = ("STElement");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
