package com.indiavisualisedsa.ds_visualiser.models;

public class Stack {

	    private int[] s; 
	    private int sp;  
	    private int n;   

	    public Stack(int size) {
	        n = size;
	        s = new int[n];
	        sp = -1; 
	    }

	    public void push(int item) {
	        if (sp == n - 1) {
	            return; 
	        }
	        s[++sp] = item; 
	    }

	    public int pop() {
	        int v = s[sp]; 
	        s[sp--] = 0;
	        return v;
	    }

	    public int[] getElements() {
	        return s;
	    }

	    public int size() {
	        return sp + 1; 
	    }
}
