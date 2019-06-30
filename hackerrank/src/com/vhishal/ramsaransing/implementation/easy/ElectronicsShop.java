package com.vhishal.ramsaransing.implementation.easy;

public class ElectronicsShop {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/electronics-shop/problem
	 */
	public static void main(String[] args) {
		int[] keyboards = { 3, 1 };
		int[] drives = { 5, 2, 8 };
		int result = getMoneySpent(keyboards, drives, 10);
		System.out.println(result);
	}

	/**
	 * This method takes 3 parameters the first is a Array of int indicating the
	 * keyboards prices, the second a Array of int indicating drive prices and the
	 * third a int indicating the budget. The method will return the maximum amount
	 * that can be used within the budget when buying a keyboard and a drive. For
	 * example if the input is { 3, 1 }, { 5, 2, 8 } and 10 the output will be 9.
	 * 
	 * @param keyboards int []
	 * @param drives    int []
	 * @param b         int
	 * @return output int
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int output = -1;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int keyboardAndDrive = keyboards[i] + drives[j];
				if (output < keyboardAndDrive && b >= keyboardAndDrive) {
					output = keyboardAndDrive;
				}
			}
		}
		return output;
	}

}
