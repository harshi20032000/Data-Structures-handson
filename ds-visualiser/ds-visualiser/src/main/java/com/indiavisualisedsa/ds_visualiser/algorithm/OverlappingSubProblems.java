package com.indiavisualisedsa.ds_visualiser.algorithm;

public class OverlappingSubProblems {

	static Integer[] memo = new Integer[100];
	
	static int fibonaci(int n) {
		if(memo[n]!=null) {
			return memo[n];
		}
		
		if(n==0 || n==1)
			return n;
		memo[n]=fibonaci(n-1)+ fibonaci(n-2);
		return memo[n];
	}
	
	public static void main(String[] args) {
		System.out.println("Count\tFibonaci");
		for(int i=0; i<=20; i++) {
			System.out.println(i+" \t: "+fibonaci(i));
		}
	}
}
