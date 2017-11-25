package com.bipin.practice.hackerearrth._18Nov;

import java.awt.image.BufferStrategy;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class BuyHatkeHarmonicTriplets {
	public static class FastestReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte buffer[];
		private int bufferPointer, bytesRead;

		public FastestReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		FastestReader fs = new FastestReader();
		int t = fs.nextInt();
		int data[];
		while (t-- > 0) {
			int n = fs.nextInt();
			data = new int[n];
			int q = fs.nextInt();
			for (int i = 0; i < n; i++) {
				data[i] = fs.nextInt();
			}
			int query[] = new int[q];
			for (int i = 0; i < q; i++) {
				query[i] = fs.nextInt() - 1;
				getQueryAns_v2(data, query[i] - 1, n);
			}
			// getQueryAns_v1(data, query, n, q);
		}
		fs.close();
	}

	public static void getQueryAns_v1(int data[], int[] query, int n, int q) {
		for (int i = 0; i < q; i++) {
			if (query[i] == 0 | query[i] == data.length - 1) {
				dbg("0");
				continue;
			}
			int temp[] = data;
			Arrays.sort(temp, 0, query[i]);
			int leftmax = temp[query[i] - 1];
			Arrays.sort(temp, query[i] + 1, temp.length);
			for (int ii : data) {
				System.out.print(ii + " ");
			}
			System.out.println();
			for (int ii : temp) {
				System.out.print(ii + " ");
			}
			System.out.println();
			int rightmax = temp[temp.length - 1];
			dbg("leftmax= " + leftmax + " rightmax= " + rightmax + " query[i]= " + query[i]);
			dbg(leftmax * rightmax * query[i] + "");

		}
	}

	public static void dbg(String s) {
		System.out.println(s);
	}

	public static void getQueryAns_v2(int data[], int query, int n) {
		if (query == 0 | query == data.length - 1) {
			dbg("0");
		}
		int temp[] = data;
		Arrays.sort(temp, 0, query);
		int leftmax = temp[query - 1];
		Arrays.sort(temp, query + 1, temp.length);
		// for (int ii : data) {
		// System.out.print(ii + " ");
		// }
		// System.out.println();
		// for (int ii : temp) {
		// System.out.print(ii + " ");
		// }
		// System.out.println();
		//
		int rightmax = temp[temp.length - 1];
		dbg("leftmax= " + leftmax + " rightmax= " + rightmax + " query= " + query);
		dbg(leftmax * rightmax * query + "");

	}
}