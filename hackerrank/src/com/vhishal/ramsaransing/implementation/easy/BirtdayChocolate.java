package com.vhishal.ramsaransing.implementation.easy;

import java.util.Arrays;
import java.util.List;

/*
 * Problem link: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class BirtdayChocolate {
	public static void main(String[] args) {
		List<Integer> chocolate = Arrays.asList(1, 2, 1, 3, 2);
		int result = birthday(chocolate, 3, 2);
		System.out.println(result);
	}

	/**
	 * This method accepts 3 parameters. The first is a {@link Integer} {@link List}
	 * with the number of chocolate squares. The second parameter is a int this
	 * specifies how many numbers of the array should be used and the third
	 * parameter is a int which specifies what the the sum of the used squares
	 * should be. The output will be the number of possible scenarios for the given
	 * criteria. For example if the input is {1, 2, 1, 3, 2}, 3, 2 the output will
	 * be 2
	 * 
	 * @param chocolate {@link Integer} {@link List}
	 * @param d         int
	 * @param m         int
	 * @return output int
	 */
	static int birthday(List<Integer> chocolate, int d, int m) {
		int output = 0;
		for (int j = 0; j < chocolate.size(); j++) {
			int counter = 0;
			int sum = 0;
			for (int i = j; i < chocolate.size(); i++) {
				counter++;
				sum += chocolate.get(i);
				if (counter == m) {
					break;
				}
			}
			if (sum == d) {
				output++;
			}
		}
		return output;
	}
}
