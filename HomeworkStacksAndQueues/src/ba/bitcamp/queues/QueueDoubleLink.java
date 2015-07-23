package ba.bitcamp.queues;

public class QueueDoubleLink {

	private Node start;
	private Node finish;

	public QueueDoubleLink() {

		start = null;
		finish = null;
	}

	public boolean add(Double value) {
		Node n = new Node(value);

		if (start == null) {
			start = n;
			finish = n;
		} else if (start == finish) {
			n.setPrev(start);
			finish = n;
			start.next = n;
		} else {
			finish.next = n;
			n.setPrev(finish);
			finish = n;
		}
		return true;
	}

	public Double poll() {
		try {
			Double tmp = start.value;
			start = start.next;
			start.setPrev(null);
			return tmp;
		} catch (NullPointerException ex) {
			return null;
		}
	}

	public Double peek() {
		if (start == null) {
			return null;
		}

		return start.value;
	}

	public String toString() {
		if (start == null) {
			return "The list is empty";
		}

		return start.toString();
	}

	private class Node {

		Double value;
		@SuppressWarnings("unused")
		Node prev;
		Node next;

		public Node(Double value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + " ";
			}
			return value + " , " + next.toString();
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

}