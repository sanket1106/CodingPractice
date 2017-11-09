package com.hackerrank.searching;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class MissingNumbersInTwoLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int listOneSize = sc.nextInt();
		TreeMap<Integer, Integer> mapWithCount = new TreeMap<>();
		for (int i = 0; i < listOneSize; i++) {
			Integer element = sc.nextInt();
			Integer count = mapWithCount.get(element);
			if (count != null) {
				count += 1;
			} else {
				count = 1;
			}
			mapWithCount.put(element, count);
		}
		int listTwoSize = sc.nextInt();
		for (int i = 0; i < listTwoSize; i++) {
			Integer element = sc.nextInt();
			Integer count = mapWithCount.get(element);
			if (count != null) {
				if (count == 0) {
					count = 1;
				} else if (count == 1) {
					count = 0;
				} else {
					count -= 1;
				}
				mapWithCount.put(element, count);
			}

		}

		if (mapWithCount.size() > 0) {
			Iterator<Entry<Integer, Integer>> iterator = mapWithCount.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, Integer> pair = iterator.next();
				System.out.print(pair.getKey() + " ");
			}
		} else {
			System.out.println("");
		}
	}
}
