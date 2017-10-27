package com.dobau.hackerRank.java;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaLoopsI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		IntStream.rangeClosed(1, 10).forEach(i -> System.out.printf("%d x %d = %d%n", N, i, N * i));
	}

}
