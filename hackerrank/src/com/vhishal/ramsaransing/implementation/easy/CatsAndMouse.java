package com.vhishal.ramsaransing.implementation.easy;

public class CatsAndMouse {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
	 */
	public static void main(String[] args) {
		String result = catAndMouse(1, 3, 2);
		System.out.println(result);
	}

	/**
	 * This method takes 3 int value's. The first parameter is the position of the
	 * first 'cat', the second parameter is the position of the second 'cat' and the
	 * third parameter is the position of the 'mouse'. If the difference between the
	 * first cat and mouse is the same as the difference between the second cat and
	 * mouse the method will return "Mouse C". Else it will return the cat that is
	 * closest to the mouse. For example is the input is 1, 3, 2 the output will be
	 * "Mouse C".
	 * 
	 * @param x int
	 * @param y int
	 * @param z int
	 * @return output {@link String}
	 */
	static String catAndMouse(int x, int y, int z) {
		String output = "Mouse C";
		int cat1Mouse = z - x > 0 ? z - x : x - z;
		int cat2Mouse = z - y > 0 ? z - y : y - z;
		if (cat1Mouse != cat2Mouse) {
			if (cat1Mouse > cat2Mouse) {
				output = "Cat B";
			} else {
				output = "Cat A";
			}
		}
		return output;
	}

}
