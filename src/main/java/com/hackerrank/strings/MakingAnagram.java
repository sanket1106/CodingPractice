package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MakingAnagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string 1");
		String wordOne = scanner.nextLine();
		System.out.println("Enter string 2");
		String wordTwo = scanner.nextLine();
		int lengthOne = wordOne.length();
		int lengthTwo = wordTwo.length();

		int maxLength = lengthOne;
		if (lengthOne < lengthTwo)
			maxLength = lengthTwo;

		char[] charArray1 = wordOne.toCharArray();
		char[] charArray2 = wordTwo.toCharArray();

		Map<String, Integer> map = new HashMap<>();
		for (int index = 0; index < maxLength; index++) {
			if (index < lengthOne) {
				String character = String.valueOf(charArray1[index]);
				Integer count = map.get(character);
				if (count == null) {
					map.put(character, 1);
				} else {
					map.put(character, count + 1);
				}
			}

			if (index < lengthTwo) {
				String character = String.valueOf(charArray2[index]);
				Integer count = map.get(character);
				if (count == null) {
					map.put(character, 1);
				} else {
					map.put(character, count - 1);
				}
			}
		}

		Integer characterCount = 0;
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			Integer count = next.getValue();
			characterCount += count;
		}
		System.out.println(characterCount);
	}
}
