package com.postaplus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class NumberDifferenceProblem {

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
			for (int a = 0; a < awards; a++) {
				cSet.add(sc.nextInt());
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
					System.out.println((ci-minCuteness)+" ");
					break;
				}
			}
		}
	}
}
