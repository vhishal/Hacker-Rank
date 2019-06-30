package com.vhishal.ramsaransing.implementation.easy;

import java.util.Arrays;

public class TheHurdleRace {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/the-hurdle-race/problem
	 */
	public static void main(String[] args) {
		int[] height = { 2, 5, 4, 5, 2 };
		System.out.println(hurdleRace(4, height));
	}

	/**
	 * This method takes 2 parameters the first a int indicating the maximum height
	 * a person can jump and the second a int Array of the height of various hurdles
	 * the method returns the difference between what a person can jump and the
	 * highest hurdle.
	 * 
	 * @param k      int
	 * @param height int []
	 * @return output int
	 */
	static int hurdleRace(int k, int[] height) {
		Arrays.parallelSort(height);
		return height[height.length - 1] - k > 0 ? height[height.length - 1] - k : 0;
	}

}
