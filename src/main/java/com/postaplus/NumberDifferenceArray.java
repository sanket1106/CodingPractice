package com.postaplus;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NumberDifferenceArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter test cases");
		int testCases = sc.nextInt();
		Set<Set<Integer>> results = new HashSet<>();
		for(int t = 0; t < testCases; t++) {
			System.out.println("Enter no of awards");
			int awards = sc.nextInt();
			System.out.println("Enter no awards cuteness");
			Set<Integer> cSet = new TreeSet<>();
			Integer[] array = {0,0,0};
			for (int a = 0; a < awards; a++) {
				int cuteness = sc.nextInt();
				if(array[0] == 0) {
					array[0] = cuteness;
				}
			}
			Integer count = 0;
			Integer minCuteness = null;
			for(Integer ci : cSet) {
				if(count==0)
					minCuteness = ci;
				System.out.print(ci);
				System.out.print(" ");
				count++;
				if(count==3) {
					System.out.print(ci-minCuteness);
					System.out.println(" ");
					break;
				}
			}
		}
	}
}
