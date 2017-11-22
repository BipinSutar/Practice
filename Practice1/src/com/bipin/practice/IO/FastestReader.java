package com.bipin.practice.IO;

import java.io.DataInputStream;
import java.io.IOException;

public class FastestReader {
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int buffer_pointer, bytesRead;

		Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			buffer_pointer = bytesRead = 0;
		}

		public Reader(String fileName) throws IOException {

		}

		public String readLine() throws IOException {
			byte buf[] = new byte[64];
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
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
			if (buffer_pointer == bytesRead)
				fillBuffer();
			return buffer[buffer_pointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, buffer_pointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
