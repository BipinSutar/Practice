package com.bipin.practice.operators;

public class DateConvertToDayOftheWeek {
	public static void main(String[] args) {
		java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");

		java.util.Date date = null;
		try {
			date = dateFormat.parse("28" + "/" + "1" + "/" + "2018");
		} catch (java.text.ParseException e) {
			date = null;
		}
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(java.util.Calendar.DAY_OF_WEEK);
		String ans = "";
		switch (dayOfWeek) {
		case 2:
			ans = "MONDAY";
			break;
		case 3:
			ans = "TUESDAY";
			break;
		case 4:
			ans = "WEDNESDAY";
			break;
		case 5:
			ans = "THURSDAY";
			break;
		case 6:
			ans = "FRIDAY";
			break;
		case 7:
			ans = "SATURDAY";
			break;
		case 1:
			ans = "SUNDAY";
			break;

		}
		System.out.println(ans);

	}
}
