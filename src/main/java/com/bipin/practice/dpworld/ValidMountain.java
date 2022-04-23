package com.bipin.practice.dpworld;

public class ValidMountain {

	public static void main(String[] args) {
		System.out.println(validMoutain(new int[] { 1, 2, 3, 4, 5, 4, 3, 2 }));
		System.out.println(validMoutain(new int[] { 1, 2, 3, 4 }));
		System.out.println(validMoutain(new int[] { 4, 3, 2, 1 }));
		System.out.println(validMoutain(new int[] { 1, 2, 3, 4, 3, 5, 4 }));
	}
//	[1,2,3,4,5,4,3,2]-Yes
//	[1,2,3,4,]-No
//	[4,3,2,1]-No
//	[1,2,3,4,3,5,4],No

	public static boolean validMoutain(int arr[]) {
		if (arr.length < 3) {
			return false;
		}
		int i = 1;
		for (; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				continue;
			} else {
				break;
			}
		}
		if (i == 1 || i == arr.length) {
			return false;
		}

		for (; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				continue;
			} else {
				break;
			}
		}

		return i == arr.length;
	}

}
