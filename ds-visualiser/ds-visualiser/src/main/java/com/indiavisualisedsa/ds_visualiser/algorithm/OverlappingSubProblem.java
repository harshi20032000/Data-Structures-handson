package com.indiavisualisedsa.ds_visualiser.algorithm;

public class OverlappingSubProblem {

	static int fibonaci(int n) {
		int counter = 0;
		if(n==0 || n==1)
			return n;
		return fibonaci(n-1)+ fibonaci(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println("Count\tFibonaci");
		for(int i=0; i<=20; i++) {
			System.out.println(i+" \t: "+fibonaci(i));
		}
	}
}
