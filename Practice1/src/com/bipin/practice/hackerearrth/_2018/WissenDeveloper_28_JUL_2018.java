package com.bipin.practice.hackerearrth._2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class ValueComparator<T1, T2 extends Comparable<T2>> implements Comparator<T1> {
	Map<T1, T2> base;

	public ValueComparator(Map<T1, T2> base) {
		this.base = base;
	}

	@Override
	public int compare(T1 k1, T1 k2) {
		T2 val1 = base.get(k1);
		T2 val2 = base.get(k2);
		int res = val1.compareTo(val2);
		if (res == 0) {
			res = (Integer) k1 - (Integer) k2;
		}
		return res;
	}
}

public class WissenDeveloper_28_JUL_2018 {

	public static void mainAligningTheRectangles(String[] args) throws IOException {// mainAligningTheRectangles
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L[] = new int[N];
		int R[] = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(tk.nextToken());
			R[i] = Integer.parseInt(tk.nextToken());
		}
		int rect[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			rect[i][0] = L[i];
			rect[i][1] = R[i];
		}
		rect = mergeeSort(rect);
		StringBuilder sb = new StringBuilder();
		StringBuilder newLine = new StringBuilder("\n");
		for (int i = 0; i < N; i++) {
			sb.append(rect[i][0] + " " + rect[i][1]);
			sb.append(newLine);
		}
		System.out.print(sb.toString());

	}

	public static int[][] align_rectangles(int N, int L[], int R[]) {
		int rect[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			rect[i][0] = L[i];
			rect[i][1] = R[i];
		}
		Arrays.sort(rect, new Comparator<int[]>() {
// implement this using custom rectangle class and merge sort 
			@Override
			public int compare(int[] o1, int[] o2) {
				int res = o1[0] - o2[0];
				if (res == 0) {
					// res = o1[1] - o2[1];
					res = o2[1] - o1[1];
				}
				return res;
			}

		});
		return rect;
	}

	public static int[][] mergeeSort(int[][] A) {
		int n = A.length;
		if (n < 2)
			return A;
		int middle = n / 2;
		int left[][] = new int[middle][2];
		int right[][] = new int[n - middle][2];
		for (int i = 0; i < middle; i++) {
			left[i][0] = A[i][0];
			left[i][1] = A[i][1];
		}
		for (int i = middle; i < n; i++) {
			right[i - middle][0] = A[i][0];
			right[i - middle][1] = A[i][1];
		}
		left = mergeeSort(left);
		right = mergeeSort(right);
		A = merge(left, right, A);
		return A;
	}

	public static int[][] merge(int[][] left, int[][] right, int[][] A) {
		int nL = left.length;
		int nR = right.length;
		int i = 0, j = 0, k = 0;
		while (i < nL & j < nR) {
			if (left[i][0] == right[j][0]) {
				if (left[i][1] > right[j][1]) {
					A[k][0] = left[i][0];
					A[k][1] = left[i][1];
					i++;
				} else {
					A[k][0] = right[j][0];
					A[k][1] = right[j][1];
					j++;
				}
			} else if (left[i][0] < right[j][0]) {
				A[k][0] = left[i][0];
				A[k][1] = left[i][1];
				i++;
			} else {
				A[k][0] = right[j][0];
				A[k][1] = right[j][1];
				j++;
			}
			k++;
		}
		while (i < nL) {
			A[k][0] = left[i][0];
			A[k][1] = left[i][1];
			i++;
			k++;
		}
		while (j < nR) {
			A[k][0] = right[j][0];
			A[k][1] = right[j][1];
			j++;
			k++;
		}
		return A;
	}

	public static void mainOneValue2(String[] args) throws IOException {// main OneValue
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

		StringBuilder sb = new StringBuilder();
		StringBuilder newLine = new StringBuilder("\n");
		while (M-- > 0) {
			String line[] = br.readLine().split(" ");
			byte type = Byte.parseByte(line[0]);
			switch (type) {
			case 1: {
				int key = Integer.parseInt(line[1]);
				Integer val = counts.get(key);
				if (val == null) {
					counts.put(key, 1);

				} else {
					counts.put(key, val + 1);
				}
				break;
			}
			case 2: {
				int key = Integer.parseInt(line[1]);
				Integer val = counts.get(key);
				if (val != null) {
					if (val == 1) {
						counts.remove(key);

					} else {
						counts.put(key, val - 1);
					}
				}
				break;
			}
			case 3: {
				sb.append(getType3(counts));
				sb.append(newLine);
				break;
			}
			case 4: {
				try {
					sb.append(getType4(counts));

				} catch (NullPointerException e) {
					sb.append(-1);
				}
				sb.append(newLine);
				break;
			}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int getType3(HashMap<Integer, Integer> counts) {
		int minFreq = Integer.MAX_VALUE;
		int minFreKey = -1;
		for (Map.Entry<Integer, Integer> m : counts.entrySet()) {
			int f = m.getValue();
			if (minFreq > f) {
				minFreq = f;
				minFreKey = m.getKey();
			} else if (minFreq == f && minFreKey < m.getKey()) {
				minFreKey = m.getKey();
			}
		}
		return minFreKey;
	}

	private static int getType4(HashMap<Integer, Integer> counts) {
		int minFreq = Integer.MIN_VALUE;
		int minFreKey = -1;
		for (Map.Entry<Integer, Integer> m : counts.entrySet()) {
			int f = m.getValue();
			if (minFreq < f) {
				minFreq = f;
				minFreKey = m.getKey();
			} else if (minFreq == f && minFreKey > m.getKey()) {
				minFreKey = m.getKey();
			}
		}
		return minFreKey;
	}

	public static void main(String[] args) throws IOException {// main OneValue
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		TreeMap<HashMap<Integer, Integer>, Integer> tmap = new TreeMap<HashMap<Integer, Integer>, Integer>(
				new Comparator<HashMap<Integer, Integer>>() {
					@Override
					public int compare(HashMap<Integer, Integer> o1, HashMap<Integer, Integer> o2) {
						int res = o1.get(getHashMapKey(o1)) - o2.get(getHashMapKey(o2));
						if (res == 0) {
							res = getHashMapKey(o1) - getHashMapKey(o2);
						}
						return res;
					}

				});
		StringBuilder sb = new StringBuilder();
		StringBuilder newLine = new StringBuilder("\n");
		while (M-- > 0) {
			String line[] = br.readLine().split(" ");
			byte type = Byte.parseByte(line[0]);
			switch (type) {
			case 1: {
				int key = Integer.parseInt(line[1]);
				Integer val = counts.get(key);
				HashMap<Integer, Integer> e = new HashMap<Integer, Integer>();
				if (val == null) {
					counts.put(key, 1);
					e.put(key, 1);
					tmap.put(e, 1);
				} else {
					counts.put(key, val + 1);
					e.put(key, val);
					tmap.remove(e);
					e.put(key, val + 1);
					tmap.put(e, val + 1);
				}

				break;
			}
			case 2: {
				int key = Integer.parseInt(line[1]);
				Integer val = counts.get(key);
				HashMap<Integer, Integer> e = new HashMap<Integer, Integer>();
				if (val != null) {
					if (val == 1) {
						e.put(key,val);
						tmap.remove(e);
						counts.remove(key);

					} else {
						counts.put(key, val - 1);
						e.put(key, val);
						tmap.remove(e);
						e.put(key, val - 1);
						tmap.put(e, val - 1);
					}
				}
				break;
			}
			case 3: {
				sb.append(getType3(tmap));
				sb.append(newLine);
				break;
			}
			case 4: {
				try {
					sb.append(getType4(tmap));

				} catch (NullPointerException e) {
					sb.append(-1);
				}
				sb.append(newLine);
				break;
			}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	public static int getType3(TreeMap<HashMap<Integer, Integer>, Integer> tmap) {
		if (tmap.isEmpty() || tmap == null) {
			return -1;
		}
		HashMap<Integer, Integer> maxKeyWithLeastFrequency = tmap.firstKey();
		Integer maxValWithLeastFrequency = maxKeyWithLeastFrequency.get(getHashMapKey(maxKeyWithLeastFrequency));
		for (Map.Entry<HashMap<Integer, Integer>, Integer> i : tmap.entrySet()) {
			maxValWithLeastFrequency = maxKeyWithLeastFrequency.get(getHashMapKey(maxKeyWithLeastFrequency));
			if (maxValWithLeastFrequency != i.getValue()) {
				break;
			} else {
				if (maxValWithLeastFrequency < i.getValue()) {
					maxKeyWithLeastFrequency = i.getKey();
					maxValWithLeastFrequency = i.getValue();
				} else if (maxValWithLeastFrequency == i.getValue()) {
					HashMap<Integer, Integer> i_i = new HashMap<>();
					i_i.put(getHashMapKey(i.getKey()), i.getValue());
					if (getMaxHashMapKey(maxKeyWithLeastFrequency, i_i)) {
						maxKeyWithLeastFrequency = i_i;
					}
				}
			}
		}
		return getHashMapKey(maxKeyWithLeastFrequency);
	}

	public static int getType4(TreeMap<HashMap<Integer, Integer>, Integer> tmap) {
		if (tmap.isEmpty() || tmap == null) {
			return -1;
		}
		HashMap<Integer, Integer> maxKeyWithLeastFrequency = tmap.lastKey();
		Integer maxValWithLeastFrequency = maxKeyWithLeastFrequency.get(getHashMapKey(maxKeyWithLeastFrequency));
		for (HashMap<Integer, Integer> i : tmap.descendingKeySet()) {
			maxValWithLeastFrequency = maxKeyWithLeastFrequency.get(getHashMapKey(maxKeyWithLeastFrequency));
			if (maxValWithLeastFrequency != tmap.get(i)) {
				break;
			} else {
				if (maxValWithLeastFrequency > tmap.get(i)) {
					maxKeyWithLeastFrequency = i;
					maxValWithLeastFrequency = tmap.get(i);
				} else if (maxValWithLeastFrequency == tmap.get(i)) {
					HashMap<Integer, Integer> i_i = new HashMap<>();
					i_i.put(getHashMapKey(i), tmap.get(i));
					if (!getMaxHashMapKey(maxKeyWithLeastFrequency, i_i)) {
						maxKeyWithLeastFrequency = i_i;
					}
				}
			}
		}
		return getHashMapKey(maxKeyWithLeastFrequency);
	}

	public static int getHashMapKey(HashMap<Integer, Integer> m) {
		Iterator<Integer> itr = m.keySet().iterator();
		int a = itr.next();
		return a;
	}

	public static boolean getMaxHashMapKey(HashMap<Integer, Integer> m, HashMap<Integer, Integer> n) {
		Iterator<Integer> itr = m.keySet().iterator();
		Iterator<Integer> itr1 = n.keySet().iterator();
		int f = itr.next();
		int s = itr1.next();

		return f < s;
	}

}
