package com.dobau.hackerRank.algorithms;

import java.util.Scanner;
import java.util.stream.LongStream;

public class AVeryBigSum {

    static long aVeryBigSum(int n, long[] ar) {
    	return LongStream.of(ar).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextLong();
        }
        long result = aVeryBigSum(n, ar);
        System.out.println(result);
    }
    
}
