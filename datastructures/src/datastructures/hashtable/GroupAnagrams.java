package datastructures.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have been given an array of strings, where each string may contain only
 * lowercase English letters. You need to write a method groupAnagrams(String[]
 * strings) that groups the anagrams in the array together using a hash table
 * (HashMap). The method should return a list of lists, where each inner array
 * contains a group of anagrams.
 * 
 * For example, if the input array is ["eat", "tea", "tan", "ate", "nat",
 * "bat"], the method should return [["eat","tea","ate"],["tan","nat"],["bat"]]
 * because the first three strings are anagrams of each other, the next two
 * strings are anagrams of each other, and the last string has no anagrams in
 * the input array.
 */
public class GroupAnagrams {
	
	public static List<List<String>> groupAnagrams(String[] strings) {
		Map<String, List<String>> kv = new HashMap<>();
		for (String eS : strings) {
			char[] charArray = eS.toCharArray();
			Arrays.sort(charArray);
			String key = String.valueOf(charArray);
			if (kv.containsKey(key)) {
				kv.get(key).add(eS);
			} else {
				List<String> values = new ArrayList<>();
				values.add(eS);
				kv.put(key, values);
			}

		}
		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> eachEntry : kv.entrySet()) {
			result.add(eachEntry.getValue());

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("1st set:");
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

		System.out.println("\n2nd set:");
		System.out.println(groupAnagrams(new String[] { "abc", "cba", "bac", "foo", "bar" }));

		System.out.println("\n3rd set:");
		System.out.println(
				groupAnagrams(new String[] { "listen", "silent", "triangle", "integral", "garden", "ranged" }));

		/*
		 * EXPECTED OUTPUT: ---------------- 1st set: [[eat, tea, ate], [tan, nat],
		 * [bat]]
		 * 
		 * 2nd set: [[abc, cba, bac], [foo], [bar]]
		 * 
		 * 3rd set: [[listen, silent], [triangle, integral], [garden, ranged]]
		 * 
		 */

	}
}
