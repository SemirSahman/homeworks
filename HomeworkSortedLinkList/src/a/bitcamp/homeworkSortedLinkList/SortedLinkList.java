package a.bitcamp.homeworkSortedLinkList;

public class SortedLinkList {

	private Node start;
	private int counter;

	public SortedLinkList() {
		this.start = null;
		this.counter = 0;
	}

	public boolean empty() {
		return start == null;
	}

	public int getLength() {
		return counter;
	}

	public void add(int value) {
		boolean isLarger = true;

		Node newNode = new Node(value);
		if (start == null) {
			start = newNode;
		} else if (start.getValue() > value) {
			newNode.setNext(start);
			start = newNode;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				if (temp.getNext().getValue() >= value) {
					temp = temp.getNext();
					isLarger = false;
					break;
				} else {
					temp = temp.getNext();
				}
			}
			if (!isLarger) {
				Node previous = getPrevious(temp);
				previous.setNext(newNode);
				newNode.setNext(temp);
			} else {
				temp.setNext(newNode);
			}
		}
		counter++;
	}

	private Node getPrevious(Node node) {
		if (node == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != node) {
			temp = temp.getNext();
		}

		return temp;
	}

	public int get(int index) {
		if (start == null) {
			return -1;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getValue();
		}
	}

	public int[] toArray() {
		int[] array = new int[counter];
		for (int i = 0; i < array.length; i++) {
			array[i] = this.get(i);
		}
		return array;
	}

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + ", " + next.toString();
		}

		public int getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public String toString() {
		if (start == null) {
			return "The list is empty.";
		}
		return start.toString();
	}
}