package com.bipin.practice.algo;

/***
 * 
 * @author BipinSutar </br>
 *         This class have method getMinimum() which compares the two numbers
 *         without comparision operators.
 * 
 *
 */
public class CompareWithoutComparisionOperatorTest {

	public static void main(String[] args) {
		System.out.println("hello world");
		long a = Long.MAX_VALUE;
		long b = Long.MAX_VALUE - 2;
		System.out.println("A " + a + " b " + b);
		System.out.println(getMinumum(a, b));

	}

	public static long getMinumum(long a, long b) {
		int min = 0;
		int lastofa = (int) a % 10;
		int lastofb = (int) b % 10;
		long tempa = lastofa, tempb = lastofb;
		while (tempa > 0 && tempb > 0) {
			tempa--;
			tempb--;
			min++;
		}

		return (lastofa - min == 0) ? a : b;
	}

}
