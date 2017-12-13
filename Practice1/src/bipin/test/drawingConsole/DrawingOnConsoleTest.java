package bipin.test.drawingConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface ICanvas {
	public void drawBoundryLine(int x1, int y1, int x2, int y2, char fillchar);

	public void drawLine(int x1, int y1, int x2, int y2, char fillchar);

	public boolean isBoundryOrValid(int x1, int y1, int x2, int y2);

	public void drawRectangle(int x1, int y1, int x2, int y2, char fillchar);

	public void fillColor(int x, int y, char fillchar) throws InterruptedException;

	public void printCanvasData();

	public void setFlag(boolean flag);
}

class Canvas implements ICanvas {
	private char[][] canvasData;
	private int w, h;
	private boolean flag;

	Canvas(int w, int h) {
		if (w < 1 || h < 1 || w > 100 || h > 100)
			throw new IllegalArgumentException();
		w += 2;
		h += 2;
		setW(w);
		setH(h);
		canvasData = new char[h][w];
		setFlag(false);
		drawBoundryLine(0, 0, getW() - 1, 0, '-');
		drawBoundryLine(0, 1, 0, getH() - 2, '|');
		drawBoundryLine(0, getH() - 1, getW() - 1, getH() - 1, '-');
		drawBoundryLine(getW() - 1, 1, getW() - 1, getH() - 2, '|');
	}

	@Override
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	@Override
	public void drawBoundryLine(int x1, int y1, int x2, int y2, char fillchar) {
		for (int row = y1; row <= y2; row++) {
			for (int col = x1; col <= x2; col++) {
				canvasData[row][col] = fillchar;
			}
		}
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, char fillchar) {
		setFlag(isBoundryOrValid(x1, y1, x2, y2));
		for (int row = y1; row <= y2; row++) {
			if (row < canvasData.length - 1 && row > 0) {
				for (int col = x1; col <= x2; col++) {
					if (col < canvasData[0].length - 1 && col > 0)
						canvasData[row][col] = fillchar;

				}
			}
		}
	}

	@Override
	public boolean isBoundryOrValid(int x1, int y1, int x2, int y2) {
		if (!flag) {
			if ((x1 == 0) || (x1 == getW()) || (y1 == 0) || (y1 == getH()) || (x1 > x2) || (y1 > y2))
				throw new IndexOutOfBoundsException();
		}
		return true;
	}

	@Override
	public void drawRectangle(int x1, int y1, int x2, int y2, char fillchar) {
		setFlag(isBoundryOrValid(x1, y1, x2, y2));
		drawLine(x1, y1, x1, y2, fillchar);
		drawLine(x1, y1, x2, y1, fillchar);
		drawLine(x2, y1, x2, y2, fillchar);
		drawLine(x1, y2, x2, y2, fillchar);
	}

	@Override
	public void fillColor(int x, int y, char fillchar) throws InterruptedException {
		if (canvasData[y][x] == fillchar || canvasData[y][x] == '|' || canvasData[y][x] == '-'
				|| canvasData[y][x] == 'X') {
			return;
		}

		if (x > 0 || x < getH() || y > 0 || y < getW()) {
			if ((canvasData[y][x] != fillchar) || (canvasData[y][x] != '|') || canvasData[y][x] != '-'
					|| (canvasData[y][x] != 'X'))
				canvasData[y][x] = fillchar;

			fillColor(x + 1, y, fillchar);
			fillColor(x - 1, y, fillchar);
			fillColor(x, y - 1, fillchar);
			fillColor(x, y + 1, fillchar);
		}

	}

	@Override
	public void printCanvasData() {
		for (int i = 0; i < getH(); i++) {
			for (int j = 0; j < getW(); j++) {
				System.out.print(canvasData[i][j]);
			}
			System.out.println();
		}
	}

}

public class DrawingOnConsoleTest {
	private static ICanvas canvas = null;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = new String();

		while (true) {
			try {
				System.out.print("enter command:");
				line = br.readLine().trim();
				String lineSplit[] = line.split(" ");
				char commadtype = lineSplit[0].charAt(0);
				switch (commadtype) {
				case 'C':
					canvas = new Canvas(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
					canvas.printCanvasData();
					break;
				case 'L':
					if (canvas == null)
						throw new NullPointerException();
					canvas.setFlag(false);
					canvas.drawLine(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]),
							Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]), 'X');
					canvas.printCanvasData();
					break;
				case 'R':
					if (canvas == null)
						throw new NullPointerException();
					canvas.setFlag(false);
					canvas.drawRectangle(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]),
							Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]), 'X');
					canvas.printCanvasData();
					break;

				case 'B':
					if (canvas == null)
						throw new NullPointerException();
					canvas.fillColor(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]),
							lineSplit[3].charAt(0));
					canvas.printCanvasData();
					break;
				case 'Q':
					br.close();
					System.exit(0);
				}

			} catch (IOException e) {
				System.out.println("Invalid input");
			} catch (NullPointerException e) {
				System.out.println("Canvas not found. Create a Canvas using 'C' command");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid command");
			} catch (NumberFormatException e) {
				System.out.println("Invalid value for points");
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid canvas size");
			} catch (InterruptedException e) {
				System.out.println("Error occured ");
				e.printStackTrace();
			}
		}
	}
}