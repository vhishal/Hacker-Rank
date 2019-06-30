package com.vhishal.ramsaransing.implementation.easy;

public class CountingValleys {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/counting-valleys/problem
	 */
	public static void main(String[] args) {
		int result = countingValleys(8, "UDDDUDUU");
		System.out.println(result);
	}

	/**
	 * The method takes 2 parameters, the first a int is the number of 'steps'
	 * taken, the second a {@link String} describing the path. The number returned
	 * is the number of valley's traveled. For example if the input is 8 and
	 * "UDDDUDUU" the output will be 1.
	 * 
	 * @param n int
	 * @param s {@link String}
	 * @return output int
	 */
	static int countingValleys(int n, String s) {
		int output = 0;
		int level = 0;
		boolean inVally = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'U') {
				level++;
			} else {
				level--;
			}
			if (level < 0) {
				inVally = true;
			} else if (level == 0 && inVally) {
				output++;
				inVally = false;
			}
		}
		return output;
	}

}
