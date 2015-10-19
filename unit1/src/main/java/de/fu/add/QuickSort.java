package de.fu.add;

import java.util.Date;
import java.util.Random;

public class QuickSort {
	private int b = 20;
	private float[] sequence;
	private Random random = new Random();
	long comparisonCounter = 0;
	long start;
	long end;

	public QuickSort(float[] sequenz) {
		this.sequence = sequenz;
	}
	
	public long getComparisons() {
		return comparisonCounter;
	}

	public long getDuration() {
		return ((end - start));
	}

	public void go(int boundary) {
		this.b = boundary;
		System.out.println("Start QuickSort ...");
		this.start = new Date().getTime();
		sort(0, sequence.length - 1);
		this.end = new Date().getTime();
	}

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

	private void addComparison() {
		this.comparisonCounter++;
	}

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

	public void printSequence(int l, int r) {
		for (int i = 0; i <= sequence.length - 1; i++) {
			if (i >= l && i <= r) {
				System.out.print(sequence[i] + "\t");
			} else {
				System.out.print("\t");
			}
		}
	}

	private void swapAt(int i, int j) {
		float tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
	}

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
