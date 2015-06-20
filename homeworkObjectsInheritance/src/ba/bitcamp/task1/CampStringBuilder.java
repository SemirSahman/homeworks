package ba.bitcamp.task1;

/**
 * Class that is similar to StringBuilder
 * 
 * @author Semir
 *
 */
public class CampStringBuilder {

	private char[] characters;

	/**
	 * Default constructor.
	 * 
	 * @param Array
	 *            of characters
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	/**
	 * @return The array of characters
	 */
	public char[] getCharacters() {
		return characters;
	}

	/**
	 * @param characters
	 *            Array of characters
	 */
	public void setCharacters(char[] characters) {
		this.characters = characters;
	}

	/**
	 * Appends o.toString at the end of array of characters.
	 * 
	 * @param o
	 *            Any object
	 */
	public void append(Object o) {
		int oldLength = characters.length;
		int finalLength = oldLength;
		for (int i = 0; i < o.toString().length(); i++) {
			finalLength++;
		}
		char[] tmp = new char[finalLength];
		for (int i = 0; i < characters.length; i++) {
			tmp[i] = characters[i];
		}
		int counter = 0;
		for (int i = oldLength; i < tmp.length; i++) {
			tmp[i] = o.toString().charAt(counter++);
		}
		characters = tmp;
	}

	/**
	 * Prepends o.toString at the beginning of array of characters.
	 * 
	 * @param o
	 *            Any object
	 */
	public void prepend(Object o) {
		int oldLength = characters.length;
		int newLength = oldLength;
		for (int i = 0; i < o.toString().length(); i++) {
			newLength++;
		}
		char[] tmp = new char[newLength];
		for (int i = 0; i < o.toString().length(); i++) {
			tmp[i] = o.toString().charAt(i);
		}
		int counter = 0;
		for (int i = o.toString().length(); i < tmp.length; i++) {
			tmp[i] = characters[counter++];
		}
		characters = tmp;
	}

	/**
	 * Returns String representation of the array of characters.
	 * 
	 * @return String representation of the array of characters
	 */
	public String toString() { 
		String s = "";
		for (int i = 0; i < characters.length; i++) {
			s += characters[i];
		}
		return s;
	}
}