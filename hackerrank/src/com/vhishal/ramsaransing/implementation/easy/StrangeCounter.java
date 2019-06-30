package com.vhishal.ramsaransing.implementation.easy;

public class StrangeCounter {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/strange-code/problem
	 */
	public static void main(String[] args) {
		long result = strangeCounter(1000000000000L);
		System.out.println(result);
	}

	/**
	 * This method takes a long as parameter this indicates a "time" element. The
	 * method returns a long value based on the time element. The rules for
	 * calculating the values are: the counter counts down in cycles. In next
	 * second, the timer resets to 2X the initial number for the prior cycle and
	 * continues counting down. The start time is 1 and the end time is 3. And the
	 * first period consists of 3 elements. For example if the input is
	 * 1000000000000L the output will be 649267441662
	 * 
	 * @param time long
	 * @return output long
	 */
	static long strangeCounter(long time) {
		long period = 3;
		long startT = 1;
		long endT = 3;

		while (time > endT) {
			period *= 2;
			startT = endT + 1;
			endT = startT + period - 1;
		}
		return period - (time - startT);
	}
}
