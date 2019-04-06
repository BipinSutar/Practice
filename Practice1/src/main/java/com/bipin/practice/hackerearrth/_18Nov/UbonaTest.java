package com.bipin.practice.hackerearrth._18Nov;

import java.util.ArrayList;
import java.util.Collections;

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
	}

	public static void getMaxPlatform() {
		// String arrivals[] = { "1:00", "1:40", "1:50", "2:00", "2:15", "4:00"
		// };
		// String departurs[] = { "1:10", "3:00", "2:20", "2:30", "3:15", "6:00"
		// };
		int arrivals[] = {900, 940, 950, 1100, 1500, 1800};
		int departurs[] = {910, 1200, 1120, 1130, 1900, 2000};
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
			maxPltcount = (maxPltcount < platforcount)
					? platforcount
					: maxPltcount;
		}
		System.out.println(maxPltcount);

	}

}
