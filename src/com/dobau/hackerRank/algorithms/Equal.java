package com.dobau.hackerRank.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Equal {
	
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int testCases = scan.nextInt();
		
		List<Integer> results = new ArrayList<Integer>();
		IntStream.range(0, testCases).forEach(i -> {
			
			int colleagues = scan.nextInt();
			
			List<Integer> chocolates = new ArrayList<Integer>();
			for (int j = 0; j < colleagues; j++) {
				chocolates.add(scan.nextInt());
			}
			
			results.add(countOperations(colleagues, chocolates));
		});
		
		scan.close();
		
		results.stream().forEach(System.out::println);
	}

	private static Integer countOperations(int colleagues, List<Integer> chocolates) {
		int count = 0;
		
		int firstDiffIndex = 0;
		
		while ((firstDiffIndex = findFirstDiffOf(chocolates, firstDiffIndex)) != -1) {
			Collections.sort(chocolates);
			
			boolean equal = true;
			
			for (int i = 0; i < chocolates.size() - 1 && equal; i++) {
				int diff = chocolates.get(i + 1) - chocolates.get(i);
				if (diff != 0) {
					equal = false;
					
					int chocolateToGive = 0;
					
					if (diff >= 5) {
						chocolateToGive = diff - (diff % 5);
						count = count + (int) (diff / 5);
					} else if (diff >= 2) {
						chocolateToGive = diff - (diff % 2);
						count = count + (int) (diff / 2);
					} else {
						chocolateToGive = diff - (diff % 1);
						count = count + (int) (diff / 1);
					}
					
					giveChocolatesExceptoTo(chocolates, chocolateToGive, i + 1);
				}
			}
			
		}
			
		return count;
	}

	private static void giveChocolatesExceptoTo(List<Integer> chocolates, int chocolateToGive, int choosedColleagueIndex) {
		for (int i = 0; i < chocolates.size();i++) {
			if (choosedColleagueIndex != i) {
				chocolates.set(i, chocolates.get(i) + chocolateToGive);
			}
		}
	}

	private static int findFirstDiffOf(List<Integer> chocolates, int of) {
		for (int i = of; i < chocolates.size(); i++) {
			if (!chocolates.get(0).equals(chocolates.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
}
