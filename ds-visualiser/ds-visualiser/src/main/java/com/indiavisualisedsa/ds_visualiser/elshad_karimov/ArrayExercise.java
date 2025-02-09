package com.indiavisualisedsa.ds_visualiser.elshad_karimov;

import java.util.Arrays;

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
		for (int i = 0; i < matrix.length/2; i++) {
			swap(matrix[i], matrix[matrix.length -i-1]);
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
		//using two pointer technique
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

	public static void main(String[] args) {
		int[][] test2DArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		makeColumnReverseMatrix(test2DArray);
		print2DArray(test2DArray);
	}

}
