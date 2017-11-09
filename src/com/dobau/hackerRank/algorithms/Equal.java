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
			
			results.add(countOperations(chocolates));
		});
		
		scan.close();
		
		results.stream().forEach(System.out::println);
	}
	
	private static Integer countOperations(List<Integer> chocolates) {
		int count = Integer.MAX_VALUE;
		
		Collections.sort(chocolates);
		
		int minChocolate = chocolates.get(0); 
		
		for (int i = 0; i  < 5 ; i++) {
			int countPartial = 0;
			int baseline = minChocolate - i;
			
			for (int j = 0; j < chocolates.size(); j++) {
				countPartial += (chocolates.get(j) - baseline) / 5;
				countPartial += ((chocolates.get(j) - baseline) % 5) / 2;
				countPartial += (((chocolates.get(j) - baseline) % 5) % 2) / 1;
			}
			
			if (countPartial < count) {
				count = countPartial;
			}
			
		}
			
		return count;
	}

}
