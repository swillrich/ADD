package de.fu.add;

import java.util.Date;

/**
 * This class represents an implementation for the QuckSort algorithm. The
 * algorithm is implemented as in-place.
 */
public class QuickSort {
	/**
	 * The boundary at which the simple order algorithm should be activated.
	 * Once the partition length comes below this particular value, the QuckSort
	 * algorithm is getting displaced by the BubbleSort algorithm.
	 */
	private int b = 20;
	/**
	 * The sequence to be sorted.
	 */
	private float[] sequence;
	/**
	 * The comparisons are counted by increment this value once a comparison
	 * occurs.
	 */
	private long comparisonCounter = 0;
	/**
	 * The time the algorithm starts
	 */
	private long startTime;
	/**
	 * The time the algorithm terminates
	 */
	private long endTime;

	public QuickSort(float[] sequenz) {
		this.sequence = sequenz;
	}

	public long getComparisons() {
		return comparisonCounter;
	}

	public long getDuration() {
		return ((endTime - startTime));
	}

	/**
	 * Starts the QuckSort algorithm and gets a boundary (see b)
	 */
	public void go(int boundary) {
		this.b = boundary;
		System.out.println("Start QuickSort ...");
		this.startTime = new Date().getTime();
		sort(0, sequence.length - 1);
		this.endTime = new Date().getTime();
	}

	/**
	 * This method performs a QuckSort iteration and is calling recursively.
	 * 
	 * @param start
	 *            at which index the partiton starts
	 * @param stop
	 *            at which index the partion ends
	 */
	private void sort(int start, int stop) {
		addComparison();
		if (start > stop) {
			return;
		}
		addComparison();
		if (stop - start < b) {
			bubbleSort(start, stop);
		} else {
			int pivotIndex = start + (int) ((stop - start) * Math.random());
			float pivot = sequence[pivotIndex];
			int left = start;
			int right = stop;
			while (left <= right) {
				addComparison();
				while (sequence[left] < pivot) {
					left++;
					addComparison();
				}
				addComparison();
				while (sequence[right] > pivot) {
					right--;
					addComparison();
				}
				addComparison();
				if (left <= right) {
					swapAt(left, right);
					left++;
					right--;
				}
				sort(start, right);
				sort(left, stop);
			}
		}
	}

	/**
	 * Every time a comparison occurs, this method counts.
	 */
	private void addComparison() {
		this.comparisonCounter++;
	}

	/**
	 * Applies the BubbleSort algorithm to the specified range (start and stop)
	 * 
	 * @param start
	 * @param stop
	 */
	public void bubbleSort(int start, int stop) {
		for (int n = stop; n > start + 1; n--) {
			for (int i = start; i < n; i++) {
				addComparison();
				if (sequence[i] > sequence[i + 1]) {
					swapAt(i, i + 1);
				}
			}
		}
	}

	/**
	 * Prints out the content of the sequence between the given range.
	 * 
	 * @param l
	 *            left index
	 * @param r
	 *            right index
	 */
	public void printSequence(int l, int r) {
		for (int i = 0; i <= sequence.length - 1; i++) {
			if (i >= l && i <= r) {
				System.out.print(sequence[i] + "\t");
			} else {
				System.out.print("\t");
			}
		}
	}

	/**
	 * Swaps the element at i with the element at j.
	 */
	private void swapAt(int i, int j) {
		float tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
	}

	/**
	 * Prints out some statistics relating the current run.
	 */
	public void printStats() {
		System.out.println("QuickSort terminates!");
		System.out.print("Snipped: ");
		printSequence(0, 10);
		System.out.println();
		System.out.println("Duration: " + getDuration() + " seconds");
		System.out.println("Comparisons: " + this.comparisonCounter);
		System.out.println("Boundary: " + this.b);
	}
}
