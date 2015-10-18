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
			if (sequence[right] < sequence[left]) {
				float tmp = sequence[left];
				sequence[left] = sequence[right];
				sequence[right] = tmp;
			}
		} else {
			int splitIndex = partition(left, right);
			sort(left, splitIndex);
			sort(splitIndex, right);
		}
	}

	private int partition(int left, int right) {
		int pivotIndex = (int) ((right - left) * Math.random());
		float pivot = sequence[pivotIndex];
		int lI = left;
		int rI = right;
		while (lI <= rI) {
			if (sequence[lI] > pivot) {
				float tmp = sequence[lI];
				sequence[rI] = sequence[lI];
				sequence[lI] = tmp;
				rI--;
			} else {
				if (sequence[lI] == pivot) {
					pivotIndex = lI;
				}
				lI++;
			}
		}
		return pivotIndex;
	}
}
