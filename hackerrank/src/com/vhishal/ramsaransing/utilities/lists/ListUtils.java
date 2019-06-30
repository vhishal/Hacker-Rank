package com.vhishal.ramsaransing.utilities.lists;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

	private ListUtils() {
		throw new IllegalStateException("ListUtils class");
	}

	/**
	 * The input is a two dimensional Integer List and the output is a two
	 * dimensional integer List where the columns of the first list are now the rows
	 * of the second Lists. For example if input is [[5, 3, 4], [1, 5, 8], [6, 4,
	 * 2]] output will be [[5, 1, 6], [3, 5, 4], [4, 8, 2]]
	 * 
	 * @param input 2D {@link Integer} {@link List}
	 * @return output 2D {@link Integer} {@link List}
	 */
	public static List<List<Integer>> getListColumnsAsRows(List<List<Integer>> input) {
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			List<Integer> innerArray = new ArrayList<>();
			for (int j = 0; j < input.size(); j++) {
				innerArray.add(input.get(j).get(i));
			}
			output.add(innerArray);
		}
		return output;
	}

	/**
	 * Takes a two dimensional Integer List and returns a Integer List with the Left
	 * to right diagonal values of the 2D List. For example if the input is [[5, 3,
	 * 4], [1, 5, 8], [6, 4, 2]] the output will be [5, 5, 2]
	 * 
	 * @param input 2D {@link Integer} {@link List}
	 * @return output {@link Integer} {@link List}
	 */
	public static List<Integer> getListLRDasList(List<List<Integer>> input) {
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.size(); j++) {
				if (i == j) {
					output.add(input.get(i).get(j));
				}
			}
		}
		return output;
	}

	/**
	 * Takes a two dimensional Integer List and returns a Integer List with the
	 * right to left diagonal values of the 2D List. For example if the input is
	 * [[5, 3, 4], [1, 5, 8], [6, 4, 2]] the output will be [4, 5, 6]
	 * 
	 * @param input 2D {@link Integer} {@link List}
	 * @return output {@link Integer} {@link List}
	 */
	public static List<Integer> getListRLDasList(List<List<Integer>> inputArrayList) {
		List<Integer> output = new ArrayList<>();
		int extraCounter = inputArrayList.size() - 1;
		int extraCounter2 = 0;
		for (int i = 0; i < inputArrayList.size(); i++) {
			for (int j = 0; j < inputArrayList.size(); j++) {
				if ((i + extraCounter) == j) {
					output.add(inputArrayList.get(i).get(j - extraCounter2));
					extraCounter--;
					extraCounter2++;
				}
			}
		}
		return output;
	}

	/**
	 * Takes a List and returns the sum of this List. For example if the input is
	 * [4, 5, 6] the output will be 15
	 * 
	 * @param input {@link Integer} {@link List}
	 * @return sum of input
	 */
	public static int listSum(List<Integer> input) {
		int sum = 0;
		for (int value : input) {
			sum += value;
		}
		return sum;
	}

	/**
	 * Gets two 2 dimensional List of the same size and returns the difference of
	 * the elements of the two lists. For example if the inputs are [[5, 3, 4], [1,
	 * 5, 8], [6, 4, 2]] and [[5, 1, 6], [3, 5, 4], [4, 8, 2]] the output will be 16
	 * 
	 * @param input1 2D {@link Integer} {@link List}
	 * @param input2 2D {@link Integer} {@link List}
	 * @return int output
	 */
	public static int differanceBetweenTwo2DList(List<List<Integer>> input1, List<List<Integer>> input2) {
		int output = 0;
		if (input1.size() == input2.size()) {
			for (int i = 0; i < input1.size(); i++) {
				List<Integer> input1Sub = input1.get(i);
				List<Integer> input2Sub = input2.get(i);
				if (input1Sub.size() == input2Sub.size()) {
					for (int j = 0; j < input1Sub.size(); j++) {
						if (input1Sub.get(j).compareTo(input2Sub.get(j)) != 0) {
							if (input1Sub.get(j) > input2Sub.get(j)) {
								output += input1Sub.get(j) - input2Sub.get(j);
							} else {
								output += input2Sub.get(j) - input1Sub.get(j);
							}

						}
					}
				}
			}
		}
		return output;
	}

	/**
	 * Gets 2 List and compares the values, if a value is in both Lists the method
	 * returns true. The list can have different sizes. For example if the input is
	 * [5, 3, 4] and [6, 7, 8, 9] The output will be false
	 * 
	 * @param list  {@link Integer} {@link List}
	 * @param list2 {@link Integer} {@link List}
	 * @return output {@link Boolean}
	 */
	public static boolean checkListValuesForDuplicates(List<Integer> list, List<Integer> list2) {
		boolean output = false;
		outer: for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list.get(i).compareTo(list2.get(j)) == 0) {
					output = true;
					break outer;
				}
			}
		}
		return output;
	}
}
