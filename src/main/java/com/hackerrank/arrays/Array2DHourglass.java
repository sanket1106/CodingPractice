package com.hackerrank.arrays;

import java.util.Scanner;

public class Array2DHourglass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		Integer maxSum = -10000;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				Integer sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		System.out.println(maxSum);
	}
}
