package com.vhishal.ramsaransing.warrmup;

public class Straircase {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/staircase/problem
	 */
	public static void main(String[] args) {
		staircase(10);
	}

	/**
	 * Takes a int as input and prints a "staircase".
	 * 
	 * @param input int number of steps
	 */
	static void staircase(int input) {
		for (int i = 0; i < input; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = input - 1; j > i; j--) {
				sb.append(" ");
			}
			for (int j = 0; j <= i; j++) {
				sb.append("#");
			}
			System.out.println(sb.toString());
		}
	}
}
