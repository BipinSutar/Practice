package com.bipin.practice.hackerearrth._18Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TrainTime implements Comparable<TrainTime> {

	String arrival;
	String departure;

	public TrainTime(String arrival, String departure) {
		this.arrival = arrival;
		this.departure = departure;
	}

	@Override
	public int compareTo(TrainTime o) {
		return this.departure.compareTo(o.departure);
	}

	@Override
	public String toString() {
		return "arrival " + arrival + " departure " + departure;
	}
}

class Event implements Comparable<Event> {
	String time;
	char eventType;

	Event(String time, char eventType) {
		this.time = time;
		this.eventType = eventType;
	}

	@Override
	public int compareTo(Event o) {
		return Integer.parseInt(this.time.split(":")[0]) - Integer.parseInt(o.time.split(":")[0]);

	}

	@Override
	public String toString() {
		return "time = " + this.time + " type = " + this.eventType;
	}
}

class EventTimeinInt implements Comparable<EventTimeinInt> {
	int time;
	char eventType;

	EventTimeinInt(int time, char eventType) {
		this.time = time;
		this.eventType = eventType;
	}

	@Override
	public int compareTo(EventTimeinInt o) {
		return this.time - o.time;

	}

	@Override
	public String toString() {
		return "time = " + this.time + " type = " + this.eventType;
	}
}

public class UbonaTest {

	public static void main(String[] args) {
		getMaxPlatform();
		getMaxPlatformv2();
	}

	public static void getMaxPlatform() {
		// String arrivals[] = { "1:00", "1:40", "1:50", "2:00", "2:15", "4:00" };
		// String departurs[] = { "1:10", "3:00", "2:20", "2:30", "3:15", "6:00" };
		int arrivals[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departurs[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		ArrayList<EventTimeinInt> al = new ArrayList<EventTimeinInt>();
		for (int i = 0; i < arrivals.length; i++) {
			al.add(new EventTimeinInt(arrivals[i], 'A'));
			al.add(new EventTimeinInt(departurs[i], 'D'));
		}
		Collections.sort(al);
		int platforcount = 0;
		int maxPltcount = Integer.MIN_VALUE;
		for (EventTimeinInt a : al) {
			System.out.println(a);
			if (a.eventType == 'A')
				platforcount++;
			else if (a.eventType == 'D')
				platforcount--;
			maxPltcount = (maxPltcount < platforcount) ? platforcount : maxPltcount;
		}
		System.out.println(maxPltcount);

	}

	public static void getMaxPlatformv1() {
		System.gc();
		String arrivals[] = { "1:00", "1:40", "1:50", "2:00", "2:15", "4:00" };
		String departurs[] = { "1:10", "3:00", "2:20", "2:30", "3:15", "6:00" };
		// String arrivals[] = { "9:00", "9:40", "9:50", "11:00", "15:00", "18:00" };
		// String departurs[] = { "9:10", "12:00", "11:20", "11:30", "19:00", "20:00" };

		List<TrainTime> traintimes = new ArrayList<TrainTime>();

		for (int i = 0; i < arrivals.length; i++) {
			traintimes.add(new TrainTime(arrivals[i], departurs[i]));

		}
		Collections.sort(traintimes);
		for (TrainTime t : traintimes) {
			System.out.println(t + "  ");
		}

		for (String s : departurs) {
			System.out.print(s + "  ");
		}
		System.out.println();
		for (String s : arrivals) {
			System.out.print(s + "  ");
		}
		System.out.println();
		Arrays.sort(departurs);
		for (String s : departurs) {
			System.out.print(s + "  ");
		}
		int platformcount = 1, result = 1;
		int i = 1, j = 0;

		while (i < arrivals.length && j < arrivals.length) {
			if (arrivals[i].compareTo(departurs[j]) > 0) {
				platformcount++;
				if (platformcount > result)
					result = platformcount;
				i++;
			} else {
				platformcount--;
				j++;
			}
			// i++;
			// j++;
			System.out.println("platformcount" + result);

		}
		System.out.println(result);
	}

	public static void getMaxPlatformv2() {
		System.out.println("in getMaxPlatformv2 ");
		// int arrivals[] = { 900, 940, 950, 1100, 1500, 1800 };
		// int departurs[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int arrivals[] = { 100, 140, 150, 200, 215, 400 };
		int departurs[] = { 110, 300, 220, 230, 315, 600 };

		Arrays.sort(departurs);
		Arrays.sort(arrivals);
		int platformcount = 1, result = 1;
		int i = 1, j = 0;

		while (i < arrivals.length && j < arrivals.length) {
			if (arrivals[i] < departurs[j]) {
				platformcount++;
				if (platformcount > result)
					result = platformcount;
				i++;
			} else {
				platformcount--;
				j++;
			}

		}
		System.out.println(result);
	}

}
