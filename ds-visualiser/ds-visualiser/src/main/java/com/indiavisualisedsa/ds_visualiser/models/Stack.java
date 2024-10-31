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

	    public String push(int item) {
	        if (sp == n - 1) {
	            return "Stack OverFlow";
	        }
	        s[++sp] = item;
	        return "Item pushed: " + item;
	    }

	    public String pop() {
	        if (sp == -1) {
	            return "Stack UnderFlow";
	        }
	        int v = s[sp];
	        s[sp--] = 0;
	        return "Item popped: " + v;
	    }

	    public int[] getElements() {
	        return s;
	    }

	    public int size() {
	        return sp + 1; 
	    }
	    
	    public int getSP() {
	        return sp;
	    }
}
