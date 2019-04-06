package com.bipin.practice.hackerrank.wcode35.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Point {
	int x, y;

	public Point(int inf2, int y2) {
		this.x = inf2;
		this.y = y2;
	}

}

public class LatticePoints {

	public static final int INF = Integer.MAX_VALUE;

	public static boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) && q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y))
			return true;
		return false;
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int min(int a, int b) {
		return (a > b) ? b : a;
	}

	public static int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0)
			return 0; // colinear
		return (val > 0) ? 1 : 2; // clock or counterclock wise
	}

	public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		// Find the four orientations needed for general and
		// special cases
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		// p1, q1 and p2 are colinear and p2 lies on segment p1q1
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;

		// p1, q1 and p2 are colinear and q2 lies on segment p1q1
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;

		// p2, q2 and p1 are colinear and p1 lies on segment p2q2
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;

		// p2, q2 and q1 are colinear and q1 lies on segment p2q2
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false; // Doesn't fall in any of the above cases
	}

	public static boolean isInside(Point polygon[], int n, Point p) {
		// There must be at least 3 vertices in polygon[]
		if (n < 3)
			return false;

		// Create a point for line segment from p to infinite
		Point extreme = new Point(INF, p.y);
		// Count intersections of the above line with sides of polygon
		int count = 0, i = 0;
		do {
			int next = (i + 1) % n;

			// Check if the line segment from 'p' to 'extreme' intersects
			// with the line segment from 'polygon[i]' to 'polygon[next]'
			if (doIntersect(polygon[i], polygon[next], p, extreme)) {
				// If the point 'p' is colinear with line segment 'i-next',
				// then check if it lies on segment. If it lies, return true,
				// otherwise false
				if (orientation(polygon[i], p, polygon[next]) == 0)
					return onSegment(polygon[i], p, polygon[next]);

				count++;
			}
			i = next;
		} while (i != 0);

		// Return true if count is odd, false otherwise
		return (count % 2 != 0) ? true : false; // Same as (count%2 == 1)
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point polygon1[] = new Point[N];
		int data[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			int count = 0;
			int x = sc.nextInt();
			int y = sc.nextInt();
			data[i][count] = x;
			count++;
			data[i][count] = y;
			count = 0;
			polygon1[i] = new Point(x, y);
		}
		Arrays.sort(data, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int x_min = data[0][0];
		int x_max = data[data.length - 1][0];
		Arrays.sort(data, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int y_max = data[data.length - 1][1];
		int y_min = data[0][1];
		int count = 0;
		for (int i = x_min + 1; i < x_max; i++) {
			for (int j = y_min + 1; j < y_max; j++) {
				// System.out.println(i + " " + j);
				if (isInside(polygon1, N, new Point(i, j)))
					count++;
			}
		}
		System.out.println(count);
	}

}
