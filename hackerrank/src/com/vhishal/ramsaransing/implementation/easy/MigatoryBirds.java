package com.vhishal.ramsaransing.implementation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MigatoryBirds {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/migratory-birds/problem
	 */
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.addAll(Arrays.asList(1, 4, 4, 4, 5, 3));
		int result = migratoryBirds(input);
		System.out.println(result);

	}

	/**
	 * This method takes a {@link Integer} {@link List} and returns the most common
	 * {@link Integer} in the list. If more Integers are equally common it returns
	 * the smallest one. For example if the input is (1, 4, 4, 4, 5, 3) the output
	 * will be 4
	 * 
	 * @param arr {@link Integer} {@link List}
	 * @return output int
	 */
	static int migratoryBirds(List<Integer> arr) {
		int output = 0;
		Map<Integer, List<Integer>> result = arr.parallelStream().sorted()
				.collect(Collectors.groupingBy(f -> f.intValue()));
		List<Integer> keys = new ArrayList<>();
		keys.addAll(result.keySet());

		int size = 0;
		for (int i = 0; i < keys.size(); i++) {
			if (size < result.get(keys.get(i)).size()) {
				size = result.get(keys.get(i)).size();
				output = keys.get(i);
			}
		}
		return output;
	}

}
