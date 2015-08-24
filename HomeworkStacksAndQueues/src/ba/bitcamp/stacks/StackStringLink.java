package ba.bitcamp.stacks;

import java.util.EmptyStackException;

public class StackStringLink {

	private Node start;

	public StackStringLink() {
		start = null;

	}

	public boolean empty() {

		return start == null;
	}

	public String push(String value) {

		if (start == null) {

			start = new Node(value);

		} else {

			Node tmp = new Node(value);
			tmp.setNext(start);
			start = tmp;
		}
		return value;
	}

	public String peek() throws EmptyStackException {

		if (start == null) {

			throw new EmptyStackException();
		}
		return start.getValue();
	}

	public String pop() throws EmptyStackException {

		if (start == null) {

			throw new EmptyStackException();

		} else {

			String tmp = start.getValue();
			start = start.getNext();
			return tmp;
		}
	}

	public String toString() {

		if (start == null) {

			return "Link is empty";

		} else {

			return start.toString();
		}

	}

	public int search(String line) {

		int index = 1;
		if (start == null) {
			return -1;
		}

		Node tmp = start;

		if (tmp.getValue().equals(line))
			return 1;

		while (tmp.getNext() != null) {

			if (tmp.getValue().equals(line))

				return index;
			tmp = tmp.getNext();
			index++;

		}

		return -1;
	}

	public class Node {

		private Node next;
		private String value;

		public Node(String value) {
			this.value = value;
			next = null;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " , " + next.toString();
		}

	}

}