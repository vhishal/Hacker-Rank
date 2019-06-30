package com.vhishal.ramsaransing.warrmup;

import java.util.Arrays;

public class TimeConversion {

	/*
	 * Problem link: https://www.hackerrank.com/challenges/time-conversion/problem
	 */
	public static void main(String[] args) {
		String time = "12:00:00AM";
		System.out.println(timeConversion(time));
	}

	/**
	 * Takes a String input of time in AM/PM and returns the time in 24 hour format String.
	 * For example input is '12:00:00AM' and the output is '00:00:00'
	 * 
	 * @param input {@link String} time in AM/PM
	 * @return output {@link String} time in 24 hour
	 */
	static String timeConversion(String input) {
		String[] timesplits = input.split(":");
		System.out.println(Arrays.toString(timesplits));
		String hours = timesplits[0];
		if (timesplits[timesplits.length - 1].contains("PM")) {
			if (Integer.valueOf(timesplits[0]) != 12) {
				hours = String.valueOf(Integer.valueOf(timesplits[0]) + 12);
			}
		} else {
			if (Integer.valueOf(timesplits[0]) == 12) {
				hours = "00";
			}
		}
		return hours + ":" + timesplits[1] + ":" + timesplits[2].substring(0, 2);
	}

}
