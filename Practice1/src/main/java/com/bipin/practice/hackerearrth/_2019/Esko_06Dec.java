package com.bipin.practice.hackerearrth._2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Esko_06Dec {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String firstLine[] = br.readLine().split(",");
		int n = firstLine.length - 1;
		String nLine = " ";
		LinkedHashMap<String, Map<String, Integer>> map = new LinkedHashMap<>();
		Map<String, Integer> rightFreq = new HashMap<>();
		while (n-- > 0) {// while ((nLine = br.readLine()) != null) {
			// String line[] = nLine.split(" ");
			String line[] = br.readLine().split(" ");
			if (line.length < 4) {
				continue;
			}
			Map<String, Integer> in = new HashMap<>();
			in.put(line[3], Integer.parseInt(line[2]));
			map.put(line[0], in);
			if (rightFreq.containsKey(line[3])) {
				rightFreq.put(line[3], rightFreq.get(line[3]) + 1);
			} else {
				rightFreq.put(line[3], 1);
			}
		}
		String last = null;
		for (int i = 0; i < firstLine.length; i++) {
			if (last == null && !map.containsKey(firstLine[i])) {
				last = firstLine[i];
				break;
			}
		}
		System.out.println("last " + last);
		LinkedHashMap<String, Map<String, Integer>> ans = new LinkedHashMap<>();
		LinkedHashMap<String, Map<String, Integer>> Revans = new LinkedHashMap<>();
		while (ans.size() != firstLine.length - 1) {
			// try get min relation

			int min = Integer.MAX_VALUE;
			String anskey = null;

			for (int i = 0; i < firstLine.length; i++) {
				if (firstLine[i].equals(last)) {
					continue;
				}
				if (map.containsKey(firstLine[i])) {
					int currval = map.get(firstLine[i]).values().iterator()
							.next();
					String currkey = map.get(firstLine[i]).keySet().iterator()
							.next();
					if (currval < min && last.equals(currkey)) {
						min = currval;
						anskey = firstLine[i];
					}
				}
			}
			Map<String, Integer> in = new HashMap<>();
			Map<String, Integer> rev = new HashMap<>();
			if(Revans.containsKey(last)) {
				anskey = Revans.get(last).keySet().iterator().next();
				int temp = Revans.get(last).values().iterator().next();
				min = min / temp;
			}
			in.put(last, min);
			ans.put(anskey, in);
			map.remove(anskey);
			rightFreq.put(last, rightFreq.get(last) - 1);
			for (int i = 0; i < firstLine.length; i++) {
				if (rightFreq.get(last) < 1 && !map.containsKey(firstLine[i])) {
					last = firstLine[i];
					break;
				}
			}
			System.out.println("last " + last);

		}

		br.close();
	}

}
