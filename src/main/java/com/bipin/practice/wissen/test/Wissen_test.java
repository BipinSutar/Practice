package com.bipin.practice.wissen.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Wissen_test {
	public static class AggregatorImpl implements Aggregator {
		String symbol;
		double price;
		ArrayList<AggregatorImpl> list = new ArrayList<>();

		@Override
		public void add(String symbol, double price) {
			AggregatorImpl obj = new AggregatorImpl();
			obj.symbol = symbol;
			obj.price = price;
			list.add(obj);

		}

		@Override
		public double getAvgofSymbol(String symbol) {
			Iterator<AggregatorImpl> itr = list.iterator();
			double sum = 0.0;
			int count = 0;
			while (itr.hasNext()) {
				AggregatorImpl obj = (AggregatorImpl) itr.next();
				if (obj.symbol.equals(symbol)) {
					sum += obj.price;
					count++;
				}
			}
			return count == 0 ? 0 : sum / count;
		}

		@Override
		public int getCountofSymbol(String symbol) {
			Iterator<AggregatorImpl> itr = list.iterator();

			int count = 0;
			while (itr.hasNext()) {
				AggregatorImpl obj = (AggregatorImpl) itr.next();
				if (obj.symbol.equals(symbol)) {
					count++;
				}
			}
			return count;
		}

	}

	public interface Aggregator {
		public void add(String symbol, double price);

		public double getAvgofSymbol(String symbol);

		public int getCountofSymbol(String symbol);
	}

	public static void main(String[] args) {
		final AggregatorImpl aggregatorImpl = new AggregatorImpl();
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			String line = sc.nextLine();
			String l_split[] = line.split(" ");

			new Thread() {
				@Override
				public void run() {
					aggregatorImpl.add(l_split[0], Double.parseDouble(l_split[1]));
				}
			}.start();

		}
		System.out.println(aggregatorImpl.getAvgofSymbol("APPL"));
		System.out.println(aggregatorImpl.getCountofSymbol("DIGX"));
		sc.close();
	}
}
