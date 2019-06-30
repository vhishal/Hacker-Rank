package com.vhishal.ramsaransing.implementation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BonAppetit {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/bon-appetit/problem
	 */
	public static void main(String[] args) {
		List<Integer> bill = new ArrayList<Integer>();
		bill.addAll(Arrays.asList(3, 10, 2, 9));
		bonAppetit(bill, 1, 12);
	}

	/**
	 * This method takes 3 parameters the first is a {@link Integer} {@link List}
	 * which indicates the elements of the bill. The second parameter is the index
	 * of the element to be excluded from the sum and the third element is the
	 * calculated sum. The method will print "Bon Appetit" if the sum of the first
	 * parameters elements (Excluding the provided index given in the second
	 * parameter) are equal to the third parameter otherwise it will print the
	 * difference
	 * 
	 * @param bill {@link Integer} {@link List}
	 * @param k    int
	 * @param b    int
	 */
	static void bonAppetit(List<Integer> bill, int k, int b) {
		int sum = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i != k) {
				sum += bill.get(i);
			}
		}
		sum /= 2;
		if (sum == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - sum);
		}
	}

}
