package com.vhishal.ramsaransing.implementation.easy;

public class BeautifulDaysAtTheMovies {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
	 */
	public static void main(String[] args) {
		System.out.println(beautifulDays(20, 23, 6));
	}

	/**
	 * This method takes 3 parameters, the first two parameters are ints indicating
	 * the start and end of the range and the last parameter is used to check
	 * whether the difference between the int and its reverse is divisible by this.
	 * the method will return the number of ints minus their reverse that are
	 * divisible by the last parameter and evaluates to a whole number. For example
	 * if the input is 20,23,6 the output will be 2
	 * 
	 * @param i int
	 * @param j int
	 * @param k int
	 * @return output int
	 */
	static int beautifulDays(int i, int j, int k) {
		int output = 0;
		while (i <= j) {
			int reverse = getReverseInt(i);
			int verschil = i - reverse >= 0 ? i - reverse : reverse - i;
			if (verschil % k == 0) {
				output++;
			}
			i++;
		}
		return output;
	}

	/**
	 * This method takes an int and reverses it. For example the input is 53 the
	 * output will be 35
	 * 
	 * @param input int
	 * @return output int
	 */
	private static int getReverseInt(int input) {
		char[] inputChar = String.valueOf(input).toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = inputChar.length - 1; i >= 0; i--) {
			sb.append(inputChar[i]);
		}
		return Integer.valueOf(sb.toString());
	}
}
