package com.hackerrank.sorting;

import java.util.Scanner;

public class InsertIntoInsertionSort {

	public static void insertIntoSorted(int[] ar) {
		Integer e = ar[ar.length - 1];
		Integer index = ar.length - 1;
		while (index >= 0) {
			if (index == 0) {
				ar[index] = e;
				printArray(ar);
				break;
			}
			if (e < ar[index - 1]) {
				ar[index] = ar[index - 1];
				printArray(ar);
				index--;
			} else {
				ar[index] = e;
				printArray(ar);
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
