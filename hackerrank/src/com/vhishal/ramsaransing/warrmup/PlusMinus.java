package com.vhishal.ramsaransing.warrmup;

import java.text.DecimalFormat;

public class PlusMinus {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/plus-minus/problem
	 */
	public static void main(String[] args) {
		int[] input = { -4, 3, -9, 0, 4, 1 };
		plusMinus(input);
	}

	/**
	 * Takes a array of integers and calculates how many zero's, positives and
	 * negatives there are compared to the length of the array and prints this. For
	 * example if the input is { -4, 3, -9, 0, 4, 1 } the method will print' 0.500000,
	 * 0.333333 and 0.166667'
	 * 
	 * @param input int []
	 */
	static void plusMinus(int[] input) {

		DecimalFormat dcf = new DecimalFormat("0.000000");

		double aantal = input.length;
		double pos = 0;
		double neg = 0;
		double zero = 0;
		for (int value : input) {
			if (value > 0) {
				pos++;
			} else if (value < 0) {
				neg++;
			} else {
				zero++;
			}
		}

		System.out.println(dcf.format(pos / aantal));
		System.out.println(dcf.format(neg / aantal));
		System.out.println(dcf.format(zero / aantal));
	}
}
