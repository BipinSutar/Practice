package com.bipin.practice.hackerearrth._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Cognizant_15Dec {

	public static void main_v1(String[] args) throws IOException { // mainSringOperations

	}

	private static StringBuilder smartReverse(int begin, int end, StringBuilder sb) {
		String[] str_Array = new String[3];
		str_Array[0] = sb.substring(0, begin);
		str_Array[1] = sb.substring(begin, end + 1);
		str_Array[2] = sb.substring(end + 1, sb.length());
		StringBuilder newsb = new StringBuilder(str_Array[0]);
		StringBuilder revWord = new StringBuilder(str_Array[1]);
		revWord.reverse();
		newsb.append(revWord.toString()).append(str_Array[2]);
		return newsb;
	}

	public static void main(String[] args) throws IOException { // mainSringOperations
		System.out.println("bipin".substring(1));
		// solv1();
		solv2();
		// solveSchoolPlayer();
	}

	public static void solv1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder in = new StringBuilder(br.readLine());
		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			String split[] = br.readLine().split(" ");
			in.setCharAt((Integer.parseInt(split[0]) - 1), split[1].charAt(0));
			// System.out.println("In Q " + in.toString());
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder in_after = new StringBuilder(in);
		while (M-- > 0) {
			String split[] = br.readLine().split(" ");
			in_after = smartReverse((Integer.parseInt(split[0]) - 1), (Integer.parseInt(split[1]) - 1), in_after);
			// System.out.println("In M " + in_after.toString());
		}
		String in_s = in.toString();
		String in_after_s = in_after.toString();
		System.out.println(in_s);
		System.out.println(in_after_s);
		int diff = in_s.toString().compareTo(in_after_s.toString());
		System.out.println((diff < 0) ? -diff + 1 : diff);
		br.close();
	}

	public static void solv2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in = br.readLine().toCharArray();
		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			String split[] = br.readLine().split(" ");
			in[Integer.parseInt(split[0]) - 1] = split[1].charAt(0);
		}
		int M = Integer.parseInt(br.readLine());
		char[] in_after = new char[in.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length; i++) {
			in_after[i] = in[i];
			sb.append(in[i]);
		}
		sb.append("\n");
		while (M-- > 0) {
			String split[] = br.readLine().split(" ");
			int begin = Integer.parseInt(split[0]) - 1;
			int end = Integer.parseInt(split[1]) - 1;
			int left, right = 0;
			right = end;
			for (left = begin; left < right; left++, right--) {
				// Swap values of left and right
				char temp = in_after[left];
				in_after[left] = in_after[right];
				in_after[right] = temp;
			}
			// int mid = end / 2;
			// if (end % 2 != 0)
			// mid = mid + 1;
			// for (int i = end, j = begin; i >= mid; i--, j++) {
			// char temp = in_after[j];
			// in_after[j] = in_after[i];
			// in_after[i] = temp;
			// }
		}
		int counter = 0;
		for (int i = 0; i < in.length; i++) {
			if (in_after[i] == in[i])
				counter++;
			sb.append(in_after[i]);
		}
		sb.append("\n" + counter);
		System.out.println(sb);
		br.close();
	}

	public static void solveSchoolPlayer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			// int n = Integer.parseInt(br.readLine());
			// int students[] = new int[n];
			// String studentssplit[] = br.readLine().split(" ");
			// for (int i = 0; i < n; i++) {
			// students[i] = Integer.parseInt(studentssplit[i]);
			// }
			// System.out.println(solveSchoolPlayer(n, students));
			solveSchoolPlayer_v1(br);
		}
	}

	public static long solveSchoolPlayer(int n, int students[]) {

		ArrayList<Integer> queue = new ArrayList<Integer>();
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				sum += -1;
				queue.add(i, students[i]);
				continue;
			}
			int pos = Collections.binarySearch(queue, students[i]);
			pos = -pos - 1;
			queue.add(pos, students[i]);
			if (pos == 0)
				sum += -1;
			else
				sum += queue.get(pos - 1);
		}

		return sum;

	}

	public static void solveSchoolPlayer(BufferedReader br) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String studentssplit[] = br.readLine().split(" ");
		ArrayList<Integer> queue = new ArrayList<Integer>();
		// int qdata[] = new int[n];
		// for (int i = 0; i < n; i++) {
		// qdata[i] = 0;
		// }
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			int in = Integer.parseInt(studentssplit[i]);
			int pos = Collections.binarySearch(queue, in);
			pos = -pos - 1;
			queue.add(pos, in);
			if (pos == 0)
				sum += -1;
			else
				sum += queue.get(pos - 1);

		}
		System.out.println(sum);

	}

	public static void solveSchoolPlayer_v1(BufferedReader br) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String studentssplit[] = br.readLine().split(" ");
		TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
		SortedMap<Integer, Integer> queue1;
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			int in = Integer.parseInt(studentssplit[i]);
			if (i == 0) {
				sum += -1;
				queue.put(in, i);
				continue;
			}
			queue.put(in, i);

			queue1 = queue.headMap(in);
			if (!queue1.isEmpty()) {
				sum += queue1.lastKey();
			} else
				sum += -1;

		}
		System.out.println(sum);

	}

	public static void mainException(String[] args) {// mainException Handling
		{
			try {
				Scanner in = new Scanner(System.in);
				int n = in.nextInt();
				int[] arr = new int[n];
				in.nextLine();

				for (int i = 0; i < 10; i++)
					arr[i] = Integer.parseInt(in.nextLine());

				String s = in.nextLine();
				System.out.println(s.charAt(10));

				solve(arr);
			}
			// Write your code here
			catch (StringIndexOutOfBoundsException e) {
				System.out.println("Index is invalid");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array index is invalid");
			} catch (ArithmeticException e) {
				System.out.println("Invalid division");
			} catch (NumberFormatException e) {
				System.out.println("Format mismatch");
			} catch (MyException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception encountered");

			} finally {
				System.out.println("Exception Handling Completed");
			}
		}

	}

	private static void solve(int[] arr) throws Exception {
		int ans = 0;

		for (int i = 0; i < 10; i++)
			for (int j = i + 1; j < 10; j++)
				ans += arr[i] / arr[j];

		throw new MyException(ans);

	}
}

class MyException extends Exception {
	// int param;

	// MyException() {
	// super();
	// }

	MyException(int ans) {
		super("MyException[" + ans + "]");
		// this.param = ans;
	}
}
