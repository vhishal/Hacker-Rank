package com.vhishal.ramsaransing.other;

import java.util.Arrays;

import com.vhishal.ramsaransing.utilities.arrays.ArrayUtils;

public class ScaleBalancing {

	/*
	 * Problem: Have the function ScaleBalancing(strArr) read strArr which will
	 * contain two elements, the first being the two positive integer weights on a
	 * balance scale (left and right sides) and the second element being a list of
	 * available weights as positive integers. Your goal is to determine if you can
	 * balance the scale by using the least amount of weights from the list, but
	 * using at most only 2 weights. For example: if strArr is ["[5, 9]",
	 * "[1, 2, 6, 7]"] then this means there is a balance scale with a weight of 5
	 * on the left side and 9 on the right side. It is in fact possible to balance
	 * this scale by adding a 6 to the left side from the list of weights and adding
	 * a 2 to the right side. Both scales will now equal 11 and they are perfectly
	 * balanced. Your program should return a comma separated string of the weights
	 * that were used from the list in ascending order, so for this example your
	 * program should return the string 2,6
	 * 
	 * There will only ever be one unique solution and the list of available weights
	 * will not be empty. It is also possible to add two weights to only one side of
	 * the scale to balance it. If it is not possible to balance the scale then your
	 * program should return the string not possible.
	 */

	public static void main(String[] args) {
		String solution = scaleBalance(new String[] { "[3, 4]", "[1, 2, 7, 7]" });
		System.out.println(solution);
		solution = scaleBalance(new String[] { "[13, 4]", "[1, 2, 3, 6, 14]" });
		System.out.println(solution);
		solution = scaleBalance(new String[] { "[99, 109]", "[1, 2, 3, 6, 14, 5, 11]" });
		System.out.println(solution);

	}

	/**
	 * The input is a String Array containing 2 elements. The first being two
	 * positive integers and the second element being a list of positive integers.
	 * The Integers of the first element can be seen as value'son a scale and the
	 * Integers of the second element can be seen as value's which can be used to
	 * balance the scale. Only 2 value's of the second element can be used, if it is
	 * not possible to balance the 'scale' using only 2 value's of the second
	 * element the output should be "not possible" otherwise the value or value's
	 * which will be used to balance the scale should be returned. For example if
	 * the input is { "[3, 4]", "[1, 2, 7, 7]" } the output will be 1.
	 * 
	 * @param input {@link String} []
	 * @return output {@link String}
	 */
	private static String scaleBalance(String[] input) {
		String output = "not possible";
		/* The input array should have 2 elements */
		if (input.length == 2) {
			int[] scaleValues = ArrayUtils.convertStringToIntArray(input[0]);
			int[] balancingValues = ArrayUtils.convertStringToIntArray(input[1]);
			Arrays.parallelSort(scaleValues);
			Arrays.parallelSort(balancingValues);
			int scaleDifference = scaleValues[1] - scaleValues[0];
			boolean checkTwoWheights = true;
			for (int i = 0; i < balancingValues.length; i++) {
				int currentL1 = balancingValues[i];
				if (currentL1 == scaleDifference) {
					output = String.valueOf(currentL1);
					checkTwoWheights = false;
					break;
				}
			}
			if (checkTwoWheights) {
				Outer: for (int i = 0; i < balancingValues.length; i++) {
					int currentL1 = balancingValues[i];
					for (int j = 0; j < balancingValues.length; j++) {
						if (i != j) {
							int currentL2 = balancingValues[j];
							if ((currentL1 + currentL2) == scaleDifference) {
								output = currentL1 + ", " + currentL2;
								break Outer;
							}
						}
					}
				}
			}
		}
		return output;
	}

}
