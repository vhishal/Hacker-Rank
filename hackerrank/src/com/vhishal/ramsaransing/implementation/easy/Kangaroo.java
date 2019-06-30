package com.vhishal.ramsaransing.implementation.easy;

public class Kangaroo {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/kangaroo/problem
	 */
	public static void main(String[] args) {
		int kangarooStart1 = 0;
		int kangarooVel1 = 3;
		int kangarooStart2 = 4;
		int kangarooVel2 = 2;
		String result = kangaroo(kangarooStart1, kangarooVel1, kangarooStart2, kangarooVel2);
		System.out.println(result);
	}

	/**
	 * This methods takes 4 parameters, the first a int indicating the start of the
	 * first kangaroo, the second parameter a int indicating the velocity of the
	 * jump of the first kangaroo, the third parameter a int indicating the start of
	 * the second kangaroo and the fourth parameter a int indicating the velocity of
	 * the jump of the second kangaroo. If the kangaroo land on the same space after
	 * the same number of jumps the method will return "YES", otherwise it will
	 * return "NO". For example if the input is 0, 3, 4, 2 the output will be "YES".
	 * 
	 * @param kangarooStart1 int
	 * @param kangarooVel1   int
	 * @param kangarooStart2 int
	 * @param kangarooVel2   int
	 * @return output {@link String}
	 */
	private static String kangaroo(int kangarooStart1, int kangarooVel1, int kangarooStart2, int kangarooVel2) {
		String output = "NO";
		int limit = 10000;
		for (int i = 0; i < limit; i++) {
			kangarooStart1 += kangarooVel1;
			kangarooStart2 += kangarooVel2;
			if (kangarooStart1 == kangarooStart2) {
				output = "YES";
				break;
			}
		}
		return output;
	}
}
