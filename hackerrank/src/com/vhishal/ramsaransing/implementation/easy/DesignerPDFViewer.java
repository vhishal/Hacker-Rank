package com.vhishal.ramsaransing.implementation.easy;

public class DesignerPDFViewer {

	/*
	 * Problem link:
	 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
	 */
	public static void main(String[] args) {
		int[] h = { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7 };
		System.out.println(designerPdfViewer(h, "zaba"));
	}

	/**
	 * This method takes a int array which represents the height of each letter of
	 * the alphabet and a {@link String} "word". The method returns an int based on
	 * the height of the highest letter of the word multiplied by the length of the
	 * word. For example if the input is { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,
	 * 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7 } and "zaba" the output will be 28.
	 * 
	 * @param h    int []
	 * @param word {@link String}
	 * @return output int
	 */
	static int designerPdfViewer(int[] h, String word) {
		int output = 0;
		char[] ch = word.toLowerCase().toCharArray();
		for (char c : ch) {
			int temp = (int) c;
			if (temp <= 122 && temp >= 97) {
				// for lower case 96
				int index = (temp - 96) - 1;
				if (output < h[index]) {
					output = h[index];
				}
			}
		}
		output *= word.length();
		return output;
	}

}
