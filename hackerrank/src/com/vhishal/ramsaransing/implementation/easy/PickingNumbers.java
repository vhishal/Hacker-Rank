package com.vhishal.ramsaransing.implementation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingNumbers {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/picking-numbers/problem
	 */
	public static void main(String[] args) {
		System.out.println(pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)));
		System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
		System.out.println(pickingNumbers(Arrays.asList(14, 18, 17, 10, 9, 20, 4, 13, 19, 19, 8, 15, 15, 17, 6, 5, 15,
				12, 18, 2, 18, 7, 20, 8, 2, 8, 11, 2, 16, 2, 12, 9, 3, 6, 9, 9, 13, 7, 4, 6, 19, 7, 2, 4, 3, 4, 14, 3,
				4, 9, 17, 9, 4, 20, 10, 16, 12, 1, 16, 4, 15, 15, 9, 13, 6, 3, 8, 4, 7, 14, 16, 18, 20, 11, 20, 14, 20,
				12, 15, 4, 5, 10, 10, 20, 11, 18, 5, 20, 13, 4, 18, 1, 14, 3, 20, 19, 14, 2, 5, 13)));
		System.out.println(pickingNumbers(Arrays.asList(7, 12, 13, 19, 17, 7, 3, 18, 9, 18, 13, 12, 3, 13, 7, 9, 18, 9,
				18, 9, 13, 18, 13, 13, 18, 18, 17, 17, 13, 3, 12, 13, 19, 17, 19, 12, 18, 13, 7, 3, 3, 12, 7, 13, 7, 3,
				17, 9, 13, 13, 13, 12, 18, 18, 9, 7, 19, 17, 13, 18, 19, 9, 18, 18, 18, 19, 17, 7, 12, 3, 13, 19, 12, 3,
				9, 17, 13, 19, 12, 18, 13, 18, 18, 18, 17, 13, 3, 18, 19, 7, 12, 9, 18, 3, 13, 13, 9, 7)));

	}

	/**
	 * This method takes a {@link Integer} {@link List} and returns the maximum
	 * number of elements that can be added in a sub Array where the difference
	 * between each elements is 1 or less. For example if the input is (1, 1, 2, 2,
	 * 4, 4, 5, 5, 5) the method will return 5.
	 * 
	 * @param input {@link Integer} {@link List}
	 * @return output int
	 */
	public static int pickingNumbers(List<Integer> input) {
		int outputMax = 0;
		Map<Integer, List<Integer>> inputMap = input.parallelStream().sorted()
				.collect(Collectors.groupingBy(f -> f.intValue()));
		System.out.println(inputMap);

		List<Integer> keys = new ArrayList<>();
		keys.addAll(inputMap.keySet());
		Collections.sort(keys);

		int prevEleent = 0;
		int output = 0;
		for (int i = 0; i < keys.size(); i++) {
			if (i == 0) {
				prevEleent = inputMap.get(keys.get(i)).get(0);
				output = inputMap.get(keys.get(i)).size();
				if (outputMax < output) {
					outputMax = output;
				}
			} else {
				if (inputMap.get(keys.get(i)).get(0) - prevEleent <= 1) {
					output += inputMap.get(keys.get(i)).size();
					if (outputMax < output) {
						outputMax = output;
					}
				} else {
					prevEleent = inputMap.get(keys.get(i)).get(0);
					output = inputMap.get(keys.get(i)).size();
					if (outputMax < output) {
						outputMax = output;
					}
				}
			}
		}
		return outputMax;
	}

}
