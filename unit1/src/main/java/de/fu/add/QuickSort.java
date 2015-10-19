package de.fu.add;

import java.util.Random;

public class QuickSort {
	private int b = 2;
	private float[] sequence;
	private Random random = new Random();

	public QuickSort(float[] sequenz) {
		this.sequence = sequenz;
	}

	public float[] go() {
		sort(0, sequence.length - 1);
		return sequence;
	}

	private void sort(int start, int stop) {
		if (start > stop) {
			return;
		}
		System.out.print(start + " - " + stop + ": ");
		// if (stop - start < b) {
		// System.out.print("Bubblesort");
		// System.out.println();
		// bubbleSort(start, stop);
		// } else {
		if (stop - start > 0) {
			int pivotIndex = start + random.nextInt(stop - start);
			float pivot = sequence[pivotIndex];
			int left = start;
			int right = stop;
			while (left <= right) {
				while (sequence[left] < pivot) {
					left++;
				}
				while (sequence[right] > pivot) {
					right--;
				}
				if (left <= right) {
					swapAt(left, right);
					left++;
					right--;
				}
				// }
				System.out.print("partitioning with " + right + " and " + left
						+ " --> {");
				printSequence(0, sequence.length - 1);
				System.out.print("}");
				System.out.println();
				sort(start, right);
				sort(left, stop);
			}
		}
		printSequence(start, stop);
		System.out.println();
	}

	private void bubbleSort(int start, int stop) {
		for (int n = stop; n > start + 1; n--) {
			for (int i = start; i < n - 1; i++) {
				if (sequence[i] > sequence[i + 1]) {
					swapAt(i, i + 1);
				}
			}
		}
	}

	private void printSequence(int l, int r) {
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
}
