package de.fu.add;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dnl.utils.text.table.TextTable;

/**
 * This class executes the samples and test the code and consists of the main
 * method.
 */
public class Main {
	public static void main(String[] args) {
		// bestBoundary();
		severalRuns();
	}

	/**
	 * Executes several runs with different input with consistent length.
	 */
	private static void severalRuns() {
		Object[][] data = new Object[20][];
		int n = 2000;
		for (int i = 0; i < data.length; i++) {
			float[] input = randomizedGeneration(n);
			QuickSort quickSort = new QuickSort(input);
			quickSort.go(50);
			data[i] = new Object[] { n, quickSort.getDuration(), quickSort.getComparisons() };
		}
		String[] columnNames = { "N", "duration in ms", "# of Comparisons" };
		TextTable tt = new TextTable(columnNames, data);
		tt.setAddRowNumbering(true);
		tt.printTable();
	}

	/**
	 * Executes several runs in order to find an optimal boundary (b). After an
	 * optimal boundary is found, the next three runs follows and the process
	 * terminates.
	 */
	private static void bestBoundary() {
		int numberOfRuns = 3000; // (int) (Math.pow(10, 6) * 20);
		float[] origin = randomizedGeneration(numberOfRuns);
		long maximum = 0;
		float[] input;
		List<Object[]> tmpList = new ArrayList<Object[]>();
		for (int i = 100, after = 1; after < 4; i = i + 50) {
			input = Arrays.copyOf(origin, origin.length);
			QuickSort quickSort = new QuickSort(input);
			quickSort.go(i);
			long duration = quickSort.getDuration();
			if (duration > maximum) {
				maximum = duration;
			} else {
				after++;
			}
			tmpList.add(new Object[] { numberOfRuns, i, duration, quickSort.getComparisons() });
		}
		Object[][] data = new Object[6][];
		for (int i = (tmpList.size() >= 7 ? tmpList.size() - 7 : 0), arrI = 0; i < tmpList.size()
				&& arrI < data.length; i++, arrI++) {
			data[arrI] = new Object[tmpList.get(i).length];
			for (int j = 0; j < data[arrI].length; j++) {
				data[arrI][j] = tmpList.get(i)[j];
			}
		}
		String[] columnNames = { "N", "B", "duration (ms)", "# of Comparisons" };
		TextTable tt = new TextTable(columnNames, data);
		tt.setSort(1);
		tt.setAddRowNumbering(true);
		tt.printTable();
	}

	/**
	 * Generates randomized content for the input (float array).
	 */
	private static float[] randomizedGeneration(int numberOfRuns) {
		float[] input = new float[numberOfRuns];
		Random random = new Random();
		double mean = 100.00f;
		for (int i = 0; i < numberOfRuns; i++) {
			input[i] = (float) (mean + random.nextGaussian() * 5.0f);
		}
		return input;
	}
}
