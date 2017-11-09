package com.hackerrank.arrays;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println("Enter no of elements");
		Integer noOfElements = sc.nextInt();
		// System.out.println("Enter elements");
		Integer[] array = new Integer[noOfElements];
		for (int i = 0; i < noOfElements; i++) {
			// Integer j = sc.nextInt();
			// System.out.println("Element : " + j);
			array[i] = sc.nextInt();
		}
		Integer pointer = (array.length - 1);
		while (pointer >= 0) {
			System.out.print(array[pointer] + " ");
			pointer--;
		}
	}
}
