package de.fu.add;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int numberOfRuns = 10; // (int) (Math.pow(10, 6) * 20);
		float[] input = new float[numberOfRuns];
		Random random = new Random();
		for (int i = 0; i < numberOfRuns; i++) {
			input[i] = random.nextFloat();
		}
		show(input, "Input");
		new QuickSort(input).go();
		show(input, "Output");
	}

	private static void show(float[] toShow, String desc) {
		System.out.println(desc);
		new QuickSort(toShow).printSequence(0, toShow.length - 1);
	}
}
