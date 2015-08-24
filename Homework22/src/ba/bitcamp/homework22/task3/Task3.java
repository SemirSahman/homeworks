package ba.bitcamp.homework22.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task3 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		list.add(4);
		list.add(9);
		list.add(1);
		list.add(8);
		list.add(7);
		System.out.println("Original list: " + list);

		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			int tmp = it.next();
			if (it.hasNext()) {
				it.remove();
				tmp += it.next();
				it.set(tmp);
			}
		}
		System.out.println("Modified list: " + list);

	}
}