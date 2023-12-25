package com.bipin.practice.hackerearrth._2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class IHSMarkit31Aug2020 {
	final static int INF = 10000000;
	final static int size = 100007;
	static int[] dp = new int[size];
	static int solve(int N, int M) {
		dp = new int[size];
		List<Integer> s = new ArrayList<>();
		for (int i = N; i <= M; i++) {
			dp[i] = -1;
		}
		int op = min_op(N, M, s);

		if (op >= INF)
			return -1;
		else {
			int ans = 0;
			for (int i = 0; i < s.size(); i++) {
				ans += s.get(i);
			}
			return ans;
		}
	}
	static int min_op(int cur, int M, List<Integer> s) {
		if (cur > M)
			return INF;

		if (cur == M)
			return 0;

		if (dp[cur] != -1)
			return dp[cur];

		int op = INF;
		for (int i = 2; i * i <= cur; i++) {
			if (cur % i == 0) {
				if (i % 2 == 0) {
					int mop = min_op(cur + i, M, s);
					if (mop != 0) {
						op = mop;
					}
					op = Math.min(op, M - cur);

				}
				if ((cur / i) != i && (cur / i) % 2 == 0) {
					int mop = min_op(cur + (cur / i), M, s);
					int tmp = Math.min(cur, cur / i);
					if (mop != 0) {
						op = mop;
					}
					op = Math.min(op, M - tmp);

				}
			}
		}
		return dp[cur] = op;
	}

	public static void main(String[] args) throws IOException {
		int[] array = {6, 9, 8};
		List<Integer> list = new ArrayList<>();
		list.add(array[0]);
		list.add(array[2]);
		list.set(1, array[1]);
		list.remove(0);
		System.out.println(list);
		ArrayList<Double> vals = new ArrayList<>();
		vals.add(1.0);
		vals.add(4.0);
		vals.add(16.0);
		Spliterator<Double> spltitr = vals.spliterator();
		while (spltitr.tryAdvance((n) -> System.out.print(" " + n)));
		System.out.println();
		spltitr = vals.spliterator();
		ArrayList<Double> sqrs = new ArrayList<>();
		while (spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
		spltitr = sqrs.spliterator();
		spltitr.forEachRemaining((n) -> System.out.print(" " + n));
		HackerEarth.main(args);
		StrFunc output = (str) -> {
			String result = "";
			int a;
			for (a = str.length() - 1; a >= 0; a--)
				result += str.charAt(a);
			return result;
		};

		System.out.println(output.disp("HACKEREARTH"));
		// StringBuilder b = "hacker";
		// b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
		// System.out.println(b);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);

			int out_ = solve(N, M);
			System.out.println(out_);

		}

		wr.close();
		br.close();
	}
}
class HackerEarth {

	@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
	@interface MyAnnotation {
	}

	@Retention(RetentionPolicy.RUNTIME)
	@interface Hints {
		Hint[] value();
	}

	@Repeatable(Hints.class)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Hint {
		String value();
	}

	@Hint("hint1")
	@Hint("hint2")

	class Person {
	}

	public static void main(String[] args) {
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);
		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);
		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);
	}
}
interface StrFunc {
	String disp(String n);
}