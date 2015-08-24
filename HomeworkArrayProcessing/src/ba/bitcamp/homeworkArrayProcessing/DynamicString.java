package ba.bitcamp.homeworkArrayProcessing;

public class DynamicString {

	private String arr[];

	private int counter;

	public DynamicString(int n, String value) {
		super();
		arr = new String[n];
		counter = n;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = value;
		}
	}

	public DynamicString(int n) {
		this(n, null);
		counter = 0;
	}

	public DynamicString() {
		this(8);
	}

	public void addElement(String element) {

		if (counter >= arr.length) {
			String temp[] = arr;
			arr = new String[arr.length * 2 + 1];

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

	public void addArrayOfElements(String[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
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
			String[] temp = new String[totalSize() / 2];
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

		String[] tmp = new String[arr.length];

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
			String[] temp = new String[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int count) {
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