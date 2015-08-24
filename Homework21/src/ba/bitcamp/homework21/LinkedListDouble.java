package ba.bitcamp.homework21;

public class LinkedListDouble {

	private Node start;
	private int count;

	public LinkedListDouble() {
		this.start = null;
		this.count = 0;
	}

	public LinkedListDouble(LinkedListDouble list) {
		Node temp = list.start;
		while (temp.getNext() != null) {
			add(temp.getValue());
			temp = temp.getNext();
		}
		add(temp.getValue());
	}

	public int size() {
		return count;
	}

	public void add(Double value) {
		if (start == null) {
			start = new Node(value);
		} else {
			Node temp = getLastNode();
			temp.setNext(new Node(value));
		}
		count++;
	}

	private Node getLastNode() {
		Node temp = start;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			start = start.getNext();
			count--;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			Node previous = getPreviousNode(temp);
			previous.setNext(temp.getNext());
			count--;
		}
	}

	private Node getPreviousNode(Node node) {

		Node temp = start;

		while (temp.getNext() != node) {
			temp = temp.getNext();
		}

		return temp;
	}

	public Double get(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			return temp.getValue();
		}
	}

	public Double middle() {
		Node last = start.getNext();
		Node middle = start;

		while (last.getNext() != null) {
			if (last.getNext().getNext() != null) {
				middle = middle.getNext();
				last = last.getNext().getNext();
			} else {
				middle = middle.getNext();
				last = last.getNext();
			}
		}
		return middle.getValue();
	}

	public Double getFirst() {
		if (start == null) {
			return null;
		} else {
			return start.getValue();
		}
	}

	public Double getLast() {
		return getLastNode().getValue();
	}

	public void deleteFirst() {
		remove(0);
	}

	public void deleteLast() {
		remove(count - 1);
	}

	public void add(Double value, int index) throws IndexOutOfBoundsException {
		Node newNode = new Node(value);
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			newNode.setNext(start);
			start = newNode;
			count++;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			Node previous = getPreviousNode(temp);
			previous.setNext(newNode);
			newNode.setNext(temp);
			count++;
		}
	}

	public String toString() {
		if (start == null) {
			return "The list is empty.";
		}
		return start.toString();
	}

	private class Node {

		private Double value;
		private Node next;

		public Node(Double value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + ", " + next.toString();
		}

		public Double getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}