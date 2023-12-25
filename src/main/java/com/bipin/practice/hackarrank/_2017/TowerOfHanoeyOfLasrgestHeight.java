package com.bipin.practice.hackarrank._2017;

import java.util.*;

class Disk {
	int r, h;

	Disk(int r, int h) {
		this.r = r;
		this.h = h;
	}

	@Override
	public String toString() {
		return "r= " + r + " h=" + h;
	}

}

public class TowerOfHanoeyOfLasrgestHeight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Disk[] darray = new Disk[n];
			Disk maxdisk = null;
			int height = 0;
			for (int i = 0; i < n; i++) {
				darray[i] = new Disk(sc.nextInt(), sc.nextInt());
				if (maxdisk == null) {
					maxdisk = darray[i];
					height += maxdisk.h;
					continue;
				}
				int com = compareTwoDisk(darray[i], darray[i - 1]);
				if (com == 1) {
					maxdisk = darray[i];
					height += maxdisk.h;
				} else if (com == 2) {
					maxdisk = darray[i - 1];
					height += maxdisk.h;
				}
			}
			System.out.println(height);

		}

	}

	public static int compareTwoDisk(Disk f, Disk s) {
		if (f.r > s.r && f.h > s.h)
			return 1;
		if (s.r > f.r && s.h > s.r)
			return 2;
		return -1;
	}

}
