package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class TrustingSocial_19May {

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeMap<Integer, Integer> tmp = new TreeMap<>(Collections.reverseOrder());
		while (n-- > 0) {
			int t = sc.nextInt();
			if (t == 1) {
				tmp.put(sc.nextInt(), 1);
			} else {
				int len = tmp.size();
				if (len < 4) {
					System.out.println("Not enough enemies");
				} else {
					System.out.println(tmp.keySet().toArray()[((len / 3) - 1)]);
				}
			}
		}
		sc.close();

	}

	public static void main2(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		TreeMap<Integer, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
		int array_size = 0;
		StringBuilder sb = new StringBuilder();
		String newline = "\n";
		String noten = "Not enough enemies";
		int div3 = 0;
		int val = 0;
		while (n-- > 0) {
			String line[] = br.readLine().split(" ");
			int t = Integer.parseInt(line[0]);
			if (t == 1) {
				int num = Integer.parseInt(line[1]);
				array_size++;
				tmap.put(num, 1);
				div3 = array_size / 3;
			} else {
				if (array_size < 3) {
					sb.append(noten + newline);
					continue;
				}
				int counter = 1;
				for (Integer i : tmap.keySet()) {
					if (counter > div3) {
						break;
					} else {
						val = i;
						counter++;
					}
				}
				sb.append(val + newline);
			}

		}
		System.out.println(sb);
		br.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		TreeMap<Integer, Integer> tmap = new TreeMap<>(Collections.reverseOrder());
		int array_size = 0;
		StringBuilder sb = new StringBuilder();
		String newline = "\n";
		String noten = "Not enough enemies";
		int div3 = 0;
		int prevDiv3 = div3;
		int ans = Integer.MIN_VALUE;
		while (n-- > 0) {
			String line[] = br.readLine().split(" ");
			int t = Integer.parseInt(line[0]);
			if (t == 1) {
				int num = Integer.parseInt(line[1]);
				array_size++;
				div3 = array_size / 3;
				tmap.put(num, 1);
				if (array_size <= 3) {
					ans = max(ans, num);
				} else {
					if (prevDiv3 == div3) {
						if (num > ans) {
							ans = tmap.floorKey(ans + 1);
						} else {
							// ans = tmap.ceilingKey(ans+1);
						}
					} else {
						if (num < ans) {
							ans = tmap.ceilingKey(ans - 1);
						} else {
							// ans = tmap.floorKey(ans+1);
						}
					}
				}
				prevDiv3 = div3;
			} else {
				if (array_size < 3) {
					sb.append(noten + newline);
					continue;
				}
				sb.append(ans + newline);
			}

		}
		System.out.println(sb);
		br.close();
	}
	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}
	public static long max(long a, long b) {
		return (a >= b) ? a : b;
	}

	public static void mainBugs(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			long initial_Score[] = new long[4];
			long decreasing_score[] = new long[4];
			long flash_time[] = new long[4];
			long cisco_time[] = new long[4];
			long flashscore = 0;
			long ciscoscore = 0;
			long max_time_flash = Long.MIN_VALUE;
			long max_time_cisco = Long.MIN_VALUE;
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				initial_Score[i] = Long.parseLong(line[i]);
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				decreasing_score[i] = Long.parseLong(line[i]);
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				flash_time[i] = Long.parseLong(line[i]);
				max_time_flash = max(max_time_flash, flash_time[i]);
				flashscore = flashscore
						+ max(initial_Score[i] - (flash_time[i] * decreasing_score[i]), (initial_Score[i] / 2));
			}
			line = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				cisco_time[i] = Long.parseLong(line[i]);
				max_time_cisco = max(max_time_cisco, cisco_time[i]);
				ciscoscore = ciscoscore
						+ max(initial_Score[i] - (cisco_time[i] * decreasing_score[i]), (initial_Score[i] / 2));
			}
			String ans = "";
			if (flashscore == ciscoscore) {
				if (max_time_flash == max_time_cisco) {
					ans = "Tie";
				} else if (max_time_flash < max_time_cisco) {
					ans = "Flash";
				} else
					ans = "Cisco";
			} else {
				if (flashscore > ciscoscore)
					ans = "Flash";
				else
					ans = "Cisco";
			}
			// sb.append(getWinner(initial_Score, decreasing_score, flash_time, cisco_time)
			// + "\n");
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
