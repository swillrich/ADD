package de.fu.add;

public class QuickSort {
	private int b = 2;
	private float[] sequence;

	public QuickSort(float[] sequenz) {
		this.sequence = sequenz;
	}

	public float[] go() {
		sort(0, sequence.length - 1);
		return sequence;
	}

	private void sort(int left, int right) {
		if (right - left <= b) {
			System.out.println(">>Bubblesort");
			for (int n = right; n > left + 1; n--) {
				for (int i = left; i < n - 1; i++) {
					if (sequence[i] > sequence[i + 1]) {
						swapAt(i, i + 1);
					}
				}
			}
		} else {
			int splitIndex = partition(left, right);
			printSequence(0, sequence.length - 1);
			System.out.print("  -->" + left + " " + splitIndex + " (" + sequence[splitIndex] + ") " + right);
			System.out.println();
			sort(left, splitIndex - 1);
			sort(splitIndex, right);
		}
	}

	private void printSequence(int l, int r) {
		for (int i = 0; i <= sequence.length - 1; i++) {
			if (i >= l) {
				System.out.print(sequence[i] + "\t");
			} else {
				System.out.print("\t");
			}
		}
	}

	private int partition(int left, int right) {
		int pivotIndex = left + (int) ((right - left) * Math.random());
		float pivot = sequence[pivotIndex];
		System.out.println("pivot is " + pivot + " = [" + (pivotIndex - left) + "] between " + left + " - " + right);
		int lI = left;
		int rI = right;
		int firstPivotIndex = sequence.length;
		while (lI <= rI) {
			printSequence(left, right);
			System.out.println();
			if (sequence[lI] > pivot) {
				swapAt(rI, lI);
				rI--;
			} else {
				if (firstPivotIndex > lI && pivot == sequence[lI]) {
					firstPivotIndex = lI;
				} else {
					if (firstPivotIndex < sequence.length && sequence[lI] < pivot) {
						swapAt(lI, firstPivotIndex);
						firstPivotIndex = lI;
					}
				}
				lI++;
			}
		}
		return firstPivotIndex;
	}

	private void swapAt(int i, int j) {
		float tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
	}
}
