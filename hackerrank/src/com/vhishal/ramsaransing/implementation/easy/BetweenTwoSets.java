package com.vhishal.ramsaransing.implementation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BetweenTwoSets {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/between-two-sets/problem
	 */
	public static void main(String[] args) {
		int[] first = { 2, 4, 8, 16 };
		int[] second = { 16, 32, 96 };
		System.out.println(getTotalX(first, second));
	}

	/**
	 * This method takes 2 int Arrays. And will print the number of ints that meet
	 * the following requirements: 1 The elements of the first array are all factors
	 * of the integer being considered. 2 The integer being considered is a factor
	 * of all elements of the second array. For example is the input is { 2, 4, 8,
	 * 16 } and { 16, 32, 96 } the method will print 1 (the elements of the first
	 * array are all factors of 16 is a factor of all elements of the second array)
	 * 
	 * @param a int []
	 * @param b int []
	 * @return output int
	 */
	static int getTotalX(int[] a, int[] b) {
		Arrays.parallelSort(a);
		Arrays.parallelSort(b);
		HashSet<Integer> commonDividers = new HashSet<>();
		HashSet<Integer> output = new HashSet<>();
		/*
		 * Get the lowest value of b and calculate all the possible factors for a that
		 * are lower or equal to the lowest value of b
		 */
		int lowestBvalue = b[0];
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 1; j <= lowestBvalue; j++) {
				int multivalue = a[i] * j;
				if (multivalue > lowestBvalue) {
					break;
				}
				boolean trueA = true;
				for (int k = 0; k < a.length; k++) {
					if (multivalue % a[k] != 0) {
						trueA = false;
						break;
					}
				}
				if (trueA) {
					commonDividers.add(multivalue);
				}
			}
		}
		List<Integer> commonDividersUnique = new ArrayList<>();
		commonDividersUnique.addAll(commonDividers);
		/*
		 * Check if the common dividers determined in the first step can be used to
		 * divide all the elements in the second array to wholesome numbers. If this is
		 * possible add them to the output
		 */
		for (int j = 0; j < commonDividersUnique.size(); j++) {
			boolean add = true;
			for (int i = 0; i < b.length; i++) {
				if (b[i] % commonDividersUnique.get(j) != 0) {
					add = false;
					break;
				}
			}
			if (add) {
				output.add(commonDividersUnique.get(j));
			}
		}
		return output.size();
	}

}
