package com.postaplus;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sample1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t = 0; t < testCases; t++) {
			int noOfProcesses = sc.nextInt();
			int memRequired = sc.nextInt();
			TreeSet<Integer> cSet = new TreeSet<>();
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
