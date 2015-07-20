package ba.bitcamp.homeworkArrayProcessing;

public class DynamicDouble {

	private int counter;

	private double arr[];

	public DynamicDouble(int n, double value) {
		super();
		arr = new double[n];
		counter = n;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}
	}

	public DynamicDouble(int n) {
		this(n, 0.0);
		counter = 0;
	}

	public DynamicDouble() {
		this(8);
	}

	public int size() {
		return counter;
	}

	public int totalSize() {
		return arr.length;
	}

	public void removeQuick(int offset) throws IndexOutOfBoundsException {

		if (counter == 0) {
			throw new IndexOutOfBoundsException();
		}

		if (offset >= counter) {
			throw new IndexOutOfBoundsException();
		}

		arr[offset] = arr[counter - 1];
		counter--;

		if (counter <= arr.length / 3) {
			double[] temp = new double[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	public void removeSlow(int offset) throws IndexOutOfBoundsException {

		if (counter == 0) {
			throw new IndexOutOfBoundsException();
		}

		if (offset >= counter) {
			throw new IndexOutOfBoundsException();
		}

		double[] tmp = new double[arr.length];

		for (int i = 0; i < tmp.length - 1; i++) {
			if (i == offset) {
				tmp[i] = arr[++offset];
			} else {
				tmp[i] = arr[offset];
			}
			offset++;
		}
		arr = tmp;
		counter--;
		arr[counter] = arr[counter - 1];

		if (counter <= arr.length / 3) {
			double[] temp = new double[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	public void addElement(double element) {

		if (counter >= arr.length) {
			double temp[] = arr;
			arr = new double[arr.length * 2 + 1];

			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}

			arr[counter] = element;
			counter++;

		} else if (counter < arr.length) {
			arr[counter] = element;
			counter++;
		}
	}

	public void addArrayOfElements(double[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
	}

	public double[] getArr() {
		return arr;
	}

	public void setArr(double[] arr) {
		this.arr = arr;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String toString() {
		String str = "";
		if (counter > 0) {
			str += size() + "\t[ ";
			for (int i = 0; i < counter - 1; i++) {
				str += arr[i] + ", ";
			}

			str += arr[counter - 1] + " ]\n" + totalSize() + "\t[ ";

			for (int i = 0; i < arr.length - 1; i++) {
				str += arr[i] + ", ";
			}
			str += arr[arr.length - 1] + " ]";
		} else {
			str += size() + "\t[]";
		}
		return str;
	}

}