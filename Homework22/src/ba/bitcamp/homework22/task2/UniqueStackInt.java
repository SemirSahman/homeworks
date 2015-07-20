package ba.bitcamp.homework22.task2;

import java.util.EmptyStackException;

public class UniqueStackInt {

	private Node head;

	public int push(int value) {
		if (head == null) {
			head = new Node(value);
			return value;
		}
		Node tmp = head;
		while (tmp.getNext() != null) {
			if (tmp.getValue() == value)
				return value;
			tmp = tmp.getNext();
		}
		tmp = new Node(value);
		tmp.setNext(head);
		head = tmp;
		return value;
	}

	public int pop() throws EmptyStackException {
		if (head == null)
			throw new EmptyStackException();
		int value = head.getValue();
		head = head.getNext();
		return value;
	}

	public boolean isIncreasing() {
		if (head == null)
			return true;
		int tmpValue = head.getValue();
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			if (tmpValue <= tmp.getValue()) {
				tmpValue = tmp.getValue();
			} else {
				return false;
			}
		}
		return true;
	}

	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			if (next == null)
				return String.valueOf(value);
			return value + ", " + next.toString();
		}
	}
}
