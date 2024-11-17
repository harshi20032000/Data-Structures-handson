package com.indiavisualisedsa.ds_visualiser.algorithm;

import java.util.Arrays;

public class Sorting {

	/**
	 * BubbleSort
	 * 
	 */
	static void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * SelectionSort
	 * 
	 */
	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	
	/**
	 * InsertionSort
	 * 
	 */
	static void insertionSort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			int j=i-1;
			while(j>-1 && temp<array[j]) {
				array[j+1]=array[j];
				array[j]=temp;
				j--;
			}
			
		}
		
	} 
	
	/**merges two sorted arrays
	 * 
	 * @param array1
	 * @param array2
	 * @return merged value of two sorted arrays
	 */
	static int[] merge(int[] array1, int[] array2) {
		int[] combined = new int[array1.length+array2.length];
		int index=0;
		int i=0;
		int j=0;
		while(i<array1.length && j<array2.length) {
			if(array1[i]<array2[j]) {
				combined[index]=array1[i];
				index++;
				i++;
			}
			else {
				combined[index]=array2[j];
				index++;
				j++;
			}
		}
		while(i<array1.length) {
			combined[index]=array1[i];
			index++;
			i++;
		}
		while(j<array2.length) {
			combined[index]=array2[j];
			index++;
			j++;
		}
		return combined;
	}
	
	/**Testing merge sort on unsorted array
	 * Time complexity - nlogn
	 * @param array
	 * @return sorted array.
	 */
	static int[] mergeSort(int[] array) {
		if(array.length==1) return array;
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length/2));
		int[] right = mergeSort(Arrays.copyOfRange(array,array.length/2, array.length));
		return merge(left, right);
	}
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	static int pivot(int[] array, int pivotIndex, int endIndex) {
		int swapIndex = pivotIndex;
		for(int i=pivotIndex+1; i<=endIndex; i++) {
			if(array[i]<array[pivotIndex]) {
				swapIndex++;
				swap(array, swapIndex, i);
			}
		}
		swap(array, pivotIndex, swapIndex);
		return swapIndex;
	}
	
	static void quickSort(int[] array, int left, int right) {
		if(left<right) {
			 int pivotIndex = pivot(array, left, right);
			 quickSort(array, left, pivotIndex-1);
			 quickSort(array, pivotIndex+1, right);
		}
	}
	
	

	public static void main(String[] args) {
		int[] array = { 7, 9, 8, 0, 1, 4 };
		System.out.println("Sorting bubbleSort");
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		int[] array1 = { 7, 9, 8, 0, 1, 4 };
		System.out.println("Sorting selectionSort");
		selectionSort(array1);
		System.out.println(Arrays.toString(array1));
		int[] array2 = { 7, 9, 8, 0, 1, 4 };
		System.out.println("Sorting insertionSort");
		selectionSort(array2);
		System.out.println(Arrays.toString(array2));
		int[] array3 = {1, 3, 5, 7, 9, 11, 13, 15};
		int[] array4 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		System.out.println("Testing merge on two sorted arrays");
		System.out.println(Arrays.toString(merge(array3, array4)));
		int[] array5 = {1, 3, 5, 7, 9, 11, 13, 15, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		System.out.println("Testing merge sort");
		System.out.println(Arrays.toString(mergeSort(array5)));
		
		System.out.println("Testing pivot function");
		int[] quickSortArray = {4, 6, 1, 7, 3, 2, 5};
		int returnedIndex = pivot(quickSortArray, 0, quickSortArray.length-1);
		System.out.println("returned index: "+ returnedIndex);
		System.out.println("modified array : "+Arrays.toString(quickSortArray));
		quickSort(quickSortArray, 0, quickSortArray.length-1);
		System.out.println("After quick sort : "+Arrays.toString(quickSortArray));
	}
}
