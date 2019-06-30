package com.vhishal.ramsaransing.implementation.easy;

public class DivisebleSumPairs {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
	 */
	public static void main(String[] args) {
		int[] input = { 1, 3, 2, 6, 1, 2 };
		int result = divisibleSumPairs(3, input);
		System.out.println(result);
	}

	/**
	 * This method takes 2 parameters the first an int and the second an int Array.
	 * the method returns how many pairs are divisible by the first parameter as a
	 * wholesome number. For example if the input is 3 and { 1, 3, 2, 6, 1, 2 } the
	 * output will be 5.
	 * 
	 * @param k  int
	 * @param ar int []
	 * @return output int
	 */
	static int divisibleSumPairs(int k, int[] ar) {
		int output = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i; j < ar.length; j++) {
				if (i != j && (ar[i] + ar[j]) % k == 0) {
					output++;
				}
			}
		}
		return output;
	}

}
