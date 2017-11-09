package com.hackerrank.arrays;

import java.util.Scanner;

public class SparceArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// System.out.println("Enter size of array");
		int size = in.nextInt();
		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			array[i] = in.next();
		}
		// System.out.println("Enter size of array");
		int querySize = in.nextInt();
		String[] queryArray = new String[querySize];
		for (int i = 0; i < querySize; i++) {
			queryArray[i] = in.next();
		}

		printOccurences(size, array, querySize, queryArray);
		printOccurences1(size, array, querySize, queryArray);
	}

	/**
	 * @param size
	 * @param array
	 * @param querySize
	 * @param queryArray
	 */
	private static void printOccurences(int size, String[] array, int querySize, String[] queryArray) {
		for (int i = 0; i < querySize; i++) {
			int occurrence = 0;
			for (int j = 0; j < size; j++) {
				if (queryArray[i].equals(array[j]))
					occurrence += 1;
			}
			System.out.println(occurrence);
		}
	}

	/**
	 * @param size
	 * @param array
	 * @param querySize
	 * @param queryArray
	 */
	private static void printOccurences1(int size, String[] array, int querySize, String[] queryArray) {
		for (int i = 0; i < querySize; i++) {
			int occurrence = 0;
			for (int j = 0; j < size; j++) {
				String query = queryArray[i];
				String string = array[j];
				if (query.length() == string.length()) {
					char[] queryCharArray = query.toCharArray();
					char[] stringCharArray = string.toCharArray();
					int k = 0;
					for (; k < queryCharArray.length; k++) {
						if (queryCharArray[k] != stringCharArray[k])
							break;
					}
					if (k == queryCharArray.length)
						occurrence += 1;
				}
			}
			System.out.println(occurrence);
		}
	}
}
