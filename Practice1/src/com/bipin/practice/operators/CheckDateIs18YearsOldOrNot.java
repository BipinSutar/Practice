package com.bipin.practice.operators;

import java.util.Date;

public class CheckDateIs18YearsOldOrNot {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("bipin,arun,sutar,");
		System.out.println(sb.substring(0, sb.length()-1));
		CheckDateIs18YearsOldOrNot o = new CheckDateIs18YearsOldOrNot();
		o.isUser18Older(new Date(), 18);

	}

	private boolean isUser18Older(Date userDob, int minimumAge) {
		Date minAge = new Date();
		int yearDiff = (1900 + minAge.getYear()) - userDob.getYear();
		if (yearDiff > 18)
			return true;
		if (yearDiff == 18) {
			int daysDiff = getDayOfYear(minAge) - getDayOfYear(userDob);
			if (daysDiff >= 0)
				return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	private static int getDayOfYear(Date userDob) {
		int dayOfYear = 0;
		boolean isLeapYear = isLeapYear(userDob.getYear());
		int feb_days = isLeapYear ? 29 : 28;
		for (int i = 1; i < userDob.getMonth(); i++) {
			if (i == 2) {
				dayOfYear += feb_days;
				continue;
			}
			if (i % 2 == 0) {
				dayOfYear += 30;
			} else {
				dayOfYear += 31;
			}
		}
		return dayOfYear + userDob.getDate();
	}

	private static boolean isLeapYear(int year) {
		boolean isLeap = false;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					isLeap = true;
				else
					isLeap = false;
			} else
				isLeap = true;
		} else {
			isLeap = false;
		}
		return isLeap;
	}

}
