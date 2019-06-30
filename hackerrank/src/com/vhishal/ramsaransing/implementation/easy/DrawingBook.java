package com.vhishal.ramsaransing.implementation.easy;

public class DrawingBook {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/drawing-book/problem
	 */
	public static void main(String[] args) {
		System.out.println(pageCount(6, 4));
	}

	/**
	 * This method takes 2 parameters, the first is a int indicating the number of
	 * pages in a book and the second parameter a int indicating the page number to
	 * turn to. The method will return the number of the pages that need to be
	 * turned to reach the desired page. For example if the input is 6 and 4 the
	 * output will be 1
	 * 
	 * @param n int
	 * @param p int
	 * @return output int
	 */
	static int pageCount(int n, int p) {
		int output = 0;
		int pagina1 = Math.abs(p / 2);
		if (n % 2 == 0) {
			n++;
		}
		int pagina2 = Math.abs((p - n) / 2);
		if (pagina1 < pagina2) {
			output = pagina1;
		} else {
			output = pagina2;
		}
		return output;
	}

}
