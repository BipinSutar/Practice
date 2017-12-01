package bipin.test.drawingConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Canvas {
	char[][] canvasData;
	int w, h;

	Canvas(int w, int h) {
		if (w < 1 || h < 1)
			throw new IllegalArgumentException();
		w += 2;
		h += 2;
		this.w = w;
		this.h = h;
		canvasData = new char[h][w];
		drawLine(0, 0, this.w - 1, 0, '-');
		drawLine(0, 1, 0, this.h - 2, '|');
		drawLine(0, this.h - 1, this.w - 1, this.h - 1, '-');
		drawLine(this.w - 1, 1, this.w - 1, this.h - 2, '|');
	}

	public void drawLine(int x1, int y1, int x2, int y2, char fillchar) {
		// System.out.println("x1 " + x1 + " x2 " + x2 + " y1 " + y1 + " y2 " + y2);
		for (int row = y1; row <= y2; row++) {
			for (int col = x1; col <= x2; col++) {
				canvasData[row][col] = fillchar;
			}
		}
	}

	public void printCanvasData() {
		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				System.out.print(canvasData[i][j]);
			}
			System.out.println();
		}
	}

}

public class DrawingOnConsoleTest {
	private static Canvas canvas = null;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = new String();

		while (!line.equals("Q")) {
			try {
				System.out.print("enter command:");
				line = br.readLine().trim();
				process(line);

			} catch (IOException e) {
				System.out.println("Invalid input");
				System.exit(0);
			} catch (NullPointerException e) {
				System.out.println("Canvas not found. Create a canvast using 'C' command");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid points");
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid canvas size");
			}
		}
	}

	private static void process(String line) {
		String lineSplit[] = line.split(" ");
		char commadtype = lineSplit[0].charAt(0);
		switch (commadtype) {
		case 'C':
			canvas = new Canvas(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
			canvas.printCanvasData();
			break;
		case 'R':
			if (canvas == null)
				throw new NullPointerException();
			canvas.drawLine(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]),
					Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]), 'X');
			canvas.printCanvasData();
			break;
		case 'B':
			if (canvas == null)
				throw new NullPointerException();

			canvas.printCanvasData();
			break;
		}
	}

}
