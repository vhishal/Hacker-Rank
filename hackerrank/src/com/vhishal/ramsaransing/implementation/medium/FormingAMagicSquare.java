package com.vhishal.ramsaransing.implementation.medium;

import java.util.ArrayList;
import java.util.List;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;
import com.vhishal.ramsaransing.utilities.common.Utils;
import com.vhishal.ramsaransing.utilities.lists.ListUtils;

public class FormingAMagicSquare {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/magic-square-forming/problem
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int[][] input = { { 5, 3, 4 }, { 1, 5, 8 }, { 6, 4, 2 } }; // output should be 7
		int[][] input2 = { { 4, 8, 2 }, { 4, 5, 7 }, { 6, 1, 6 } }; // output should be 4
		int[][] input3 = { { 4, 9, 2 }, { 9, 7, 6 }, { 3, 5, 8 } }; // output should be 18
		int[][] input4 = { { 6, 9, 8 }, { 3, 9, 4 }, { 9, 4, 4 } }; // output should be 21
		int[][] input5 = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }; // output should be 0
		int[][] input6 = { { 2, 9, 8 }, { 4, 2, 7 }, { 5, 6, 7 } }; // output should be 21

		System.out.println(formingMagicSquare(input));
		System.out.println(formingMagicSquare(input2));
		System.out.println(formingMagicSquare(input3));
		System.out.println(formingMagicSquare(input4));
		System.out.println(formingMagicSquare(input5));
		System.out.println(formingMagicSquare(input6));
		long end = System.currentTimeMillis();
		System.out.println("Duration : " + (end - start));

	}

	/**
	 * The input is a two dimensional int array (matrix) the output is the minimal
	 * costs to change this matrix into a magic matrix (the sum of any given row,
	 * column or diagonal should be the same). For example if the input is { { 5, 3,
	 * 4 }, { 1, 5, 8 }, { 6, 4, 2 } } the output will be 7.
	 * 
	 * @param input int [][]
	 * @return output int
	 */
	private static int formingMagicSquare(int[][] input) {
		/*
		 * For a 3X3 matrix with a input ranging from 1 to 9 the magic number should be
		 * 15
		 */
		int[] inputRange = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int magicNumber = Utils.getMagicNumberForMagicSquare(input.length, inputRange);

		List<List<Integer>> squareList = ArrayUtils.convert2DArrayTo2DList(input);

		List<List<Integer>> squareListTemp = new ArrayList<>();
		squareListTemp.addAll(squareList);

		List<List<Integer>> squareListOutput = new ArrayList<>();
		squareListTemp.addAll(squareList);

		/*
		 * this checks if the square is a magic square if it returns 0 then it is a
		 * magic square otherwise it will return the number of calculations that is not
		 * equal to the magic number
		 */
		int cost = 100;
		int magicSquare = Utils.checkIfSquareSumEqualsNumber(squareList, magicNumber);
		if (magicSquare != 0) {
			boolean duplicateNumbers = false;
			List<List<List<Integer>>> magicSquaresList = generateSquares(inputRange, duplicateNumbers, magicNumber);
			for (int i = 0; i < magicSquaresList.size(); i++) {
				squareListTemp = magicSquaresList.get(i);
				int currenCost = ListUtils.differanceBetweenTwo2DList(squareList, squareListTemp);
				if (currenCost < cost) {
					cost = currenCost;
					squareListOutput = squareListTemp;
				}
			}
		} else {
			cost = magicSquare;
		}
		System.out.println(squareList);
		System.out.println(squareListOutput);
		return cost;
	}

	/**
	 * This method gets a int [] input, this is the input range that is allowed,
	 * based on this input range lists will be generated where the sum equals the
	 * given number (magicNumber). There is also a boolean which specifies if there
	 * can be duplicate numbers or not in the list.
	 * 
	 * @param input          int []
	 * @param allowDuplicate {@link Boolean}
	 * @param magicNumber    int
	 * @return output 3D {@link Integer} {@link List}
	 */
	private static List<List<List<Integer>>> generateSquares(int[] input, boolean allowDuplicate, int magicNumber) {
		List<List<List<Integer>>> output = new ArrayList<>();

		List<List<Integer>> generatedLits = generateLists(magicNumber, input, allowDuplicate);

		/* Loop through the generated list 3 times because there is a square of 3X3 */
		for (int i = 0; i < generatedLits.size(); i++) {
			for (int j = 0; j < generatedLits.size(); j++) {
				for (int k = 0; k < generatedLits.size(); k++) {
					/* Create a temporary 2 dimensional List and add the values to that list */
					List<List<Integer>> outputTemp = new ArrayList<>();
					outputTemp.add(generatedLits.get(i));
					outputTemp.add(generatedLits.get(j));
					outputTemp.add(generatedLits.get(k));
					if (checkValidSquares(outputTemp, allowDuplicate, magicNumber)) {
						output.add(outputTemp);
					}
				}
			}
		}
		return output;
	}

	/**
	 * This method checks if the 2D Integer list is valid based on the given
	 * parameters and returns a boolean.
	 * 
	 * @param input          2D {@link Integer} {@link List}
	 * @param allowDuplicate {@link Boolean}
	 * @param magicNumber    int
	 * @return output {@link Boolean}
	 */
	private static boolean checkValidSquares(List<List<Integer>> input, boolean allowDuplicate, int magicNumber) {
		boolean output = true;

		/*
		 * if duplicate is not allowed the values of the List should be checked against
		 * each other
		 */
		if (!allowDuplicate) {
			boolean duplicate = ListUtils.checkListValuesForDuplicates(input.get(0), input.get(1));
			if (!duplicate) {
				duplicate = ListUtils.checkListValuesForDuplicates(input.get(0), input.get(2));
				if (!duplicate) {
					duplicate = ListUtils.checkListValuesForDuplicates(input.get(1), input.get(2));
				}
			}
			if (duplicate) {
				output = false;
			}
		}
		if (output && Utils.checkIfSquareSumEqualsNumber(input, magicNumber) != 0) {
			output = false;
		}
		return output;
	}

	/**
	 * This method generates a 2D Integer List which equals the magic number. There
	 * is also a {@link Boolean} to indicate if duplicates are allowed.
	 * 
	 * @param number         (The magic number)
	 * @param input          (The input range)
	 * @param allowDuplicate (If duplicates are allowed)
	 * @return
	 */
	private static List<List<Integer>> generateLists(int number, int[] input, boolean allowDuplicate) {
		List<List<Integer>> output = new ArrayList<>();
		/* Get the highest, lowest and max permitted inputs */
		int highest = ArrayUtils.getHighestValue(input);
		int max = highest;
		int lowest = ArrayUtils.getLowestValue(input);
		/*
		 * As long is highest number is bigger than lowest number run a for loop in the
		 * while loop. The for loop assigns the highest number to a local value and
		 * reduces this by 1 with each loop. It takes this number and sums it with the
		 * highest number if this is smaller than the provided number it calculates the
		 * Difference with the provided number. These 3 numbers are added to the list.
		 * if Duplicate number is not allowed there is an additional check for this.
		 */
		while (highest >= lowest) {
			for (int i = max; i > 0; i--) {
				int totaal = i + highest;
				if (totaal < number) {
					List<Integer> temp = new ArrayList<>();
					int diff = number - totaal;
					if (checkIfShouldAdd(i, highest, diff, max, lowest, allowDuplicate)) {
						temp.add(highest);
						temp.add(i);
						temp.add(diff);
						output.add(temp);
					}
				}
			}
			highest--;
		}
		return output;
	}

	/**
	 * This method checks the first three input numbers against the rules and
	 * returns a {@link Boolean}.
	 * 
	 * @param input1         int
	 * @param input2         int
	 * @param input3         int
	 * @param max            int
	 * @param min            int
	 * @param allowDuplicate {@link Boolean}
	 * @return output {@link Boolean}
	 */
	private static boolean checkIfShouldAdd(int input1, int input2, int input3, int max, int min,
			boolean allowDuplicate) {
		boolean output = true;
		/*
		 * Input 3 should not be smaller or bigger than max and if Duplicate is not
		 * allowed the 3 numbers should all be different
		 */
		if ((input3 < min || input3 > max)
				|| !allowDuplicate && (input1 == input2 || input1 == input3 || input2 == input3)) {
			output = false;
		}
		return output;
	}

}
