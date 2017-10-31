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
		
		Collections.sort(chocolates);
		
		int acumulator = 0;
		
		for (int i = 0; i < chocolates.size() - 1; i++) {
			int diff = chocolates.get(i + 1) - chocolates.get(i);
			if (diff != 0) {
				
				if (((int)diff / 5) > 0) {
					acumulator += diff - (diff % 5);
					count += (int) (diff / 5);
					
					diff = diff % 5;
				}
				
				if (((int)diff / 2) > 0) {
					acumulator += diff - (diff % 2);
					count += (int) (diff / 2);
					
					diff = diff % 2;
				}
				
				if (((int)diff / 1) > 0) {
					acumulator += diff - (diff % 1);
					count += (int) (diff / 1);
					
					diff = diff % 1;
				}
				
				if (chocolates.size() > i + 2) {
					chocolates.set(i + 2, chocolates.get(i + 2) + acumulator);
				}
			}
		}
			
		return count;
	}
	
}
