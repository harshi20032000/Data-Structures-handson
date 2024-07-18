package hackerrank.learning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HourGlass {

	public static int sum(List<List<Integer>> arr, int i, int j) {
		int sum = 0;
		for (int l = i; l < i + 3; l++) {
			for (int m = j; m < j + 3; m++) {
					Integer element = arr.get(l).get(m);
					sum += element;
			}
		}
		sum= sum - arr.get(i+1).get(j) - arr.get(i+1).get(j+2);
		return sum;
	}

	public static int hourglassSum(List<List<Integer>> arr) {
		int maxHourGlassSum = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = sum(arr, i, j);
				System.out.print(sum+" ");
				if (sum > maxHourGlassSum)
					maxHourGlassSum = sum;
			}
			System.out.println();
		}
		return maxHourGlassSum;

	}

	public static void main(String[] args) throws IOException {

		List<List<Integer>> arr = new ArrayList<>();
		
//		Integer[][] values = {
//			    {1, 1, 1, 0, 0, 0},
//			    {0, 1, 0, 0, 0, 0},
//			    {1, 1, 1, 0, 0, 0},
//			    {0, 0, 2, 4, 4, 0},
//			    {0, 0, 0, 2, 0, 0},
//			    {0, 0, 1, 2, 4, 0}
//			};
		
		
//		Integer[][] values = {
//			    {-9, -9, -9, 1, 1, 1},
//			    {0, -9, 0, 4, 3, 2},
//			    {-9, -9, -9, 1, 2, 3},
//			    {0, 0, 8, 6, 6, 0},
//			    {0, 0, 0, -2, 0, 0},
//			    {0, 0, 1, 2, 4, 0}
//			};
		
		Integer[][] values = {
			    {-1, -1, 0, -9, -2, -2},
			    {-2, -1, -6, -8, -2, -5},
			    {-1, -1, -1, -2, -3, -4},
			    {-1, -9, -2, -4, -4, -5},
			    {-7, -3, -3, -2, -9, -9},
			    {-1, -3, -1, -2, -4, -5}
			};

			for (Integer[] row : values) {
			    arr.add(Arrays.asList(row));
			}
		

		int result = hourglassSum(arr);
		System.out.println(result);
	}
}
