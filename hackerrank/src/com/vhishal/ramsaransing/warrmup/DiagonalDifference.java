package com.vhishal.ramsaransing.warrmup;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;

public class DiagonalDifference {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/diagonal-difference/problem
	 */
	public static void main(String[] args) {
		int[][] input = { { 11, 2, 4 }, { 4, 5, 6 }, { 10, 8, -12 } };
		System.out.println(diagonalDifference(input));
	}

	/**
	 * Given a square matrix, calculates the absolute difference between the sums of
	 * its diagonals. For example is the input is { { 11, 2, 4 }, { 4, 5, 6 }, { 10,
	 * 8, -12 } } the output will be 15
	 * 
	 * @param input int [][]
	 * @return int difference between diagonals
	 */
	static int diagonalDifference(int[][] input) {
		int output = 0;
		if (input.length != 0) {
			int leftDiagonal = ArrayUtils.sumRowsColumnsDiagonals2D(input, ArrayUtils.COUNT_LEFT_TO_RIGHT_DIAGONAL);
			int rightDiagonal = ArrayUtils.sumRowsColumnsDiagonals2D(input, ArrayUtils.COUNT_RIGHT_TO_LEFT_DIAGONAL);
			if (leftDiagonal > rightDiagonal) {
				output = leftDiagonal - rightDiagonal;
			} else {
				output = rightDiagonal - leftDiagonal;
			}
		}
		return output;
	}
}
