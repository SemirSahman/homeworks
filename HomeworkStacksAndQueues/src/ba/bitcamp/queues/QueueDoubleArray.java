package ba.bitcamp.queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueDoubleArray {

	private Double[] array;

	public QueueDoubleArray() {

		array = new Double[0];
	}

	public boolean add(Double num) {

		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = num;
		return true;
	}

	public Double peek() {

		if (array.length > 0) {

			return array[0];

		} else {

			return null;
		}
	}

	public Double element() throws NoSuchElementException {

		if (array.length > 0) {

			return array[0];

		} else {

			throw new NoSuchElementException();
		}

	}

	public boolean offer(Double num) {

		return add(num);
	}

	public Double remove() throws NoSuchElementException {

		if (array.length > 0) {

			double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;

		} else {

			throw new NoSuchElementException();
		}
	}

	public Double poll() {

		if (array.length > 0) {

			double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;

		} else {

			return null;
		}
	}

	public String toString() {

		return Arrays.toString(array);
	}

}