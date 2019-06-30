package com.vhishal.ramsaransing.implementation.easy;

import java.util.ArrayList;
import java.util.List;

public class AppleAndOrange {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/apple-and-orange/problem
	 */
	public static void main(String[] args) {
		int houseStart = 7;
		int houseEnd = 10;
		int appleTree = 4;
		int orangeTree = 12;
		int[] appels = { 2, 3, -4 };
		int[] oranges = { 3, -2, -4 };
		countApplesAndOranges(houseStart, houseEnd, appleTree, orangeTree, appels, oranges);
	}

	/**
	 * This method takes 6 parameters. The first 2 elements are ints used to
	 * indicate the start and end position of an object (House). The following 2
	 * parameters are ints used to indicate the absolute position of 2 different
	 * objects (trees) and the last 2 elements are int Arrays to indicate the
	 * relative positions of objects (fruits) compared to the previous 2 absolute
	 * object (trees) positions. The method calculates the absolute position of the
	 * object of the 2 int Arrays and prints how many objects are in the same space
	 * as the first object (House). For example if the input is 7, 10, 4, 12, { 2,
	 * 3, -4 } and { 3, -2, -4 } the method will print 1 and 2.
	 * 
	 * @param houseStart int
	 * @param houseEnd   int
	 * @param appleTree  int
	 * @param orangeTree int
	 * @param appels     int []
	 * @param oranges    int []
	 */
	static void countApplesAndOranges(int houseStart, int houseEnd, int appleTree, int orangeTree, int[] appels,
			int[] oranges) {
		List<Integer> appelsPosition = new ArrayList<>();
		List<Integer> orangePosition = new ArrayList<>();
		for (int value : appels) {
			appelsPosition.add(appleTree + value);
		}
		for (int value : oranges) {
			orangePosition.add(orangeTree + value);
		}

		int fallenAppelsCounter = 0;
		for (int i = 0; i < appelsPosition.size(); i++) {
			if (houseStart <= appelsPosition.get(i) && appelsPosition.get(i) <= houseEnd) {
				fallenAppelsCounter++;
			}
		}
		int fallenOrangesCounter = 0;
		for (int i = 0; i < orangePosition.size(); i++) {
			if (houseStart <= orangePosition.get(i) && orangePosition.get(i) <= houseEnd) {
				fallenOrangesCounter++;
			}
		}
		System.out.println(fallenAppelsCounter);
		System.out.println(fallenOrangesCounter);
	}

}
