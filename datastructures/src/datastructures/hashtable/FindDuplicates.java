package datastructures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * findDuplicates()
 * 
 * 
 * Problem: Given an array of integers nums, find all the duplicates in the
 * array using a hash table (HashMap).
 */
public class FindDuplicates {

	static List<Integer> findDuplicates(int[] nums) {
		Map<Integer, Integer> numCounts = new HashMap<>();
		for (int num : nums) {
			numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
		}
		List<Integer> duplicates = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
			if (entry.getValue() > 1) {
				duplicates.add(entry.getKey());
			}
		}
		return duplicates;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 2, 1, 4, 5, 4 };
		List<Integer> duplicates = findDuplicates(nums);
		System.out.println(duplicates);

		/*
		 * EXPECTED OUTPUT: ---------------- [1, 2, 4]
		 * 
		 */

	}

}
