package com.dobau.hackerRank.algorithms;

import java.util.Scanner;

public class DiagonalDifference {
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	
    	int lines = scan.nextInt();
    	
    	int[][] matrix = new int[lines][lines];
    	
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix.length; j++) {
    			matrix[i][j] = scan.nextInt();
    		}
    	}
    	
    	int diff = 0;
    	for (int i = 0; i < lines; i++) {
    		diff += matrix[i][i] - matrix[i][lines - i - 1];
    	}
    	
    	diff = Math.abs(diff);
    	
    	System.out.println(diff);
    	
    	scan.close();
    }
    
}
