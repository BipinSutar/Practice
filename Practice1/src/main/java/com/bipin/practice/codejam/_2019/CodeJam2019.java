package com.bipin.practice.codejam._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class CodeJam2019 {
	final class ForegeoneAns {
		private final String L;
		private final String R;
		private static final String SPACE = " ";
		ForegeoneAns(String L, String R) {
			this.L = L;
			this.R = R;
		}
		public String getL() {
			return L;
		}

		public String getR() {
			return R;
		}
		@Override
		public String toString() {
			return L + SPACE + R;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((L == null) ? 0 : L.hashCode());
			result = prime * result + ((R == null) ? 0 : R.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ForegeoneAns other = (ForegeoneAns) obj;
			if (L == null) {
				if (other.L != null)
					return false;
			} else if (!L.equals(other.L))
				return false;
			if (R == null) {
				if (other.R != null)
					return false;
			} else if (!R.equals(other.R))
				return false;
			return true;
		}

	}
	public static void mainForegeoneAns(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		CodeJam2019 instance = new CodeJam2019();
		StringBuilder sb = new StringBuilder();
		int t_no = 1;
		while (t-- > 0) {
			String N = br.readLine();
			ForegeoneAns ans = instance.getForegeoneAns(N);
			sb.append("Case #" + t_no++ + ": ").append(ans).append("\n");

		}
		System.out.println(sb.toString());
		br.close();
	}
	public ForegeoneAns getForegeoneAns(String inNum_s) {
		Set<Integer> posOf4 = new LinkedHashSet<>();
		StringBuilder num = new StringBuilder(inNum_s);
		StringBuilder num2 = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '4') {
				posOf4.add(i);
				num.setCharAt(i, '3');
			}
		}
		for (int i = 0; i < num.length(); i++) {
			num2.append('0');

		}
		for (Integer p : posOf4) {
			num2.setCharAt(p, '1');
		}

		ForegeoneAns ans = new ForegeoneAns(num.toString(),
				removeLeadingZeros(num2.toString()));
		return ans;
	}
	private String removeLeadingZeros(String s) {
		return s.replaceFirst("^0+(?!$)", "");

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		CodeJam2019 instance = new CodeJam2019();
		StringBuilder sb = new StringBuilder();
		int t_no = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String N = br.readLine();
			String ans = instance.getYouCanGoYourOwnWay(n, N);
			sb.append("Case #" + t_no++ + ": ").append(ans).append("\n");

		}
		System.out.println(sb.toString());
		br.close();
	}
	public String getYouCanGoYourOwnWay2(int N, String LydiaPath) {
		StringBuilder sb = new StringBuilder();
		int mat[][] = new int[N][N];
		int row = 0;
		int col = 0;
		mat[row][col] = 1;
		for (int i = 0; i < LydiaPath.length(); i++) {
			if (LydiaPath.charAt(i) == 'E') {
				col++;
			} else {
				row++;
			}
			mat[row][col] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		char prevDirection = '0';
		if (mat[row - 1][col] == 1) {
			col--;
			sb.append("E");
			prevDirection = 'E';
		} else {
			row--;
			sb.append("S");
			prevDirection = 'S';
		}

		for (int i = LydiaPath.length() - 2; i >= 0; i--) {
			if (row != 0 && col != 0) {
				if (prevDirection == 'S') {
					if (mat[row][col] == 1) {
						col--;
						sb.append("E");
						prevDirection = 'E';
					} else if (mat[row][col] == 0) {
						row--;
						sb.append("S");
						prevDirection = 'S';
					}
				} else {// prevDirection is E we will move to S when 0
					if (mat[row][col] == 1) {
						col--;
						sb.append("E");
						prevDirection = 'E';
					} else if (mat[row][col] == 0) {
						row--;
						sb.append("S");
						prevDirection = 'S';
					}
				}

			} else {
				if (row == 0) {
					col--;
					sb.append("E");
					prevDirection = 'E';
				} else if (col == 0) {
					row--;
					sb.append("S");
					prevDirection = 'S';
				}
			}
		}
		return sb.reverse().toString();

	}
	public String getYouCanGoYourOwnWay(int N, String LydiaPath) {
		/*
		 * StringBuilder sb = new StringBuilder(LydiaPath); for (int i = 0; i <
		 * sb.length(); i++) { if (sb.charAt(i) == 'S') { sb.setCharAt(i, 'E');
		 * } else { sb.setCharAt(i, 'S'); } } return sb.toString();
		 */
		return LydiaPath.replaceAll("S", "A").replaceAll("E", "S")
				.replaceAll("A", "S");
	}
}
