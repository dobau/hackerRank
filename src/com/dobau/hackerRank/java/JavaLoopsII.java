package com.dobau.hackerRank.java;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaLoopsII {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            showQuery(a, b, n);
            
        }
        in.close();
    }

    private static int somatorio(int b, int n) {
    	if (n == 0) {
    		return b;
    	} else {
    		return ((2 << (n-1)) * b) + somatorio(b, n - 1);    		
    	}
    }
    
	private static void showQuery(int a, int b, int n) {
		IntStream.range(0, n).forEach(i -> System.out.printf("%s ", a + somatorio(b, i)));
		System.out.println();
	}
	
}
