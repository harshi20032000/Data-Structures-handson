package hackerrank.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static int birthdayCakeCandles(List<Integer> candles) {
	    int max = candles.stream().mapToInt(i -> i).max().getAsInt();
	    return (int) candles.stream().filter(i -> i == max).count();
	}

	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(2, 1, 3, 4, 5);
		
		List<Integer> arrr = new ArrayList<>(
		        Arrays.asList(25, 62, 46, 71, 93)
		);
		List<Integer> var = arrr;
		int sum = var.stream().mapToInt(i -> i).sum();
		int min =var.stream().mapToInt(i -> i).min().getAsInt();
		int max =var.stream().mapToInt(i -> i).max().getAsInt();
		
		System.out.println(sum+" "+ min+" "+ max);

	}

}
