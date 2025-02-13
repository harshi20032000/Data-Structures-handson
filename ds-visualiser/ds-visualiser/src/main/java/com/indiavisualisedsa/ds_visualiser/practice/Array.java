package com.indiavisualisedsa.ds_visualiser.practice;

public class Array {
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
        	if(Character.isLetterOrDigit(s.charAt(i)) ) {
        		sb.append(s.charAt(i));
        	}
        }
        s=sb.toString().toLowerCase();
        System.out.println(s);
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
        		return false;
        	}
        }
        return true;
    }
	
	 public static boolean isSubsequence(String s, String t) {

	        int n1=s.length();
	        int n2=t.length();
	        int i=0, j=0;
	        while(i<n1 && j<n2){
	            if(s.charAt(i)==t.charAt(j))
	            {
	                i++;
	                j++;
	            }
	            else
	            j++;
	        }
	        return i==n1;
	    }

	public static void main(String[] args) {
		//System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isSubsequence("aec", "abcde"));

	}

}
