package com.vhishal.ramsaransing.warrmup;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;

public class AveryBigSum {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/a-very-big-sum/problem
	 */

	public static void main(String[] args) {
		long[] nput = { 1000000001, 1000000002, 1000000003, 1000000004, 1000000005 };
		System.out.println(aVeryBigSum(nput));
	}

	/**
	 * Takes a array and returns the sum of this array. For example input {
	 * 1000000001, 1000000002, 1000000003, 1000000004, 1000000005 } output
	 * 5000000015
	 * 
	 * @param input long []
	 * @return sum of all the elements of the long []
	 */
	static long aVeryBigSum(long[] input) {
		return ArrayUtils.arraySum(input);
	}

}
