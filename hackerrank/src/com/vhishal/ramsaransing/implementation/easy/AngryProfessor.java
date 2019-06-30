package com.vhishal.ramsaransing.implementation.easy;

import javax.print.DocFlavor.STRING;

public class AngryProfessor {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/angry-professor/problem
	 */
	public static void main(String[] args) {
		int[] a = { -1, -3, 4, 2 };
		System.out.println(angryProfessor(3, a));
		int[] b = { 0, -1, 2, 1 };
		System.out.println(angryProfessor(2, b));
	}

	/**
	 * This method takes 2 parameters the first is a int and the second a int Array.
	 * if the number positive integers in the int Array are equal or greater than
	 * the given int the output will be "NO", otherwise it will be "YES"
	 * 
	 * @param k int
	 * @param a int []
	 * @return output {@link STRING}
	 */
	static String angryProfessor(int k, int[] a) {
		String output = "YES";
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				counter++;
				if (counter >= k) {
					output = "NO";
					break;
				}
			}
		}
		return output;

	}

}
