package com.indiavisualisedsa.ds_visualiser.elshad_karimov;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ArrayExercise {

	public static int[] middle(int[] array) {
		if (array.length <= 2)
			return new int[0];

		int[] middle = new int[array.length - 2];
		for (int i = 1; i < array.length - 1; i++) {
			middle[i - 1] = array[i];
		}

		return middle;
	}

	public static int sumDiagonalElements(int[][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i][i];
		}
		return sum;
	}

	public static int[] findTopTwoScores(int[] array) {

		int firstHighest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int a : array) {
			if (a > firstHighest) {
				secondHighest = firstHighest;
				firstHighest = a;
			} else if (a < firstHighest && a > secondHighest) {
				secondHighest = a;
			}
		}

		return new int[] { firstHighest, secondHighest };

	}

	static int findMissingNumberInArray(int[] arr) {
		int manualSum = 0;
		int l = arr.length;
		int n = arr[l - 1];
		int sum = (n * (n + 1)) / 2;
		for (int i = 0; i < l; i++) {
			manualSum += arr[i];
		}
		return sum - manualSum;
	}

	public static int[] removeDuplicates(int[] arr) {
		int[] noDup = new int[arr.length];
		int newLength = 1;
		noDup[0] = arr[0];
		for (int i = 0; i < arr.length; i++) {
			boolean repeat = false;
			for (int j = 0; j < newLength; j++) {
				if (arr[i] == noDup[j]) {
					repeat = true;
					break;
				}
			}
			if (!repeat) {
				noDup[newLength] = arr[i];
				newLength++;
			}
		}
		return Arrays.copyOf(noDup, newLength);
	}

	public int noOfRepeatElement(int[] nums) {

		int newLength = 1;
		for (int i = 0; i < nums.length; i++) {
			boolean repeat = false;
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					repeat = true;
					break;
				}
			}
			if (!repeat) {
				newLength++;
			}
		}
		return nums.length - newLength;
	}

	public static int maxProfit(int[] prices) {
		int minPrice = prices[0];
		int mpIndex = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				mpIndex = i;
				minPrice = prices[i];
			}
		}
		int greatestElementAfter = prices[mpIndex];
		for (int i = mpIndex; i < prices.length; i++) {
			if (prices[i] > greatestElementAfter)
				greatestElementAfter = prices[i];
		}
		return greatestElementAfter - minPrice;
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] { i, j };
			}
		}
		return new int[2];
	}

	public static int searchInArray(int[] intArray, int valueToSearch) {
		for (int a = 1; a < intArray.length; a++) {
			if (intArray[a] == valueToSearch)
				return a;
		}
		return -1;
	}

	public boolean isUnique(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] == intArray[j]) {
					return false;
				}
			}

		}
		return true;
	}

	public static boolean permutation(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;
		Arrays.sort(array1);
		Arrays.sort(array2);

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i])
				return false;
		}
		return true;
	}

	public static void rotateMatrix(int[][] matrix) {
		makeTransposeMatrix(matrix);
		makeRowReverseMatrix(matrix);
	}

	public static void makeTransposeMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void makeRowReverseMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			reverse(matrix[i]);
		}
	}

	public static void makeColumnReverseMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			swap(matrix[i], matrix[matrix.length - i - 1]);
		}
	}

	private static void swap(int[] is, int[] is2) {

		for (int i = 0; i < is.length; i++) {
			int temp = is[i];
			is[i] = is2[i];
			is2[i] = temp;
		}
	}

	private static void reverse(int[] is) {
		// using two pointer technique
		for (int i = 0, j = is.length - 1; i < j; i++, j--) {
			int temp = is[i];
			is[i] = is[j];
			is[j] = temp;
		}

	}

	public static void printArray(int[] array) {
		System.out.println("The array values are - ");
		for (int e : array)
			System.out.print(e + " ");
		System.out.println();
	}

	public static void print2DArray(int[][] matrix) {
		System.out.println("The 2D array values are - ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rotateByK(int[] arr, int k) {
		int n = arr.length;
		k = k % n; // Handle cases where k > n

		reverse(arr, 0, n - 1); // Reverse entire array
		reverse(arr, 0, k - 1); // Reverse first k elements
		reverse(arr, k, n - 1);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int maxA = 0;
		while (i < j) {
			maxA = Math.max(Math.min(height[i], height[j]) * (j - i), maxA);
			if (height[i] > height[j])
				j--;
			else
				i++;
		}

		return maxA;
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right && left < nums.length && right < nums.length) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (sum < 0)
					left++;
				else
					right--;

			}
		}
		return result;
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1; // Pointer for nums1 (excluding extra space)
		int j = n - 1; // Pointer for nums2
		int k = m + n - 1; // Pointer for merged array (starting from the end)

		// Merge from the end
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

		// If nums2 has remaining elements, copy them
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}

	}

	public static int removeElement(int[] nums, int val) {
		int k = 0; // Pointer for placement of non-val elements
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k++] = nums[i]; // Move non-val element to front
			}
		}
		return k;
	}

	public static int removeDuplicateElement(int[] nums) {
		int k = 0;
		int l = nums.length;
		for (int i = 0; i < nums.length; i++) {
			int j = 0;
			while (i != j) {
				if (nums[i] == nums[j]) {
					int temp = nums[j];
					nums[j] = nums[l - k];
					nums[l - k] = temp;
				} else
					k++;
			}
		}
		return k;
	}

	public static int removeDuplicatesFromSortedArrays(int[] nums) {

		// pointer to track unique elements
		int i = 0;
		// pointer to track all elements
		int j = 1;
		for (j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}

		}
		return i + 1;
	}

	public static int removeDuplicatesFromSortedArraysTwoElementsAllowed(int[] nums) {

		// pointer to track unique elements
		int i = 0;
		// pointer to track all elements
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i += 2;
				nums[i] = nums[j];
			}

		}
		return i + 1;
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> elementCount = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
		}
		int maxKey = nums[0];
		for(Entry<Integer, Integer> eachKey : elementCount.entrySet()) {
			if(eachKey.getValue()>elementCount.get(maxKey))
				maxKey=eachKey.getKey();
		}
		return maxKey;
	}
	
	public static int majorityElementUsingBayerMooreAlgorithm(int[] nums) {
		int candidate=nums[0];
		int count =0;
		for (int i = 0; i < nums.length; i++) {
			if(count==0)
				candidate=nums[i];
			count = (nums[i]>candidate)?count+1:count-1;
			
		}
		return candidate;
	}
	
	public static void rotateUsingAdditionalSpace(int[] nums, int k) {
		int[] temp = new int[k];
        int l = nums.length;
        for(int i=0; i<k; i++){
        	temp[i]=nums[l-k+i];
        }
        for(int i=l-1, j=l-k-1; j>=0; i--, j--){
        	nums[i]=nums[j];
        }
        for(int i=0; i<k; i++){
        	nums[i]=temp[i];
        } 
    }
	
	public static void rotateUsingreverse(int[] nums, int k) {
		int l=nums.length;
		reverse(nums, 0, l-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, l-1);
    }

	public static void main(String[] args) {
		int[] test2DArray = { 1, 2, 3, 4, 5, 6, 7 };
		rotateUsingreverse(test2DArray, 3);
		printArray(test2DArray);
		
	}

}
