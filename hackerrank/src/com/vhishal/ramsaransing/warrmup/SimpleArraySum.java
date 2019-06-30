package com.vhishal.ramsaransing.warrmup;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;

public class SimpleArraySum {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/simple-array-sum/problem
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 10, 11 };
		System.out.println(simpleArraySum(input)); // Should print 31
	}

	/**
	 * Takes a array and returns the sum of this array. For example input { 1, 2, 3,
	 * 4, 10, 11 } output 31
	 * 
	 * @param input int []
	 * @return sum of input []
	 */
	static int simpleArraySum(int[] input) {
		return ArrayUtils.arraySum(input);
	}

}
