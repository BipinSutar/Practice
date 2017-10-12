package com.bipin.practice.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

class ActivityDetails implements Comparable<ActivityDetails> {
	private int start, finish;
	private String activityName;

	ActivityDetails(String activityName, int start, int finish) {
		this.start = start;
		this.finish = finish;
		this.activityName = activityName;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public int compareTo(ActivityDetails o) {
		// TODO Auto-generated method stub
		return this.finish - o.finish;
	}

	@Override
	public String toString() {
		return "ActivityDetails [start=" + start + ", finish=" + finish + ", activityName=" + activityName + "]";
	}

}

public class ActivitySelectionProblem {

	public static void main(String[] args) {
		String actName[] = { "A0", "A1", "A2", "A3", "A4", "A5" };
		int s[] = { 0, 3, 1, 5, 5, 8 };
		int f[] = { 6, 4, 2, 9, 7, 9 };
		int i, j;
		LinkedList<ActivityDetails> list = new LinkedList<>();
		for (i = 0; i < s.length; i++) {
			list.add(new ActivityDetails(actName[i], s[i], f[i]));
		}
		Collections.sort(list);
		i = 0;
		ActivityDetails obj_i = list.get(i);
		display(obj_i.getStart(), obj_i.getFinish());
		for (j = 1; j < s.length; j++) {
			obj_i = list.get(i);
			ActivityDetails obj_j = list.get(j);
			if (obj_j.getStart() >= obj_i.getFinish()) {
				display(obj_j.getStart(), obj_j.getFinish());
				i = j;
			}
		}
	}

	public static void display(int start, int finish) {
		System.out.println("(" + start + "," + finish + ") , ");
	}
}
