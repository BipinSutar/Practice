package com.bipin.practice.IO;

public class StringRnD {

	public static void main(String[] args) {
		System.out.println(new StringRnD().isStringNullOrBlank(""));

	}

	private boolean isStringNullOrBlank(String check) {
		if (check == null || check.equals("")) {
			return true;
		}
		return false;
	}

}
