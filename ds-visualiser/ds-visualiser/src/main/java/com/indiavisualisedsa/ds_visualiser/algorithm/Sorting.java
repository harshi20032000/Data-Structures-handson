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
	}
}
