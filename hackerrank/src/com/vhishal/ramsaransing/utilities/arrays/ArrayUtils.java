package com.vhishal.ramsaransing.utilities.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {

	public static final int COUNT_ROWS = 1;
	public static final int COUNT_COLUNMS = 2;
	public static final int COUNT_LEFT_TO_RIGHT_DIAGONAL = 3;
	public static final int COUNT_RIGHT_TO_LEFT_DIAGONAL = 4;

	private ArrayUtils() {
		throw new IllegalStateException("ArrayUtils class");
	}

	/**
	 * Takes a two dimensional array and sums the rows, columns or diagonals based
	 * on the given option. Option 1 is for the sum of the rows, Option 2 is for the
	 * sum of the columns, option 3 is for the sum of the diagonal left to right and
	 * Option 4 is for the sum of the diagonal right to left.
	 * 
	 * @param input int [][]
	 * @param option int
	 * @return sum of the rows, columns, the left to right diagonal or right to left diagonal
	 */
	public static int sumRowsColumnsDiagonals2D(int[][] input, int option) {
		if (option == COUNT_ROWS || option == COUNT_COLUNMS) {
			return sumRowsColumns2D(input, option);
		} else if (option == COUNT_LEFT_TO_RIGHT_DIAGONAL || option == COUNT_RIGHT_TO_LEFT_DIAGONAL) {
			return sumDiagonals2D(input, option);
		} else {
			return 0;
		}
	}

	/**
	 * Takes a two dimensional array and returns the sum of the rows or columns
	 * based on the given option. Option 1 is for the sum of the rows and Option 2
	 * is for the sum of the columns.
	 * 
	 * @param input  int [][]
	 * @param option int
	 * @return sum of the rows or columns
	 */
	private static int sumRowsColumns2D(int[][] input, int option) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = 0;
			for (int j = 0; j < input[i].length; j++) {
				if (option == COUNT_ROWS) {
					sum += input[i][j];
				} else if (option == COUNT_COLUNMS) {
					sum += input[j][i];
				}
			}
		}
		return sum;
	}

	/**
	 * Takes a two dimensional array and returns the sum of the diagonals based on
	 * the given option.Option 3 is for the left to right diagonal sum and Option 4
	 * is for the right to left diagonal sum.
	 * 
	 * @param input  int [][]
	 * @param option int
	 * @return sum of the left to right diagonal or right to left diagonal
	 */
	private static int sumDiagonals2D(int[][] input, int option) {
		int sum = 0;
		/* Only used from right to left diagonal */
		int extraCounter = input.length - 1;
		int extraCounter2 = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (option == COUNT_LEFT_TO_RIGHT_DIAGONAL) {
					if (i == j) {
						sum += input[i][j];
					}
				} else if (option == COUNT_RIGHT_TO_LEFT_DIAGONAL && (i + extraCounter) == j) {
					sum += input[i][j - extraCounter2];
					extraCounter--;
					extraCounter2++;
				}
			}
		}
		return sum;
	}

	/**
	 * Takes a int array and returns the sum of this array.
	 * 
	 * @param input int []
	 * @return sum of input int []
	 */
	public static int arraySum(int[] input) {
		int sum = 0;
		for (int value : input) {
			sum += value;
		}
		return sum;
	}

	/**
	 * Takes a long array and returns the sum of this array.
	 * 
	 * @param input long []
	 * @return sum of input long []
	 */
	public static long arraySum(long[] input) {
		long sum = 0;
		for (long value : input) {
			sum += value;
		}
		return sum;
	}

	/**
	 * Converts a {@link String} to a int []
	 * 
	 * @param input {@link String}
	 * @return output int []
	 */
	public static int[] convertStringToIntArray(String input) {
		input = input.replace("[", "").replace("]", "").replace(" ", "").trim();
		String[] arr = input.split(",");
		int[] output = new int[arr.length];
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				output[i] = Integer.valueOf(arr[i]);
			}
		}
		return output;
	}

	/**
	 * The input is an two dimensional int Array and the output is a a two
	 * dimensional Integer List
	 * 
	 * @param input int [][]
	 * @return output 2D {@link Integer} {@link List}
	 */
	public static List<List<Integer>> convert2DArrayTo2DList(int[][] input) {
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			List<Integer> innerArray = Arrays.stream(input[i]).boxed().collect(Collectors.toList());
			output.add(innerArray);
		}
		return output;
	}

	/**
	 * Gets an int [] and returns the lowest value. For example if the input is
	 * {5,7,9} The output will be 5
	 * 
	 * @param input int []
	 * @return int
	 */
	public static int getLowestValue(int[] input) {
		Arrays.parallelSort(input);
		return input[0];
	}

	/**
	 * Gets an int [] and returns the highest value. For example if the input is
	 * {5,7,9} The output will be 9
	 * 
	 * @param input int []
	 * @return int
	 */
	public static int getHighestValue(int[] input) {
		Arrays.parallelSort(input);
		return input[input.length - 1];
	}
}
