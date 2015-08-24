package ba.bitcamp.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackStringArray {

	private String[] array;

	public StackStringArray() {

		array = new String[0];
	}

	public boolean empty() {

		return (array.length == 0);
	}

	public String push(String line) {

		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = line;
		return line;

	}

	public String pop() throws EmptyStackException {

		if (array.length > 0) {

			String temp = array[array.length - 1];
			array = Arrays.copyOf(array, array.length - 1);

			return temp;

		} else {

			throw new EmptyStackException();
		}

	}

	public String peek() throws EmptyStackException {

		if (array.length > 0) {

			return array[array.length - 1];

		} else {

			throw new EmptyStackException();
		}
	}

	public int search(String line) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			if (array[i].toString().equals(line))
				;

			temp = i;

		}
		temp = -1;

		return temp;

	}

	public String toString() {

		return Arrays.toString(array);
	}

}