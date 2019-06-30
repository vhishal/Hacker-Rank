package com.vhishal.ramsaransing.implementation.easy;

import java.util.Arrays;

public class SockMerchant {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/sock-merchant/problem
	 */
	public static void main(String[] args) {
		int[] socks = { 10, 20, 20, 10, 10, 30, 50, 10, 20, 50 };
		int result = sockMerchant(socks);
		System.out.println(result);
	}

	/**
	 * This method takes a int Array and returns the number of value pairs there
	 * are. For example if the input is { 10, 20, 20, 10, 10, 30, 50, 10, 20, 50 }
	 * the output will be 4.
	 * 
	 * @param ar int []
	 * @return output int
	 */
	static int sockMerchant(int[] ar) {
		int output = 0;
		Arrays.parallelSort(ar);
		int aantal = 0;
		for (int i = 0; i < ar.length; i++) {
			if (i == 0) {
				aantal++;
			} else {
				if (ar[i] == ar[i - 1]) {
					aantal++;
					if (aantal % 2 == 0) {
						output++;
					}
				} else {
					aantal = 1;
				}
			}
		}
		return output;

	}
}
