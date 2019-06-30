package com.vhishal.ramsaransing.warrmup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayCakeCandels {

	/*
	 * Problem
	 * link:https://www.hackerrank.com/challenges/birthday-cake-candles/problem
	 */

	public static void main(String[] args) {
		int[] input = { 5, 6, 7, 4, 4, 6, 7, 7 };
		System.out.println(birthdayCakeCandles(input));
	}

	/**
	 * Takes a int Array and returns the number of occurrence of the highest number.
	 * For example if the input is { 5, 6, 7, 4, 4, 6, 7, 7} the output will be 3
	 * 
	 * @param input int []
	 * @return count of highest number in the array
	 */
	static int birthdayCakeCandles(int[] input) {
		int output = 0;
		List<Integer> candels = Arrays.stream(input).boxed().collect(Collectors.toList());
		candels.sort(Collections.reverseOrder());
		int max = 0;
		for (int i = 0; i < candels.size(); i++) {
			if (max > candels.get(i)) {
				break;
			}
			max = candels.get(i);
			output++;
		}
		return output;
	}
}
