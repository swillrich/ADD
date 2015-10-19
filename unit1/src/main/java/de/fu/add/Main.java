package de.fu.add;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		boolean isBigger = true;
		long maximum = 0;
		for (int i = 40; isBigger; i++) {
			int numberOfRuns = 10000; // (int) (Math.pow(10, 6) * 20);
			float[] input = randomizedGeneration(numberOfRuns);
			QuickSort quickSort = new QuickSort(input);
			quickSort.go(i);
			long duration = quickSort.getDuration();
			if (duration > maximum) {
				maximum = duration;
			} else {
				isBigger = false;
				System.out.println("was smaller");
			}
			quickSort.printStats();
			System.out.println();
		}
		System.out.println(maximum);
	}

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
