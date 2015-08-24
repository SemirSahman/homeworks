package ba.bitcamp.homework22.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task4 {

	public static void main(String[] args) {

		Map<Integer, ArrayList<Integer>> map = getMap(3, 5);
		System.out.println(map);

	}

	public static Map<Integer, ArrayList<Integer>> getMap(int keyLimit,
			int valueLimit) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i < keyLimit + 1; i++) {
			ArrayList<Integer> tmpList = new ArrayList<Integer>();
			for (int j = 0; j < valueLimit; j++) {
				tmpList.add(i * j + 1);
			}
			map.put(i, tmpList);
		}
		return map;
	}
}