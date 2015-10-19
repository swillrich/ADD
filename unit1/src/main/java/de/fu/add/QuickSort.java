package de.fu.add;

import java.util.Random;

public class QuickSort {
	private int b = 2;
	private float[] sequence;
	private Random random = new Random();

	public QuickSort(float[] sequenz) {
		this.sequence = sequenz;
	}

	public void go() {
		sort(0, sequence.length - 1);
	}

	private void sort(int start, int stop) {
		if (start > stop) {
			return;
		}
		if (stop - start < b) {
			bubbleSort(start, stop);
		} else {
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
				sort(start, right);
				sort(left, stop);
			}
		}
	}

	public void bubbleSort(int start, int stop) {
		for (int n = stop; n > start + 1; n--) {
			for (int i = start; i < n; i++) {
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
}
