package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class HSBC_21Jun {
	public static void mainHelpJohn(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i_arr = 0; i_arr < N; i_arr++) {
			arr[i_arr] = sc.nextInt();
		}
		solve(arr);
		sc.close();
	}
	static void solve(int[] arr) {
		TreeSet<Integer> ts = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			Integer small = ts.floor(arr[i] - 1);
			if (small == null) {
				sb.append("-1 ");
			} else {
				sb.append(small + " ");
			}
			Integer great = ts.ceiling(arr[i] + 1);
			if (great == null) {
				sb.append("-1 ");
			} else {
				sb.append(great);
			}
			sb.append("\n");
			ts.add(arr[i]);
		}
		System.out.println(sb.toString());

	}
	public static void mainSamHeight(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String line[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0]);
			int s = Integer.parseInt(line[1]);
			int arr[] = new int[n + 1];
			line = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			arr[n] = s;
			sb.append(getMinimumTime(arr, n, s) + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	public static int getMinimumTime(int[] arr, int n, int s) {
		int ans = 0;
		arr[n] = s;
		Arrays.sort(arr);
		int pos = Arrays.binarySearch(arr, s) + 1;
		boolean isEvenLengthArr = (arr.length & 1) == 0;
		int mid = arr.length / 2;
		if (isEvenLengthArr) {
			ans = mod(pos - mid);
			if (mid >= pos) {
				ans = ans * 2 + 1;
			} else {
				ans = ans * 2 - 1;
			}
		} else {
			mid++;
			ans = mod(pos - mid);
			ans = ans * 2;
		}
		return ans;
	}
	public static int mod(int x) {
		return x < 0 ? -x : x;
	}
	public static void main(String[] args) {
		TestClass.main(args);
		MyString.main(args);
		charCount.main(args);
		ArrayList<Integer> hack = new ArrayList<Integer>();
		hack.add(7);
		hack.add(8);
		hack.add(9);
		hack.add(11);
		hack.forEach(a -> System.out.println(a));
		hack.forEach(a -> {
			if (a % 2 == 0)
				System.out.println(a);
		});
		int hck;
		try {
			hck = System.in.read();
			System.out.println(hck);
		} catch (IOException hackEx) {
			System.out.println("Input not read");
		}
		try {
			HackerEarth.main(args);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class TestClass {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 4));

		ListIterator<Integer> rl = li.listIterator(li.size());
		while (rl.hasPrevious()) {
			System.out.print(rl.previous() + " ");
		}
		System.out.println();
	}

}

class StrPerm {

	public static void main(String args[]) {

		List<String> output = StrPerm.genPerm("AB");
		output.stream().forEach(System.out::println);
	}

	public static List<String> genPerm(String input) {
		List<String> strList = new ArrayList<String>();
		StrPerm.permutations("", input, strList);
		return strList;
	}

	private static void permutations(String consChars, String str,
			List<String> opContainer) {

		for (int i = 0; i < str.length(); i++) {
			// permutations(consChars + str.charAt(i),
			// str.substring(0, +str.substring(i + 1), opContainer));
		}
	}
}
class MyString {
	public MyString(String val) {
		this.val = val;
	}
	private String val;

	public static void main(String args[]) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		String str1 = new String("Java OOPs!");
		String str2 = new String("Java OOPs");
		map1.put(str1, new Integer(10));
		map1.put(str2, new Integer(20));
		Map<MyString, Integer> map2 = new HashMap<MyString, Integer>();
		MyString str3 = new MyString(str1);
		MyString str4 = new MyString(str2);
		map2.put(str3, new Integer(10));
		map2.put(str4, new Integer(20));
		System.out.println(map1.get(str1));
		System.out.println(map2.get(str3));
	}
}
class charCount {
	static void charNum(String inputString) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] strArray = inputString.toCharArray();
		for (char c : strArray) {
			if (charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c) + 1);
			} else {
				charMap.put(c, 1);
			}
		}
		Set<Character> charsInString = charMap.keySet();
		for (Character ch : charsInString) {
			if (charMap.get(ch) > 1) {
				System.out.println(ch + " : " + charMap.get(ch));
			}
		}
	}

	public static void main(String[] args) {
		charNum("JavaJ2Ee");
	}
}
class HackerEarth extends Thread {

	static CopyOnWriteArrayList hck = new CopyOnWriteArrayList();

	public void testhack() {
		hck.add("K");
	}

	public static void main(String[] args) throws InterruptedException {
		hck.add("H");
		hck.add("A");
		hck.add("C");
		HackerEarth t = new HackerEarth();
		t.testhack();

		Thread.sleep(1000);
		Iterator test1 = hck.iterator();
		while (test1.hasNext()) {
			String s = (String) test1.next();
			System.out.println(s);
			Thread.sleep(1000);
		}
		System.out.println(hck);
	}
}