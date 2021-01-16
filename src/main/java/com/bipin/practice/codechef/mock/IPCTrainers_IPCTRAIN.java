package com.bipin.practice.codechef.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IPCTrainers_IPCTRAIN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			PriorityQueue<Trainer> pq = new PriorityQueue<>(
					(o1, o2) -> Integer.compare(o2.sadness, o1.sadness));
			String line[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(line[0].trim());
			int d = Integer.parseInt(line[1].trim());
			long totalsadness = 0;
			Map<Integer, ArrayList<Trainer>> totalTrainersForDay = new HashMap<>();
			for (int i = 1; i < 1000001; i++) {
				totalTrainersForDay.put(i, new ArrayList<>());
			}
			for (int i = 0; i < n; i++) {
				line = br.readLine().trim().split(" ");
				int arrivalDay = Integer.parseInt(line[0].trim());
				int numberOfLectures = Integer.parseInt(line[1].trim());
				int sadness = Integer.parseInt(line[2].trim());
				Trainer trainer = new Trainer(arrivalDay, numberOfLectures,
						sadness);
				totalTrainersForDay.get(arrivalDay).add(trainer);
			}
			for (int i = 1; i <= d; i++) {
				for (Trainer trainer : totalTrainersForDay.get(i)) {
					pq.add(trainer);
				}
				if (pq.isEmpty()) {
					continue;
				}
				pq.peek().numberOfLectures--;
				if (pq.peek().numberOfLectures == 0) {
					pq.poll();
				}
			}
			for (Trainer trainer : pq) {
				totalsadness = totalsadness + ((long) trainer.numberOfLectures
						* (long) trainer.sadness);
			}
			sb.append(totalsadness + "\n");
		}
		System.out.println(sb.toString());
		br.close();

	}
}
class Trainer {
	int arrivalDay;
	int numberOfLectures;
	int sadness;
	public Trainer(int arrivalDay, int numberOfLectures, int sadness) {
		super();
		this.arrivalDay = arrivalDay;
		this.numberOfLectures = numberOfLectures;
		this.sadness = sadness;
	}
	@Override
	public String toString() {
		return "Trainer [arrivalDay=" + arrivalDay + ", numberOfLectures="
				+ numberOfLectures + ", sadness=" + sadness + "]";
	}

}
