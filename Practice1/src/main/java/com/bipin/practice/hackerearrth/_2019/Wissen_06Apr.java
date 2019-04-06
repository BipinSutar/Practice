package com.bipin.practice.hackerearrth._2019;

import java.util.HashSet;
import java.util.Set;

public class Wissen_06Apr {
	final class SubArrayPositionAns {
		final private int L;
		final private int R;
		final static private String SPACE = " ";
		public SubArrayPositionAns(int L, int R) {
			this.L = L;
			this.R = R;
		}
		public int getL() {
			return L;
		}
		public int getR() {
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
			result = prime * result + getOuterType().hashCode();
			result = prime * result + L;
			result = prime * result + R;
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
			SubArrayPositionAns other = (SubArrayPositionAns) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (L != other.L)
				return false;
			if (R != other.R)
				return false;
			return true;
		}
		private Wissen_06Apr getOuterType() {
			return Wissen_06Apr.this;
		}

	}
	public static void main(String[] args) {

	}
	public Set<SubArrayPositionAns> getSubArrayPositionAns(final int arr[]) {
		Set<SubArrayPositionAns> subArrPositions = new HashSet<>();
		double sumArr = 0;
		for (int i = 0; i < arr.length; i++) {
			sumArr += arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			double sumSubArr = 0.0d;
			double remainSum = 0.0d;
			double remainAvg = 0.0d;
			for (int j = i; j < arr.length; j++) {
				sumSubArr = sumSubArr + arr[j];
				double avgSubArr = sumSubArr / ((j - i) + 1.0d);
				remainSum = sumArr - sumSubArr;
				remainAvg = remainSum == 0
						? 0
						: remainSum / (arr.length - j + i - 1);
				if (avgSubArr > remainAvg) {
					subArrPositions.add(new SubArrayPositionAns(i + 1, j + 1));
				}
			}
		}
		return subArrPositions;
	}
}
