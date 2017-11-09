package com.hackerrank.arrays;

import java.util.Scanner;

public class LeftRotation {

	public static int[] leftRotation(int[] a, int d) {
		if (d == a.length) {
			return a;
		} else {
			reverseArray(a, 0, d - 1);
			reverseArray(a, d, a.length - 1);
			reverseArray(a, 0, a.length - 1);
		}
		return a;
	}

	private static int[] reverseArray(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] result = leftRotation(a, d);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}
