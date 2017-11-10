package com.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of test cases");
		int noOfTestCases = scanner.nextInt();
		String[] words = new String[noOfTestCases];
		scanner.nextLine();
		for (int testCase = 0; testCase < noOfTestCases; testCase++) {
			System.out.println("Enter Test case " + (testCase + 1) + ": ");
			String word = scanner.nextLine();
			words[testCase] = word;
		}

		for (String word : words) {
			if (word.length() % 2 == 1) {
				System.out.println(-1);
			} else {
				int middle = word.length() / 2;
				String wordOne = word.substring(0, middle);
				String wordTwo = word.substring(middle);
				Map<String, Integer> wordOneCount = new HashMap<>();
				for (int index = 0; index < middle; index++) {
					char char1 = wordOne.charAt(index);
					Integer count = wordOneCount.get(String.valueOf(char1));
					if (count == null)
						wordOneCount.put(String.valueOf(char1), 1);
					else
						wordOneCount.put(String.valueOf(char1), count + 1);
				}
				Integer charactersCount = 0;
				for (int index = 0; index < middle; index++) {
					char character = wordTwo.charAt(index);
					Integer count = wordOneCount.get(String.valueOf(character));
					if (count == null) {
						charactersCount++;
					} else if (count == 1) {
						wordOneCount.remove(String.valueOf(character));
					} else {
						wordOneCount.put(String.valueOf(character), count - 1);
					}
				}
				System.out.println(charactersCount);
			}
		}
	}
}
