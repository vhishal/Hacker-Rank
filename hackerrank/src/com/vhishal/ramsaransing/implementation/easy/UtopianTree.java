package com.vhishal.ramsaransing.implementation.easy;

public class UtopianTree {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/utopian-tree/problem
	 */
	public static void main(String[] args) {
		System.out.println(utopianTree(4));
	}

	/**
	 * This method takes a int and returns a int. The standard output is 1. The
	 * first parameter is used in a loop and every time the value is divideble by 2
	 * one is added to the output else the output is multiplied by 2. For example if
	 * the input is 4 the output will be 7.
	 * 
	 * @param n int
	 * @return output int
	 */
	static int utopianTree(int n) {
		int output = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				output++;
			} else {
				output *= 2;
			}
		}
		return output;
	}

}
