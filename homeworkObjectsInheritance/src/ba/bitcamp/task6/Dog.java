package ba.bitcamp.task6;

/**
 * Class representing dogs. Inherits atributes and methods from class Pet.
 * 
 * @author Semir
 *
 */
public class Dog extends Pet {

	private String breed;

	/**
	 * @param name
	 *            Dog`s name
	 * @param age
	 *            Age
	 * @param type
	 *            Type
	 * @param breed
	 *            Breed
	 * @throws IllegalArgumentException
	 *             When given age is less than 0
	 */
	public Dog(String name, int age, String breed)
			throws IllegalArgumentException {
		super(name, age, "dog");
		this.breed = breed;
	}

	/**
	 * @return The breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed
	 *            The breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * Returns "Av av".
	 */
	public String toString() {
		return "Av av";
	}

}