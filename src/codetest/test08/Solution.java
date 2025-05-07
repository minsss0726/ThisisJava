package codetest.test08;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

class Solution {

	public double gridCheck(int startX, int startY, int ballX, int ballY, double[] startDot, double[] incrDot, int m,
			int n) {
		ArrayList<Double> gridList = new ArrayList<>();

		BigDecimal startGrid;
		BigDecimal ballGrid;

		if (incrDot[0] == 1) {
			BigDecimal incrX = new BigDecimal(incrDot[0]);
			double dev = 1;
			Run1: while (gridList.size() < 1) {
				for (incrX.doubleValue(); incrX.doubleValue() < m; incrX = incrX.add(incrX)) {
					System.out.println(incrX);
					if (incrX.doubleValue() != startX && incrX.doubleValue() != ballX) {
						startGrid = ((new BigDecimal(startDot[1])).subtract(new BigDecimal(startY)))
								.divide(incrX.subtract(new BigDecimal(startX)), MathContext.DECIMAL128).abs();
						ballGrid = ((new BigDecimal(startDot[1])).subtract(new BigDecimal(ballY)))
								.divide(incrX.subtract(new BigDecimal(ballX)), MathContext.DECIMAL128).abs();
						System.out.println(startGrid + " " + ballGrid);
						if (startGrid.compareTo(ballGrid) == 0) {
							gridList.add(startGrid.doubleValue());
							break Run1;
						}
					} else {

					}
				}

				if (dev != 0) {
					incrX = (new BigDecimal(incrDot[0])).divide(new BigDecimal(dev), MathContext.DECIMAL128);
					dev /= 10;
				}
			}
			System.out.println(gridList);

		} else {
			// Run2: while (gridList.size() < 1) {

			// }

		}
		System.out.println(gridList);
		return 0.0;
	}

	public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = {};

		for (int[] ball : balls) {

			int[] lineDistance = new int[4]; // 0-up,1-left,2-down,3-right

			if (startY != ball[1]) {
				lineDistance[1] = startX + ball[0];
			} else {
				lineDistance[1] = Integer.MAX_VALUE;
			}

			if (startX != ball[0]) {
				lineDistance[2] = startY + ball[1];
			} else {
				lineDistance[2] = Integer.MAX_VALUE;
			}

			if (startY != ball[1]) {
				lineDistance[3] = (m - startX) + (m - ball[0]);
			} else {
				lineDistance[3] = Integer.MAX_VALUE;
			}

			if (startX != ball[0]) {
				lineDistance[0] = (n - startY) + (n - ball[1]);
			} else {
				lineDistance[0] = Integer.MAX_VALUE;
			}

			// System.out.println(Arrays.toString(lineDistance));

			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < 4; i++) {
				if (lineDistance[i] < min) {
					min = lineDistance[i];
					index = i;
				}
			}

			// System.out.println(index);

			double[] startDot;
			double[] incrDot;
			switch (index) {
			case 0:
				startDot = new double[] { 0, n };
				incrDot = new double[] { 1, 0 };
				gridCheck(startX, startY, ball[0], ball[1], startDot, incrDot, m, n);
				break;
			case 1:
				startDot = new double[] { 0, 0 };
				incrDot = new double[] { 0, 1 };
				gridCheck(startX, startY, ball[0], ball[1], startDot, incrDot, m, n);
				break;
			case 2:
				startDot = new double[] { 0, 0 };
				incrDot = new double[] { 1, 0 };
				gridCheck(startX, startY, ball[0], ball[1], startDot, incrDot, m, n);
				break;
			case 3:
				startDot = new double[] { m, 0 };
				incrDot = new double[] { 0, 1 };
				gridCheck(startX, startY, ball[0], ball[1], startDot, incrDot, m, n);
				break;
			}

		}
		return answer;
	}

}