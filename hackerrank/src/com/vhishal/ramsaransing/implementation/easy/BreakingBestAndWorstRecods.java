package com.vhishal.ramsaransing.implementation.easy;

import java.util.Arrays;

public class BreakingBestAndWorstRecods {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
	 */
	public static void main(String[] args) {

		int[] scores = { 3, 4, 21, 36, 10, 28, 35, 5, 24, 42 };
		int[] result = breakingRecords(scores);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * This method takes a int Array of "scores" and returns a int Array with 2
	 * values. The first value is an indication of how many times the high score has
	 * been broken and the second value how many times the low score has been
	 * broken. The high and low score are assigned based on the first element of the
	 * array and after that when either of them are broken. For example if the input
	 * is { 3, 4, 21, 36, 10, 28, 35, 5, 24, 42 } the output will be [4, 0].
	 * 
	 * @param scores int []
	 * @return result int []
	 */
	static int[] breakingRecords(int[] scores) {
		int score;
		int highscore = 0;
		int lowscore = 0;
		int brokeHigh = 0;
		int brokeLow = 0;
		for (int i = 0; i < scores.length; i++) {
			score = scores[i];
			if (i == 0) {
				highscore = scores[i];
				lowscore = scores[i];
			} else {
				if (score > highscore) {
					brokeHigh++;
					highscore = scores[i];
				}
				if (score < lowscore) {
					brokeLow++;
					lowscore = scores[i];
				}
			}
		}
		int[] result = { brokeHigh, brokeLow };
		return result;
	}

}
