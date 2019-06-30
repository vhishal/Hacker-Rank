package com.vhishal.ramsaransing.warrmup;

import java.util.Arrays;

public class MiniMaxSum {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/mini-max-sum/problem
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 4, 5 };
		minMax(arr);
		int[] arr2 = { 793810624, 895642170, 685903712, 623789054, 468592370 };
		minMax(arr2);
	}

	/**
	 * Takes a int array and calculates the minimum and maximum sum using n-1
	 * elements. The results are printed. For example if the input is { 1, 2, 9, 4,
	 * 5 } the method will print '12 20'
	 * 
	 * @param input int []
	 */
	static void minMax(int[] input) {
		Arrays.sort(input);
		long min = 0;
		long max = 0;
		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				min += input[i];
			} else if (i == (input.length - 1)) {
				max += input[i];
			} else {
				min += input[i];
				max += input[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
