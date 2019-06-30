package com.vhishal.ramsaransing.utilities.common;

import java.util.List;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;
import com.vhishal.ramsaransing.utilities.lists.ListUtils;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utils class");
	}

	/**
	 * Calculates what the Magic number should be for a magic square. If there is a
	 * square of the size 3X3 and the input range is [1-9]. The output will be (3/2)
	 * X (1+9) = 15
	 * 
	 * @param length     int
	 * @param inputRange int []
	 * 
	 * @return int output
	 */
	public static int getMagicNumberForMagicSquare(int length, int[] inputRange) {
		Double output = (Double.valueOf(length) / 2)
				* (ArrayUtils.getLowestValue(inputRange) + ArrayUtils.getHighestValue(inputRange));
		return output.intValue();
	}

	/**
	 * this checks if the square is a magic square (The sum of any row, column or
	 * diagonal should equal the given number (Magic number)) if it returns 0 then
	 * it is a magic square otherwise it will return the number of calculations that
	 * is not equal to the magic number
	 * 
	 * @param input  2D {@link Integer} {@link List}
	 * @param number this is the magic number
	 * @return int output
	 */
	public static int checkIfSquareSumEqualsNumber(List<List<Integer>> input, int number) {
		int output = 0;
		for (int i = 0; i < input.size(); i++) {
			if (!checkIfMagic(input.get(i), number)) {
				output++;
			}
		}
		List<List<Integer>> squareListColumnsAsRows = ListUtils.getListColumnsAsRows(input);
		for (int i = 0; i < squareListColumnsAsRows.size(); i++) {
			if (!checkIfMagic(squareListColumnsAsRows.get(i), number)) {
				output++;
			}
		}
		if (!checkIfMagic(ListUtils.getListLRDasList(input), number)) {
			output++;
		}
		if (!checkIfMagic(ListUtils.getListRLDasList(input), number)) {
			output++;
		}
		return output;
	}

	/**
	 * Gets a Integer List and a int as input and returns true if the sum of the
	 * List is equal to the int input. For example if the input is [5,1,9] and 15
	 * the output will be true
	 * 
	 * @param input  {@link Integer} {@link List}
	 * @param number int
	 * @return {@link Boolean}
	 */
	private static boolean checkIfMagic(List<Integer> input, int number) {
		boolean output = false;
		if (ListUtils.listSum(input) == number) {
			output = true;
		}
		return output;
	}

}
