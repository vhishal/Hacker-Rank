package com.vhishal.ramsaransing.implementation.easy;

import java.util.Arrays;

public class GradingStudents {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/grading/problem
	 */
	public static void main(String[] args) {
		int[] grades = { 73, 67, 38, 33 };
		int[] result = gradingStudents(grades);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * The method takes a int Array loops through the values while applying the
	 * rules and returns a int Array with the result. For example if the input is {
	 * 73, 67, 38, 33 } the output will be [75, 67, 40, 33]. The rules are if a
	 * value is lower or equal to 38 nothing happens. And If the difference between
	 * the value the and the next multiple of 5 is less than 3, round the value up
	 * to the next multiple of 5
	 * 
	 * @param grades int []
	 * @return output int []
	 */
	static int[] gradingStudents(int[] grades) {
		int[] output = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			output[i] = grades[i];
			if (grades[i] >= 38) {
				int verschil = 5 - grades[i] % 5;
				if (verschil < 3) {
					output[i] = verschil + grades[i];
				}
			}
		}
		return output;
	}

}
