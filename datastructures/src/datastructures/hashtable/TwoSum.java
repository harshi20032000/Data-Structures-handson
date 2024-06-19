package datastructures.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * twoSum()
 * 
 * Problem: Given an array of integers nums and a target integer target, find
 * the indices of two numbers in the array that add up to the target.
 */

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int e : nums) {
			map.put(e, i++);
		}
		i = 0;
		for (int e : nums) {
			if (map.containsKey(target - e)) {
				int[] result = new int[2];
				result[0] = i;
				result[1] = map.get(target - e);
				return result;

			}
			i++;
		}

		return new int[] {};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		//failing
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 3 }, 6)));
		//failing
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 10)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 7)));
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4, 5 }, 3)));
		System.out.println(Arrays.toString(twoSum(new int[] {}, 0)));

		/*
		 * EXPECTED OUTPUT: ---------------- [0, 1] [1, 2] [0, 1] [] [2, 3] [0, 1] []
		 * 
		 */

	}
}
