package com.postaplus;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NoOfProcessesToBeKilled {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter test cases");
		int testCases = sc.nextInt();
		System.out.println("Enter no of processes running");
		for(int t = 0; t < testCases; t++) {
			int noOfProcesses = sc.nextInt();
			System.out.println("Enter memory required");
			int memRequired = sc.nextInt();
			TreeSet<Integer> cSet = new TreeSet<>();
			System.out.println("Enter memory used by each running process");
			for(int n=0; n<noOfProcesses;n++) {
				cSet.add(sc.nextInt());
			}
			Set<Integer> dSet = cSet.descendingSet();
			Integer freedMemory = 0;
			Integer noOfProcessesKilled = 0;
			for(Integer m : dSet) {
				if(freedMemory >= memRequired) {
					break;
				} 
				freedMemory+=m;
				noOfProcessesKilled+=1;
			}
			if(noOfProcessesKilled>0)
				System.out.println(noOfProcessesKilled);
			else 
				System.out.println(-1);
		}
	}
}
