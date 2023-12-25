package com.bipin.practice.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {
	PriorityQueue<Integer> maxHeap, minHeap;

	public MedianOfStream() {
		this.maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		this.minHeap = new PriorityQueue<Integer>();
	}

	public void add(Integer num) {
		if (minHeap.size() == maxHeap.size()) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		} else {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
	}

	public int getMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		return (minHeap.peek() + maxHeap.peek()) / 2;

	}

	public static void main(String[] args) {
		int arr[] = { 20, 50, 25, 100, 70, 60 };
		MedianOfStream medianOfStream = new MedianOfStream();
		for (int i : arr) {
			medianOfStream.add(i);
			System.out.println(medianOfStream);
			System.out.println(medianOfStream.getMedian());
		}
	}

	@Override
	public String toString() {
		return "maxHeap=" + maxHeap + " ;  minHeap=" + minHeap;
	}

}
