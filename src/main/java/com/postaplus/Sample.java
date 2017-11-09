package com.postaplus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Sample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter test cases");
		int testCases = sc.nextInt();
		List<Set<Integer>> results = new ArrayList<>();
		for(int t = 0; t < testCases; t++) {
			//System.out.println("Enter no of awards");
			int awards = sc.nextInt();
			//System.out.println("Enter no awards cuteness");
			Set<Integer> cSet = new TreeSet<>();
			for (int a = 0; a < awards; a++) {
				cSet.add(sc.nextInt());
			}
			results.add(cSet);
		}
		for(Set<Integer> s:results) {
			Integer count = 0;
			Integer minCuteness = null;
			for(Integer ci : s) {
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
