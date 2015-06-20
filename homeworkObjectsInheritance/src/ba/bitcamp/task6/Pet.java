package ba.bitcamp.task6;

/**
 * Class representing pets.
 * 
 * @author Semir
 *
 */
public class Pet {

	private String name;
	private int age;
	private String type;

	/**
	 * @param name
	 *            Pet`s name
	 * @param age
	 *            Age
	 * @param type
	 *            Type
	 * @throws IllegalArgumentException
	 *             When given age is less than 0
	 */
	public Pet(String name, int age, String type)
			throws IllegalArgumentException {
		super();
		if (age < 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.age = age;
		this.type = type;
	}

	/**
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            The age to set
	 * @throws IllegalArgumentException
	 *             When given age is less than 0
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age < 0) {
			throw new IllegalArgumentException();
		}
		this.age = age;
	}

	/**
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set
	 * @throws When
	 *             given type does not match object
	 */
	public void setType(String type) throws IllegalArgumentException {
		if (!type.equals("Dog") && this instanceof Dog) {
			throw new IllegalArgumentException();
		} else if (!type.equals("Cat") && this instanceof Cat) {
			throw new IllegalArgumentException();
		}
		this.type = type;
	}
}