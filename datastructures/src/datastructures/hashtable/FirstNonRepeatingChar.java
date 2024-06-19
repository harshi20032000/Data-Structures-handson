package datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function called firstNonRepeatingChar(String) that finds the first
 * non-repeating character in the given string using a hash table (HashMap). If
 * there is no non-repeating character in the string, the function should return
 * null.
 * 
 * For example, if the input string is "leetcode", the function should return
 * "l" because "l" is the first character that appears only once in the string.
 * Similarly, if the input string is "hello", the function should return "h"
 * because "h" is the first non-repeating character in the string.
 */
public class FirstNonRepeatingChar {
	public static Character firstNonRepeatingChar(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (char eachChar : s.toCharArray()) {
			charCount.put(eachChar, charCount.getOrDefault(eachChar, 0) + 1);
		}
		System.out.println(charCount);
		
		for (int i=0; i<s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
			
		}
		
		return null;

	}

	public static void main(String[] args) {
		System.out.println(firstNonRepeatingChar("leetcode"));
		System.out.println(firstNonRepeatingChar("hello"));
		System.out.println(firstNonRepeatingChar("aabbcc"));

		/*
		 * EXPECTED OUTPUT: ---------------- l h null
		 * 
		 */

	}
}
